package stellarwitch7.ram.spell.trick.meta

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.fragment.NumberFragment
import dev.enjarai.trickster.spell.trick.Trick
import scala.collection.JavaConverters._

class PatternAsIntTrick extends Trick(Pattern.of(2, 4, 6, 7, 4, 1)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment =
    NumberFragment(expectInput(fragments, FragmentType.PATTERN, 0).pattern.toInt().toDouble)
}
