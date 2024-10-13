package stellarwitch7.ram.cca.world

import dev.enjarai.trickster.EndecTomfoolery
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import io.wispforest.endec.Endec
import io.wispforest.endec.StructEndec
import io.wispforest.endec.impl.KeyedEndec
import io.wispforest.endec.impl.StructEndecBuilder
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper
import net.minecraft.world.World
import org.ladysnake.cca.api.v3.component.Component
import stellarwitch7.ram.spell.fragment.CellFragment
import stellarwitch7.ram.spell.blunder.CellNotWithinWorldBlunder
import stellarwitch7.ram.spell.blunder.ImmutableCellBlunder
import scala.collection.mutable.HashMap
import java.util.UUID
import scala.collection.JavaConverters._

class CellsComponent(private val world: World) extends Component {
  private val cells: HashMap[UUID, Cell] = HashMap()

  override def readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup): Unit =
    cells.addAll(tag.get(CellsComponent.endec).asScala)

  override def writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup): Unit =
    tag.put(CellsComponent.endec, cells.asJava)

  def acquireCell(): CellFragment = {
    var uuid = UUID.randomUUID()

    while (cells.contains(uuid)) {
      uuid = UUID.randomUUID()
    }

    cells.put(uuid, Cell(false, VoidFragment.INSTANCE))
    CellFragment(uuid)
  }

  def writeCell(source: Trick, uuid: UUID, value: Fragment): Unit =
    cells.get(uuid).map(cell =>
      if cell.locked then
        throw ImmutableCellBlunder(source)
      else
        cell.locked = true
        cell.value = value
    ).getOrElse(throw CellNotWithinWorldBlunder(source))

  def readCell(source: Trick, uuid: UUID): Fragment =
    cells.get(uuid).map(_.value).getOrElse(throw CellNotWithinWorldBlunder(source))  
}

object CellsComponent {
  val endec: KeyedEndec[java.util.Map[UUID, Cell]] = KeyedEndec("cells", Endec.map(EndecTomfoolery.UUID, Cell.endec), new java.util.HashMap())
}

private class Cell(var locked: Boolean, var value: Fragment) { }

private object Cell {
  val endec: StructEndec[Cell] = StructEndecBuilder.of(
    Endec.BOOLEAN.fieldOf("locked", _.locked),
    Fragment.ENDEC.fieldOf("value", _.value),
    new Cell(_, _)
  )
}
