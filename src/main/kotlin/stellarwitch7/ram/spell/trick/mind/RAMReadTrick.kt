package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.blunder.NoPlayerBlunder
import stellarwitch7.ram.cca.entity.ModEntityComponents

class RAMReadTrick : Trick(Pattern.of(1, 4, 3, 6, 8, 5)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        val number = expectInput(fragments, FragmentType.NUMBER, 0).number()

        return ModEntityComponents.ram.get(ctx.source.player.orElseThrow {
            NoPlayerBlunder(this)
        }).ram.read(this, number.toInt())
    }
}