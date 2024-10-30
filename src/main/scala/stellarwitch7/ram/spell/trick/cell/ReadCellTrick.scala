package stellarwitch7.ram.spell.trick.cell

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.world.ModWorldComponents
import stellarwitch7.ram.spell.fragment.ModFragmentTypes
import scala.collection.JavaConverters._

class ReadCellTrick extends Trick(Pattern.of(4, 6, 0, 4, 2)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment =
    expectInput(fragments, ModFragmentTypes.CELL, 0).get(this, ctx.source.getWorld())
}
