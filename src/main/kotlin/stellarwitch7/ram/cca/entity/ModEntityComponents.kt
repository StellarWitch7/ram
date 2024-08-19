package stellarwitch7.ram.cca.entity

import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy
import stellarwitch7.libstellar.registry.cca.entity.CCAEntityComponentRegistrar
import stellarwitch7.ram.RandomAccessMind
import stellarwitch7.ram.cca.RAMComponent

object ModEntityComponents : CCAEntityComponentRegistrar() {
    override val modID: String = RandomAccessMind.MOD_ID

    val ram = register("ram", RAMComponent::class, ::RAMComponent, RespawnCopyStrategy.LOSSLESS_ONLY)
}