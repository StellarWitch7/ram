package stellarwitch7.ram.spell.fragment;

import java.util.UUID;

import dev.enjarai.trickster.EndecTomfoolery;
import stellarwitch7.ram.cca.world.ModWorldComponents$;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.fragment.BooleanFragment;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.trick.Trick;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import stellarwitch7.ram.spell.fragment.ModFragmentTypes$;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public record CellFragment(UUID uuid) implements Fragment {
    public static final StructEndec<CellFragment> ENDEC = StructEndecBuilder.of(
            EndecTomfoolery.UUID.fieldOf("uuid", CellFragment::uuid),
            CellFragment::new
    );

	@Override
	public FragmentType<?> type() {
        return ModFragmentTypes$.MODULE$.CELL();
	}

	@Override
	public Text asText() {
		return Text.literal(uuid.toString());
	}

	@Override
	public BooleanFragment asBoolean() {
		return BooleanFragment.TRUE;
	}

    @Override
    public int getWeight() {
        return 32;
    }

    public Fragment get(Trick source, ServerWorld world) {
        return ModWorldComponents$.MODULE$.CELLS().get(world).readCell(source, uuid);
    }
    
    public void set(Trick source, ServerWorld world, Fragment value) {
        ModWorldComponents$.MODULE$.CELLS().get(world).writeCell(source, uuid, value);
    }
}
