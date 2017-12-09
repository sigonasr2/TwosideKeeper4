package sig.plugin.TwosideKeeper.TwosideKeeper4.event;

import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerEvent;

import sig.plugin.TwosideKeeper.TwosideKeeper4.main;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedBlock;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;

public class PlayerEventHandler {
	public static void HandleEvent(PlayerEvent e) {
		if (e instanceof PlayerBucketEmptyEvent) {
			HandleLiquidPlaceAttempt((PlayerBucketEmptyEvent)e);
		}
	}

	private static void HandleLiquidPlaceAttempt(PlayerBucketEmptyEvent e) {
		//main.logger.info(e.getBlockClicked()+"|"+e.getBlockFace()+"|"+e.getBlockClicked().getRelative(e.getBlockFace()));
		AdvancedBlock b = new AdvancedBlock(e.getBlockClicked().getRelative(e.getBlockFace()).getRelative(0, -1, 0));
		if (b.isBlockItemPedestal()) {
			ItemPedestal ped = new ItemPedestal(b);
			if (ped.isActivePedestal()) {
				e.setCancelled(true);
			}
		}
	}
}
