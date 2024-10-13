package stellarwitch7.ram.spell.trick.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.Pattern
import dev.enjarai.trickster.spell.SpellContext
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.ram.cca.entity.ModEntityComponents
import stellarwitch7.ram.spell.blunder.RAMNotSupportedBlunder
import scala.collection.JavaConverters._

class RAMReadTrick extends Trick(Pattern.of(1, 4, 3, 6, 8, 5)) {
  override def activate(ctx: SpellContext, fragments: java.util.List[Fragment]): Fragment = {
    val number = expectInput(fragments, FragmentType.NUMBER, 0).asInt()

    ctx.source.getComponent(ModEntityComponents.ram).orElseThrow(() =>
      RAMNotSupportedBlunder(this)
    ).ram.read(this, number)
  }
}
