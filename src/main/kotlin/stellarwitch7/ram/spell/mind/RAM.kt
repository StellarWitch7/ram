package stellarwitch7.ram.spell.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.trick.Trick
import net.minecraft.registry.Registry
import stellarwitch7.libstellar.registry.codec.CodecRegistrar
import stellarwitch7.libstellar.registry.codec.CodecType
import stellarwitch7.libstellar.registry.codec.CodecTypeProvider
import stellarwitch7.ram.RandomAccessMind

interface RAM : CodecTypeProvider<RAM> {
    fun alloc(source: Trick): UInt

    fun free(source: Trick, address: Int)

    fun write(source: Trick, address: Int, value: Fragment)

    fun read(source: Trick, address: Int): Fragment

    companion object : CodecRegistrar<RAM> {
        override val modID: String = RandomAccessMind.MOD_ID
        override val registry: Registry<CodecType<RAM>> = makeReg("ram")

        val default = register("default", DefaultRAM.codec)
    }
}