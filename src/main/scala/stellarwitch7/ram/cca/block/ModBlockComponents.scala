package stellarwitch7.ram.cca.block

import dev.enjarai.trickster.block.SpellCircleBlockEntity
import stellarwitch7.libstellar.registry.cca.block.CCABlockComponentRegistrar
import stellarwitch7.ram.RandomAccessMind
import stellarwitch7.ram.cca.ModComponents
import stellarwitch7.ram.cca.RAMComponent

object ModBlockComponents extends CCABlockComponentRegistrar() {
  override val modID: String = RandomAccessMind.MOD_ID

  val ram = register[RAMComponent, SpellCircleBlockEntity](ModComponents.ram, RAMComponent(_), classOf[SpellCircleBlockEntity])
}
