package stellarwitch7.ram.spell.fragment

import dev.enjarai.trickster.EndecTomfoolery
import dev.enjarai.trickster.spell.Fragment
import dev.enjarai.trickster.spell.fragment.BooleanFragment
import dev.enjarai.trickster.spell.fragment.FragmentType
import dev.enjarai.trickster.spell.trick.Trick
import io.wispforest.endec.StructEndec
import io.wispforest.endec.impl.StructEndecBuilder
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import stellarwitch7.ram.cca.world.ModWorldComponents
import java.util.UUID

data class CellFragment(val uuid: UUID) : Fragment {
    fun get(source: Trick, world: ServerWorld): Fragment {
        return ModWorldComponents.cells.get(world).readCell(source, uuid)
    }

    fun set(source: Trick, world: ServerWorld, value: Fragment) {
        ModWorldComponents.cells.get(world).writeCell(source, uuid, value)
    }

    override fun type(): FragmentType<*> {
        return ModFragmentTypes.cell
    }

    override fun asText(): Text {
        return Text.literal(uuid.toString())
    }

    override fun asBoolean(): BooleanFragment {
        return BooleanFragment.TRUE
    }

    companion object {
        val endec: StructEndec<CellFragment> = StructEndecBuilder.of(
            EndecTomfoolery.UUID.fieldOf("uuid", CellFragment::uuid),
            ::CellFragment
        )
    }
}
