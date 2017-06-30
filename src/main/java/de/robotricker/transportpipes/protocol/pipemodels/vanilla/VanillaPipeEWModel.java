package de.robotricker.transportpipes.protocol.pipemodels.vanilla;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import de.robotricker.transportpipes.pipeutils.PipeColor;
import de.robotricker.transportpipes.pipeutils.RelLoc;
import de.robotricker.transportpipes.protocol.ArmorStandData;

public class VanillaPipeEWModel extends VanillaPipeModel {

	@Override
	public List<ArmorStandData> createColoredASD(PipeColor pc) {
		List<ArmorStandData> asds = new ArrayList<ArmorStandData>();
		ItemStack block = pc.getVanillaModel_GlassItem();

		asds.add(new ArmorStandData(new RelLoc(0.05f, -0.35f, 0.5f - 0.44f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 45f)));
		asds.add(new ArmorStandData(new RelLoc(0.05f, -1.0307f, 0.5f - 0.86f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 135f)));
		asds.add(new ArmorStandData(new RelLoc(0.05f, -1.0307f - 0.45f, 0.5f - 0.37f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 135f)));
		asds.add(new ArmorStandData(new RelLoc(0.05f, -0.35f - 0.45f, 0.5f - 0.93f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 45f)));
		asds.add(new ArmorStandData(new RelLoc(0.55f - 0.3f, -0.43f, 0.5f), new Vector(1, 0, 0), true, block, null, new Vector(0f, 0f, 0f), new Vector(0f, 0f, 0f)));
		asds.add(new ArmorStandData(new RelLoc(0.55f + 0.2f, -0.43f, 0.5f), new Vector(1, 0, 0), true, block, null, new Vector(0f, 0f, 0f), new Vector(0f, 0f, 0f)));

		return asds;

	}

	@Override
	public List<ArmorStandData> createIceASD() {
		List<ArmorStandData> asds = new ArrayList<ArmorStandData>();
		ItemStack block = ITEM_ICE_BLOCK;

		asds.add(new ArmorStandData(new RelLoc(0.05f, -0.35f, 0.5f - 0.44f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 45f)));
		asds.add(new ArmorStandData(new RelLoc(0.05f, -1.0307f, 0.5f - 0.86f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 135f)));
		asds.add(new ArmorStandData(new RelLoc(0.05f, -1.0307f - 0.45f, 0.5f - 0.37f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 135f)));
		asds.add(new ArmorStandData(new RelLoc(0.05f, -0.35f - 0.45f, 0.5f - 0.93f), new Vector(1, 0, 0), false, null, ITEM_BLAZE, new Vector(0f, 0f, 0f), new Vector(-10f, 0f, 45f)));
		asds.add(new ArmorStandData(new RelLoc(0.55f - 0.3f, -0.43f, 0.5f), new Vector(1, 0, 0), true, block, null, new Vector(0f, 0f, 0f), new Vector(0f, 0f, 0f)));
		asds.add(new ArmorStandData(new RelLoc(0.55f + 0.2f, -0.43f, 0.5f), new Vector(1, 0, 0), true, block, null, new Vector(0f, 0f, 0f), new Vector(0f, 0f, 0f)));

		return asds;

	}

}