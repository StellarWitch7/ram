package stellarwitch7.ram.cca

import stellarwitch7.libstellar.registry.cca.CCAGenericComponentRegistrar
import stellarwitch7.ram.RandomAccessMind

object ModComponents : CCAGenericComponentRegistrar {
    override val modID: String = RandomAccessMind.MOD_ID

    val ram = makeKey("ram", RAMComponent::class)
}