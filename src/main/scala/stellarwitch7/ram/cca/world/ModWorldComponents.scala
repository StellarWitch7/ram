package stellarwitch7.ram.cca.world

import org.ladysnake.cca.api.v3.component.ComponentKey
import stellarwitch7.libstellar.registry.cca.world.CCAWorldComponentRegistrar
import stellarwitch7.ram.RandomAccessMind

object ModWorldComponents extends CCAWorldComponentRegistrar() {
  override val modID: String = RandomAccessMind.MOD_ID

  val cells: ComponentKey[CellsComponent] = register("cells", classOf[CellsComponent], CellsComponent(_), None)
}
