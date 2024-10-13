package stellarwitch7.ram.spell.fragment

import dev.enjarai.trickster.EndecTomfoolery
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.fragment.BooleanFragment
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import io.wispforest.endec.StructEndec
import io.wispforest.endec.impl.StructEndecBuilder
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import java.util.UUID
import stellarwitch7.ram.cca.world.ModWorldComponents

class CellFragment(val uuid: UUID) extends Fragment {
  def get(source: Trick, world: ServerWorld): Fragment =
    ModWorldComponents.cells.get(world).readCell(source, uuid)

  def set(source: Trick, world: ServerWorld, value: Fragment) =
    ModWorldComponents.cells.get(world).writeCell(source, uuid, value)

  override def `type`(): FragmentType[?] = ModFragmentTypes.cell
  override def asText(): Text = Text.literal(uuid.toString())
  override def asBoolean(): BooleanFragment = BooleanFragment.TRUE
}

object CellFragment {
  val endec: StructEndec[CellFragment] = StructEndecBuilder.of(
    EndecTomfoolery.UUID.fieldOf("uuid", _.uuid),
    CellFragment(_)
  )
}
