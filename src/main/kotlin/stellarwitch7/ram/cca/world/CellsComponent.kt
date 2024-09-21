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
import java.util.*
import kotlin.collections.HashMap

class CellsComponent(private val world: World) : Component {
    private var cells: MutableMap<UUID, Cell> = HashMap()

    override fun readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        cells = tag.get(endec)
    }

    override fun writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        tag.put(endec, cells)
    }

    fun acquireCell(): CellFragment {
        var uuid = UUID.randomUUID()

        while (cells.contains(uuid)) {
            uuid = UUID.randomUUID()
        }

        cells[uuid] = Cell(false, VoidFragment.INSTANCE)
        return CellFragment(uuid)
    }

    fun writeCell(source: Trick, uuid: UUID, value: Fragment) {
        val cell = cells[uuid] ?: throw CellNotWithinWorldBlunder(source)
        if (cell.locked) throw ImmutableCellBlunder(source)
        cell.locked = true
        cell.value = value
    }

    fun readCell(source: Trick, uuid: UUID): Fragment {
        val cell = cells[uuid] ?: throw CellNotWithinWorldBlunder(source)
        return cell.value
    }

    companion object {
        val endec: KeyedEndec<MutableMap<UUID, Cell>> = KeyedEndec("cells", Endec.map(EndecTomfoolery.UUID, Cell.endec), HashMap())
    }

    data class Cell(var locked: Boolean, var value: Fragment) {
        companion object {
            val endec: StructEndec<Cell> = StructEndecBuilder.of(
                Endec.BOOLEAN.fieldOf("locked", Cell::locked),
                Fragment.ENDEC.fieldOf("value", Cell::value),
                ::Cell
            )
        }
    }
}