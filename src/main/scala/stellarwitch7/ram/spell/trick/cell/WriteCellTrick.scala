package stellarwitch7.ram.spell.trick.cell

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.spell.fragment.ModFragmentTypes
import scala.collection.JavaConverters._

class WriteCellTrick extends Trick(Pattern.of(4, 6, 0, 4, 8)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment = {
    val cell = expectInput(fragments, ModFragmentTypes.CELL, 0)
    val value = expectInput(fragments, 1)
    cell.set(this, ctx.source.getWorld(), value.applyEphemeral())

    cell
  }
}
