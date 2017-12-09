package sig.plugin.TwosideKeeper.TwosideKeeper4.event;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;

import sig.plugin.TwosideKeeper.TwosideKeeper4.main;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedBlock;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;

public class EntityEventHandler {
	public static void HandleEvent(EntityEvent e) {
		if (e instanceof EntityExplodeEvent) {
			HandleItemExplosion((EntityExplodeEvent)e);
		}
	}

	private static void HandleItemExplosion(EntityExplodeEvent e) {
		List<Block> blocks = e.blockList();
		for (int i=0;i<blocks.size();i++) {
			AdvancedBlock ab = new AdvancedBlock(blocks.get(i));
			if (ab.isBlockItemPedestal()) {
				ItemPedestal ped = new ItemPedestal(ab);
				if (ped.isActivePedestal()) {
					//main.logger.info("Found an active pedestal in the explosion. Removing from list.");
					blocks.remove(i--);
				}
			} else 
			if (ab.isExplosionProof()) {
				blocks.remove(i--);
			}
		}
	}
}
