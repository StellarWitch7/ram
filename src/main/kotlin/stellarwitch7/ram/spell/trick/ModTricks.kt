package stellarwitch7.ram.spell.trick

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.Tricks
import net.minecraft.registry.Registry
import stellarwitch7.libstellar.registry.Registrar
import stellarwitch7.ram.RandomAccessMind
import stellarwitch7.ram.spell.trick.mind.RAMAllocTrick
import stellarwitch7.ram.spell.trick.mind.RAMFreeTrick
import stellarwitch7.ram.spell.trick.mind.RAMReadTrick
import stellarwitch7.ram.spell.trick.mind.RAMWriteTrick

object ModTricks : Registrar<Trick> {
    override val modID: String = RandomAccessMind.MOD_ID
    override val registry: Registry<Trick> = Tricks.REGISTRY

    val alloc = register("alloc", RAMAllocTrick())
    val free = register("free", RAMFreeTrick())
    val read = register("read", RAMReadTrick())
    val write = register("write", RAMWriteTrick())
}