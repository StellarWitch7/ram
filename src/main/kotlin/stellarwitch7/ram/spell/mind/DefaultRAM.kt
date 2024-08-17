package stellarwitch7.ram.spell.mind

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.libstellar.registry.codec.CodecType
import stellarwitch7.libstellar.utils.KCodecUtils
import stellarwitch7.ram.spell.trick.blunder.OutOfRAMBlunder

open class DefaultRAM(val size: UInt) : RAM {
    override val type: CodecType<RAM> = RAM.default
    protected var slots = Array(size.toInt(), { _ -> RAMSlot(true, VoidFragment.INSTANCE) })

    private constructor(size: UInt, slots: List<RAMSlot>) : this(size) {
        this.slots = slots.toTypedArray()
    }

    override fun malloc(source: Trick): UInt {
        for ((i, slot) in slots.withIndex()) {
            if (slot.free)
                slot.free = false
                return i.toUInt()
        }

        throw OutOfRAMBlunder(source)
    }

    override fun free(address: UInt) {
        slots[address.toInt()].free = true
    }

    override fun write(address: UInt, value: Fragment) {
        slots[address.toInt()].value = value
    }

    override fun read(address: UInt): Fragment {
        return slots[address.toInt()].value
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