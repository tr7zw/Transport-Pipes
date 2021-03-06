package de.robotricker.transportpipes.duct.pipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.flowpowered.nbt.CompoundMap;
import com.flowpowered.nbt.CompoundTag;

import de.robotricker.transportpipes.PipeThread;
import de.robotricker.transportpipes.TransportPipes;
import de.robotricker.transportpipes.duct.ClickableDuct;
import de.robotricker.transportpipes.duct.pipe.utils.PipeType;
import de.robotricker.transportpipes.pipeitems.PipeItem;
import de.robotricker.transportpipes.utils.WrappedDirection;
import de.robotricker.transportpipes.utils.ductdetails.DuctDetails;
import de.robotricker.transportpipes.utils.ductdetails.PipeDetails;
import de.robotricker.transportpipes.utils.staticutils.DuctItemUtils;
import de.robotricker.transportpipes.utils.staticutils.NBTUtils;

public class IronPipe extends Pipe implements ClickableDuct {

	private WrappedDirection currentOutputDir;

	public IronPipe(Location blockLoc) {
		super(blockLoc);
		currentOutputDir = WrappedDirection.UP;
	}

	@Override
	public Map<WrappedDirection, Integer> handleArrivalAtMiddle(PipeItem item, WrappedDirection before, Collection<WrappedDirection> possibleDirs) {
		Map<WrappedDirection, Integer> map = new HashMap<WrappedDirection, Integer>();
		map.put(currentOutputDir, item.getItem().getAmount());
		return map;
	}

	@Override
	public void saveToNBTTag(CompoundMap tags) {
		super.saveToNBTTag(tags);
		NBTUtils.saveIntValue(tags, "OutputDirection", currentOutputDir.getId());
	}

	@Override
	public void loadFromNBTTag(CompoundTag tag, long datFileVersion) {
		super.loadFromNBTTag(tag, datFileVersion);
		currentOutputDir = WrappedDirection.fromID(NBTUtils.readIntTag(tag.getValue().get("OutputDirection"), 0));
	}

	public void cycleOutputDirection() {
		Collection<WrappedDirection> connections = getAllConnections();
		if (connections.isEmpty()) {
			return;
		}

		WrappedDirection oldOutputDir = currentOutputDir;

		do {
			int dirId = currentOutputDir.getId();
			dirId++;
			if (WrappedDirection.fromID(dirId) == null) {
				dirId = 0;
			}
			currentOutputDir = WrappedDirection.fromID(dirId);
		} while (!connections.contains(currentOutputDir));

		if (oldOutputDir != currentOutputDir) {
			TransportPipes.instance.pipeThread.runTask(new Runnable() {

				public void run() {
					TransportPipes.instance.ductManager.updateDuct(IronPipe.this);
				};
			}, 0);
		}
	}

	@Override
	public void click(Player p, WrappedDirection side) {
		cycleOutputDirection();
		p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 1f, 1f);
	}

	public WrappedDirection getCurrentOutputDir() {
		return currentOutputDir;
	}

	@Override
	public PipeType getPipeType() {
		return PipeType.IRON;
	}

	@Override
	public int[] getBreakParticleData() {
		return new int[] { 42, 0 };
	}

	@Override
	public List<ItemStack> getDroppedItems() {
		List<ItemStack> is = new ArrayList<>();
		is.add(DuctItemUtils.getClonedDuctItem(new PipeDetails(getPipeType())));
		return is;
	}

	@Override
	public DuctDetails getDuctDetails() {
		return new PipeDetails(getPipeType());
	}
	
	@Override
	public void notifyConnectionsChange() {
		super.notifyConnectionsChange();
		Collection<WrappedDirection> allConns = getAllConnections();
		if (!allConns.isEmpty() && !allConns.contains(currentOutputDir)) {
			cycleOutputDirection();
		}
	}

}
