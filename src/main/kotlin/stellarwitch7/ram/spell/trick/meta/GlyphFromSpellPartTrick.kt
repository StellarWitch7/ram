package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick

class GlyphFromSpellPartTrick : Trick(Pattern.of(3, 0, 1, 2, 5)) {
    override fun activate(ctx: SpellContext, fragments: List<Fragment>): Fragment {
        return expectInput(fragments, FragmentType.SPELL_PART, 0).glyph
    }
}