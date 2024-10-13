package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import scala.collection.JavaConverters._
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.PatternGlyph

class PatternFromIntTrick extends Trick(Pattern.of(0, 4, 8, 7, 4, 1)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment =
    PatternGlyph(Pattern.from(expectInput(fragments, FragmentType.NUMBER, 0).asInt()))
}
