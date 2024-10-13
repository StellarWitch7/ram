package stellarwitch7.ram.spell.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class RAMNotSupportedBlunder(source: Trick) extends TrickBlunderException(source) {
  override def createMessage(): MutableText =
    super.createMessage().append("Caster does not support RAM")
}
