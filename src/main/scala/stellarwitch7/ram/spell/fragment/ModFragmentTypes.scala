package stellarwitch7.ram.spell.fragment

import dev.enjarai.trickster.spell.fragment.FragmentType
import net.minecraft.registry.Registry
import stellarwitch7.libstellar.registry.Registrar
import stellarwitch7.ram.RandomAccessMind
import java.util.*

object ModFragmentTypes extends Registrar[FragmentType[?]] {
  override val modID: String = RandomAccessMind.MOD_ID
  override val registry: Registry[FragmentType[?]] = FragmentType.REGISTRY

  val cell: FragmentType[CellFragment] = register("cell", FragmentType(CellFragment.endec, OptionalInt.empty()))
}
