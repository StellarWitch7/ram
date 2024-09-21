package stellarwitch7.ram.spell.trick.cell

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.world.ModWorldComponents
import stellarwitch7.ram.spell.fragment.ModFragmentTypes

class ReadCellTrick : Trick(Pattern.of(4, 6, 0, 4, 2)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        return expectInput(fragments, ModFragmentTypes.cell, 0).get(this, ctx.source.world)
    }
}