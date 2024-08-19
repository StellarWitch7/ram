package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.blunder.NoPlayerBlunder
import stellarwitch7.ram.cca.entity.ModEntityComponents

class RAMWriteTrick : Trick(Pattern.of(1, 4, 5, 8, 6, 3)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        val number = expectInput(fragments, FragmentType.NUMBER, 0).number()
        val any = expectInput(fragments, 1)

        ModEntityComponents.ram.get(ctx.source.player.orElseThrow {
            NoPlayerBlunder(this)
        }).ram.write(this, number.toInt(), any)

        return VoidFragment.INSTANCE
    }
}