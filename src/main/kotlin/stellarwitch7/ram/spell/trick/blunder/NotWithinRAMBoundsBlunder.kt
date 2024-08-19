package stellarwitch7.ram.spell.trick.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class NotWithinRAMBoundsBlunder(source: Trick, private val max: UInt, private val given: Double) : TrickBlunderException(source) {
    override fun createMessage(): MutableText {
        return super.createMessage()
            .append("Invalid RAM slot address. Got ")
            .append("{}".format(given))
            .append(", but must be greater or equal to zero and lesser than ")
            .append("{}".format(max))
    }
}