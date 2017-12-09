package sig.plugin.TwosideKeeper.TwosideKeeper4.advanced;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import sig.plugin.TwosideKeeper.TwosideKeeper4.main;

public class AdvancedPlayer {
	Player p;
	
	public AdvancedPlayer(Player p) {
		this.p=p;
	}
	
	public AdvancedBlock getBlockLookingAt() {
		Block b = p.getTargetBlock(null, 50);
		//main.logger.info(b.toString());
		return new AdvancedBlock(b);
	}
}
