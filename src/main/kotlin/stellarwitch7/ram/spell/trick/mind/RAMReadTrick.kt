package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.entity.ModEntityComponents
import stellarwitch7.ram.spell.blunder.RAMNotSupportedBlunder

class RAMReadTrick : Trick(Pattern.of(1, 4, 3, 6, 8, 5)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        val number = expectInput(fragments, FragmentType.NUMBER, 0).number()

        return ctx.source.getComponent(ModEntityComponents.ram).orElseThrow {
            RAMNotSupportedBlunder(this)
        }.ram.read(this, number.toInt())
    }
}