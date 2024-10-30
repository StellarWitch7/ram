package stellarwitch7.ram.spell.trick.cell

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.world.ModWorldComponents

class AcquireCellTrick extends Trick(Pattern.of(4, 6, 0, 4, 5)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment =
    ModWorldComponents.CELLS.get(ctx.source.getWorld()).acquireCell()
}
