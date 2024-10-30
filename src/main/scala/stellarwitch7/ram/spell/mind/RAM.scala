package stellarwitch7.ram.spell.mind

import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.trick.Trick
import net.minecraft.registry.Registry
import stellarwitch7.libstellar.registry.codec.CodecRegistrar
import stellarwitch7.libstellar.registry.codec.CodecType
import stellarwitch7.libstellar.registry.codec.CodecTypeProvider
import stellarwitch7.ram.RandomAccessMind

trait RAM extends CodecTypeProvider[RAM] {
  def alloc(source: Trick): Int
  def free(source: Trick, address: Int): Unit
  def write(source: Trick, address: Int, value: Fragment): Unit
  def read(source: Trick, address: Int): Fragment
}

object RAM extends CodecRegistrar[RAM] {
  override val modID: String = RandomAccessMind.MOD_ID
  override val registry: Registry[CodecType[RAM]] = makeReg("ram")

  val DEFAULT = register("default", DefaultRAM.codec)
}
