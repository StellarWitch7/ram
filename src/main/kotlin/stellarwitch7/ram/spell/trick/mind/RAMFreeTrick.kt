package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.entity.ModEntityComponents
import stellarwitch7.ram.spell.blunder.RAMNotSupportedBlunder

class RAMFreeTrick : Trick(Pattern.of(1, 4, 6, 8, 4)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        val number = expectInput(fragments, FragmentType.NUMBER, 0).number()

        ctx.source.getComponent(ModEntityComponents.ram).orElseThrow {
            RAMNotSupportedBlunder(this)
        }.ram.free(this, number.toInt())

        return VoidFragment.INSTANCE
    }
}