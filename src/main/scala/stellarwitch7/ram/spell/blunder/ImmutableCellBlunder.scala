package stellarwitch7.ram.spell.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class ImmutableCellBlunder(source: Trick) extends TrickBlunderException(source) {
    override def createMessage(): MutableText =
      super.createMessage().append("Cannot write to cell as it has already been written to")
}
