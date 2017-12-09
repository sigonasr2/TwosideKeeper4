package sig.plugin.TwosideKeeper.TwosideKeeper4.advanced;

import org.bukkit.block.Block;
import org.bukkit.entity.Item;

public class AdvancedBlock{
	Block b;
	Item holdingitem;
	
	public AdvancedBlock(Block b) {
		this.b = b;
		this.holdingitem = getItemAboveBlock();
	}

	private Item getItemAboveBlock() {
		Entity[] ents = getNearbyEntities(1);
		return null;
	}
	
	
}