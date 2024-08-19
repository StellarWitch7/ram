package stellarwitch7.ram.spell.mind

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.libstellar.registry.codec.CodecType
import stellarwitch7.libstellar.utils.KCodecUtils
import stellarwitch7.ram.spell.trick.blunder.NotWithinRAMBoundsBlunder
import stellarwitch7.ram.spell.trick.blunder.OutOfRAMBlunder

open class DefaultRAM(val size: UInt) : RAM {
    override val type: CodecType<RAM> = RAM.default
    protected var slots = Array(size.toInt(), { _ -> RAMSlot(true, VoidFragment.INSTANCE) })

    private constructor(size: UInt, slots: List<RAMSlot>) : this(size) {
        this.slots = slots.toTypedArray()
    }

    override fun alloc(source: Trick): UInt {
        for ((i, slot) in slots.withIndex()) {
            if (slot.free) {
                slot.free = false
                return i.toUInt()
            }
        }

        throw OutOfRAMBlunder(source)
    }

    override fun free(source: Trick, address: Int) {
        if (address < 0 || address >= slots.size)
            throw NotWithinRAMBoundsBlunder(source, slots.size.toUInt(), address.toDouble())

        slots[address].free = true
    }

    override fun write(source: Trick, address: Int, value: Fragment) {
        if (address < 0 || address >= slots.size)
            throw NotWithinRAMBoundsBlunder(source, slots.size.toUInt(), address.toDouble())

        slots[address].value = value
    }

    override fun read(source: Trick, address: Int): Fragment {
        if (address < 0 || address >= slots.size)
            throw NotWithinRAMBoundsBlunder(source, slots.size.toUInt(), address.toDouble())

        return slots[address].value
    }
    
    companion object {
        val codec: MapCodec<DefaultRAM> = RecordCodecBuilder.mapCodec { builder ->
            builder.group(
                KCodecUtils.uIntCodec.fieldOf("size").forGetter(DefaultRAM::size),
                RAMSlot.codec.listOf().fieldOf("slots").forGetter { it.slots.asList() }
            ).apply(builder, ::DefaultRAM)
        }
    }
}