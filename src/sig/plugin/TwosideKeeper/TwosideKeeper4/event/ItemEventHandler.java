package sig.plugin.TwosideKeeper.TwosideKeeper4.event;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;

public class ItemEventHandler {
	public static void HandleEvent(EntityEvent e) {
		if (e instanceof ItemDespawnEvent) {
			HandleDespawnItem((ItemDespawnEvent)e);
		} else
		if (e instanceof ItemSpawnEvent) {
			//TODO
		}
	}

	private static void HandleDespawnItem(ItemDespawnEvent e) {
		Item i = e.getEntity();
		if (i.getPickupDelay()>=200) {
			//Consider this a permanently spawned item. Respawn it.
			//main.logger.info("Found an item that has a long pickup delay. Spawning a new one... Old Item: "+i.getItemStack());
			ItemPedestal.RespawnPedestalItem(i);
			//main.logger.info("New Item: "+new_i.getPickupDelay()+" | New Delay: "+new_i.getPickupDelay());
		}
	}
}
