package stellarwitch7.ram.spell.blunder

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.blunder.TrickBlunderException
import net.minecraft.text.MutableText

class NotWithinRAMBoundsBlunder(source: Trick, private val size: UInt, private val given: Int) : TrickBlunderException(source) {
    override fun createMessage(): MutableText {
        return super.createMessage().append("Invalid RAM slot address. Got $given, but must be greater or equal to zero and lesser than $size")
    }
}