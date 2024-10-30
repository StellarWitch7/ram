package stellarwitch7.ram.spell.mind

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.fragment.VoidFragment
import dev.enjarai.trickster.spell.trick.Trick
import stellarwitch7.libstellar.registry.codec.CodecType
import stellarwitch7.ram.spell.blunder.NotWithinRAMBoundsBlunder
import stellarwitch7.ram.spell.blunder.OutOfRAMBlunder
import com.mojang.serialization.Codec
import scala.collection.JavaConverters._

class DefaultRAM private(val size: Int, protected var slots: Array[RAMSlot]) extends RAM {
  override val `type`: CodecType[RAM] = RAM.DEFAULT

  override def alloc(source: Trick): Int = {
    for ((slot, i) <- slots.view.zipWithIndex) {
      if (slot.free) {
        slot.free = false
        return i
      }
    }

    throw OutOfRAMBlunder(source)
  }

  override def free(source: Trick, address: Int): Unit = {
    if address < 0 || address >= slots.size then
      throw NotWithinRAMBoundsBlunder(source, slots.size, address)
    end if

    slots(address).free = true
  }

  override def write(source: Trick, address: Int, value: Fragment): Unit = {
    if address < 0 || address >= slots.size then
      throw NotWithinRAMBoundsBlunder(source, slots.size, address)
    end if

    slots(address).value = value
  }

  override def read(source: Trick, address: Int): Fragment = {
    if address < 0 || address >= slots.size then
      throw NotWithinRAMBoundsBlunder(source, slots.size, address)
    end if

    slots(address).value
  }
}

object DefaultRAM {
  val codec: MapCodec[DefaultRAM] = RecordCodecBuilder.mapCodec(builder => builder.group(
    Codec.INT.fieldOf("size").forGetter(_.size),
    RAMSlot.codec.listOf().fieldOf("slots").forGetter(_.slots.toList.asJava)
  ).apply(builder, DefaultRAM(_, _)))

  def apply(size: Int): DefaultRAM =
    new DefaultRAM(size, Array.fill(size) { RAMSlot(true, VoidFragment.INSTANCE) })

  private def apply(size: Int, slots: java.util.List[RAMSlot]): DefaultRAM =
    new DefaultRAM(size, slots.asScala.toArray)
}
