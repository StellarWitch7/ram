package stellarwitch7.ram.cca

import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.Entity
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtOps
import net.minecraft.registry.RegistryWrapper
import org.ladysnake.cca.api.v3.component.Component
import stellarwitch7.ram.spell.mind.DefaultRAM
import stellarwitch7.ram.spell.mind.RAM

class RAMComponent extends Component {
  private var _ram: RAM = DefaultRAM(12)
  def ram = _ram

  override def readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup): Unit = {
    val result = RAM.codec.parse(NbtOps.INSTANCE, tag.get("ram"))

    if result.hasResultOrPartial() then
      _ram = result.resultOrPartial().orElseThrow()
    end if
  }

  override def writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup): Unit = {
    tag.put("ram", RAM.codec.encodeStart(NbtOps.INSTANCE, ram).result().orElseThrow())
  }
}

object RAMComponent {
  def apply(entity: Entity): RAMComponent = new RAMComponent()
  def apply(blockEntity: BlockEntity): RAMComponent = new RAMComponent()
}
