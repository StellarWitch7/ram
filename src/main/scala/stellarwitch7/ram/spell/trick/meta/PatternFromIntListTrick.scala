package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.PatternGlyph
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.fragment.ListFragment
import dev.enjarai.trickster.spell.trick.Trick
import scala.collection.JavaConverters._

class PatternFromIntListTrick extends Trick(Pattern.of(0, 4, 8, 6, 4, 2, 1)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment =
    PatternGlyph(
      supposeInput(fragments, 0)
        .flatMap(supposeType(_, FragmentType.LIST).map(_.fragments))
        .map(_.asScala)
        .orElse(fragments.asScala)
        .map(expectType(_, FragmentType.NUMBER).asInt().asInstanceOf[java.lang.Byte]).asJava)
}

