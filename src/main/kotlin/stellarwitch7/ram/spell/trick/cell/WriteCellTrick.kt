package stellarwitch7.ram.spell.trick.cell

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.spell.fragment.ModFragmentTypes

class WriteCellTrick : Trick(Pattern.of(4, 6, 0, 4, 8)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        val cell = expectInput(fragments, ModFragmentTypes.cell, 0)
        val value = expectInput(fragments, 1)
        cell.set(this, ctx.source.world, value/*TODO: make this kill ephemerals*/)
        return cell
    }
}