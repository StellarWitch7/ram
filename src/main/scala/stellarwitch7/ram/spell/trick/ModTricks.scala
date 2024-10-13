package stellarwitch7.ram.spell.trick

import dev.enjarai.trickster.spell.trick.Trick
import dev.enjarai.trickster.spell.trick.Tricks
import net.minecraft.registry.Registry
import stellarwitch7.libstellar.registry.Registrar
import stellarwitch7.ram.RandomAccessMind
import stellarwitch7.ram.spell.trick.mind.*
import stellarwitch7.ram.spell.trick.meta.*
import stellarwitch7.ram.spell.trick.cell.*

object ModTricks extends Registrar[Trick] {
  override val modID: String = RandomAccessMind.MOD_ID
  override val registry: Registry[Trick] = Tricks.REGISTRY

  // ram
  val alloc = register("alloc", RAMAllocTrick())
  val free = register("free", RAMFreeTrick())
  val read = register("read", RAMReadTrick())
  val write = register("write", RAMWriteTrick())

  // meta
  val patternAsInt = register("pattern_as_int", PatternAsIntTrick())
  val patternFromInt = register("pattern_from_int", PatternFromIntTrick())
  val patternFromIntList = register("pattern_from_int_list", PatternFromIntListTrick())
  val glyphFromSpellPart = register("glyph_from_spell_part", GlyphFromSpellPartTrick())

  // cell
  val acquireCell = register("acquire_cell", AcquireCellTrick())
  val readCell = register("read_cell", ReadCellTrick())
  val writeCell = register("write_cell", WriteCellTrick())
}
