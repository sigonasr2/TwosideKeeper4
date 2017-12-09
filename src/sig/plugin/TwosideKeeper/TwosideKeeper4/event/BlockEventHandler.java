package sig.plugin.TwosideKeeper.TwosideKeeper4.event;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedBlock;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;

public class BlockEventHandler {
	public static void HandleEvent(BlockEvent e) {
		if (e instanceof BlockFromToEvent) {
			HandleLiquidFlowAttempt((BlockFromToEvent)e);
		} else
		if (e instanceof BlockPlaceEvent) {
			HandleBlockPlaceAttempt((BlockPlaceEvent)e);
		} else
		if (e instanceof BlockBreakEvent) {
			HandleBlockBreakAttempt((BlockBreakEvent)e);
		}
	}

	private static void HandleBlockBreakAttempt(BlockBreakEvent e) {
		AdvancedBlock b = new AdvancedBlock(e.getBlock());
		if (b.isBlockItemPedestal()) {
			ItemPedestal ped = new ItemPedestal(b);
			if (ped.isActivePedestal()) {
				e.setCancelled(true);
			}
		}
	}

	private static void HandleBlockPlaceAttempt(BlockPlaceEvent e) {
		AdvancedBlock b = new AdvancedBlock(e.getBlock().getRelative(0, -1, 0));
		if (b.isBlockItemPedestal()) {
			ItemPedestal ped = new ItemPedestal(b);
			if (ped.isActivePedestal()) {
				e.setCancelled(true);
			}
		}
	}

	private static void HandleLiquidFlowAttempt(BlockFromToEvent e) {
		AdvancedBlock b = new AdvancedBlock(e.getToBlock().getRelative(0, -1, 0));
		if (b.isBlockItemPedestal()) {
			ItemPedestal ped = new ItemPedestal(b);
			if (ped.isActivePedestal()) {
				e.setCancelled(true);
				e.getBlock().breakNaturally();
				e.getBlock().setType(Material.AIR, false);
			}
		}
	}
}
