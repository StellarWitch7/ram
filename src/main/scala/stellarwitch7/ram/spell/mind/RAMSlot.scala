package stellarwitch7.ram.spell.mind

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import dev.enjarai.trickster.spell.Fragment
import io.wispforest.accessories.endec.CodecUtils

/**
 * Represents a single slot within a Random Access Mind (RAM).
 * @property free Whether the slot may be reserved.
 * @property value The value contained within the slot. A VoidFragment by default, but is not cleared when the slot is freed.
 */
class RAMSlot(var free: Boolean, var value: Fragment) { }

object RAMSlot {
  val codec: Codec[RAMSlot] = RecordCodecBuilder.create(builder => builder.group(
    Codec.BOOL.fieldOf("free").forGetter(_.free),
    CodecUtils.ofEndec(Fragment.ENDEC).fieldOf("value").forGetter(_.value)
  ).apply(builder, RAMSlot(_, _)))
}
