package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import scala.collection.JavaConverters._

class GlyphFromSpellPartTrick extends Trick(Pattern.of(3, 0, 1, 2, 5)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment =
    expectInput(fragments, FragmentType.SPELL_PART, 0).glyph
}
