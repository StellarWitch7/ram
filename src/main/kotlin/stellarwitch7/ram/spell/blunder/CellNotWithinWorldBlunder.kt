package stellarwitch7.ram.spell.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class CellNotWithinWorldBlunder(source: Trick) : TrickBlunderException(source) {
    override fun createMessage(): MutableText {
        return super.createMessage().append("Cell cannot be accessed as it does not exist")
    }
}