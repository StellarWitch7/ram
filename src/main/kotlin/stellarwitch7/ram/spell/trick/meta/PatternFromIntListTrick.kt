package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.PatternGlyph
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.fragment.ListFragment
import dev.enjarai.trickster.spell.trick.Trick

class PatternFromIntListTrick : Trick(Pattern.of(0, 4, 8, 6, 4, 2, 1)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
       return PatternGlyph(
           supposeInput(fragments, 0)
               .flatMap {
                   supposeType(it, FragmentType.LIST).map(ListFragment::fragments)
               }
               .orElse(fragments)
               .map {
                   expectType(it, FragmentType.NUMBER).asInt().toByte()
               }
       )
    }
}