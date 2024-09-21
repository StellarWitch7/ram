package stellarwitch7.ram.spell.cell

import dev.enjarai.trickster.spell.Fragment
import io.wispforest.endec.Endec
import io.wispforest.endec.StructEndec
import io.wispforest.endec.impl.StructEndecBuilder

data class Cell(var locked: Boolean, var value: Fragment) {
    companion object {
        val endec: StructEndec<Cell> = StructEndecBuilder.of(
            Endec.BOOLEAN.fieldOf("locked", Cell::locked),
            Fragment.ENDEC.fieldOf("value", Cell::value),
            ::Cell
        )
    }
}
