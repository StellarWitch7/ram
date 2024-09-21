package stellarwitch7.ram.spell.trick.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class ImmutableCellBlunder(source: Trick) : TrickBlunderException(source) {
    override fun createMessage(): MutableText {
        return super.createMessage().append("Cannot write to cell as it has already been written to")
    }
}