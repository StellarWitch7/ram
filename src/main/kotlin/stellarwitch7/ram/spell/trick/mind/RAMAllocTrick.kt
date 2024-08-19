package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.NumberFragment
import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.blunder.NoPlayerBlunder
import stellarwitch7.ram.cca.entity.ModEntityComponents

class RAMAllocTrick : Trick(Pattern.of(1, 4, 0, 6, 4, 8, 2, 4)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        return NumberFragment(ModEntityComponents.ram.get(ctx.source.player.orElseThrow {
            NoPlayerBlunder(this)
        }).ram.alloc(this).toDouble())
    }
}