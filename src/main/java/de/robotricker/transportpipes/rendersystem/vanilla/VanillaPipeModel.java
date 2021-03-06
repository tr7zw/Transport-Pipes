package de.robotricker.transportpipes.rendersystem.vanilla;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.robotricker.transportpipes.protocol.ArmorStandData;
import de.robotricker.transportpipes.rendersystem.Model;
import de.robotricker.transportpipes.rendersystem.vanilla.utils.VanillaPipeModelData;
import de.robotricker.transportpipes.utils.hitbox.AxisAlignedBB;

public abstract class VanillaPipeModel extends Model {

	protected static final ItemStack ITEM_BLAZE = new ItemStack(Material.BLAZE_ROD);
	protected static final ItemStack ITEM_GOLD_BLOCK = new ItemStack(Material.GOLD_BLOCK);
	protected static final ItemStack ITEM_IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
	protected static final ItemStack ITEM_ICE_BLOCK = new ItemStack(Material.ICE);
	protected static final ItemStack ITEM_VOID_BLOCK = new ItemStack(Material.OBSIDIAN);
	protected static final ItemStack ITEM_EXTRACTION_BLOCK = new ItemStack(Material.WOOD);
	protected static final ItemStack ITEM_CARPET_WHITE = new ItemStack(Material.CARPET, 1, (short) 0);
	protected static final ItemStack ITEM_CARPET_YELLOW = new ItemStack(Material.CARPET, 1, (short) 4);
	protected static final ItemStack ITEM_CARPET_GREEN = new ItemStack(Material.CARPET, 1, (short) 5);
	protected static final ItemStack ITEM_CARPET_BLUE = new ItemStack(Material.CARPET, 1, (short) 11);
	protected static final ItemStack ITEM_CARPET_RED = new ItemStack(Material.CARPET, 1, (short) 14);
	protected static final ItemStack ITEM_CARPET_BLACK = new ItemStack(Material.CARPET, 1, (short) 15);

	protected AxisAlignedBB aabb;

	public abstract List<ArmorStandData> createASD(VanillaPipeModelData data);

	public AxisAlignedBB getAABB() {
		return aabb;
	}

}
