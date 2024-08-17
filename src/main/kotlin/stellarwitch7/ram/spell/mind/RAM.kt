package stellarwitch7.ram.spell.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.trick.Trick
import net.minecraft.registry.Registry
import stellarwitch7.libstellar.registry.codec.CodecRegistrar
import stellarwitch7.libstellar.registry.codec.CodecType
import stellarwitch7.libstellar.registry.codec.CodecTypeProvider
import stellarwitch7.ram.RandomAccessMind

interface RAM : CodecTypeProvider<RAM> {
    fun malloc(source: Trick): UInt

    fun free(address: UInt)

    fun write(address: UInt, value: Fragment)

    fun read(address: UInt): Fragment

    companion object : CodecRegistrar<RAM> {
        override val modID: String = RandomAccessMind.MOD_ID
        override val name: String = "ram"
        override val registry: Registry<CodecType<RAM>> = makeReg()

        val default = register("default", DefaultRAM.codec)
    }
}