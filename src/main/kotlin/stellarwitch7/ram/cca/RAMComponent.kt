package stellarwitch7.ram.cca

import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.Entity
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtOps
import net.minecraft.registry.RegistryWrapper
import org.ladysnake.cca.api.v3.component.Component
import stellarwitch7.ram.spell.mind.DefaultRAM
import stellarwitch7.ram.spell.mind.RAM

class RAMComponent : Component {
    var ram: RAM = DefaultRAM(12u)
        private set

    constructor(entity: Entity)

    constructor(blockEntity: BlockEntity)

    override fun readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        val result = RAM.codec.codec().parse(NbtOps.INSTANCE, tag.get("ram"))

        if (result.hasResultOrPartial())
            ram = result.resultOrPartial().orElseThrow()
    }

    override fun writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        tag.put("ram", RAM.codec.codec().encodeStart(NbtOps.INSTANCE, ram).result().orElseThrow())
    }
}