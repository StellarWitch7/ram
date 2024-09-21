package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.*
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick

class PatternFromIntTrick : Trick(Pattern.of(0, 4, 8, 7, 4, 1)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        return PatternGlyph(Pattern.from(expectInput(fragments, FragmentType.NUMBER, 0).asInt()))
    }
}