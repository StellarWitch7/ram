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
  val ALLOC = register("alloc", RAMAllocTrick())
  val FREE = register("free", RAMFreeTrick())
  val READ = register("read", RAMReadTrick())
  val WRITE = register("write", RAMWriteTrick())

  // meta
  val PATTERN_AS_INT = register("pattern_as_int", PatternAsIntTrick())
  val PATTERN_FROM_INT = register("pattern_from_int", PatternFromIntTrick())
  val PATTERN_FROM_INT_LIST = register("pattern_from_int_list", PatternFromIntListTrick())
  val GLYPH_FROM_SPELL_PART = register("glyph_from_spell_part", GlyphFromSpellPartTrick())

  // cell
  val ACQUIRE_CELL = register("acquire_cell", AcquireCellTrick())
  val READ_CELL = register("read_cell", ReadCellTrick())
  val WRITE_CELL = register("write_cell", WriteCellTrick())
}
