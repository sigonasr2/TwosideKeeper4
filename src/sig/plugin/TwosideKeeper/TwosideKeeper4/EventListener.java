package sig.plugin.TwosideKeeper.TwosideKeeper4;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import sig.plugin.TwosideKeeper.TwosideKeeper4.event.BlockEventHandler;
import sig.plugin.TwosideKeeper.TwosideKeeper4.event.EntityEventHandler;
import sig.plugin.TwosideKeeper.TwosideKeeper4.event.ItemEventHandler;
import sig.plugin.TwosideKeeper.TwosideKeeper4.event.PlayerEventHandler;

public class EventListener implements Listener{	
	@EventHandler
	public void Event_ItemDespawn(ItemDespawnEvent ev) {
		ItemEventHandler.HandleEvent(ev);
	}
	@EventHandler
	public void Event_ItemDespawn(EntityExplodeEvent ev) {
		EntityEventHandler.HandleEvent(ev);
	}
	@EventHandler
	public void Event_LiquidFlow(BlockFromToEvent ev) {
		BlockEventHandler.HandleEvent(ev);
	}
	@EventHandler
	public void Event_BlockPlace(BlockPlaceEvent ev) {
		BlockEventHandler.HandleEvent(ev);
	}
	@EventHandler
	public void Event_BlockBreak(BlockBreakEvent ev) {
		BlockEventHandler.HandleEvent(ev);
	}
	@EventHandler
	public void Event_EmptyBucket(PlayerBucketEmptyEvent ev) {
		PlayerEventHandler.HandleEvent(ev);
	}
}
