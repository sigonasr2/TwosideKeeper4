package sig.plugin.TwosideKeeper.TwosideKeeper4.advanced;

import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.material.MaterialData;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;
import sig.plugin.TwosideKeeper.TwosideKeeper4.filters.EntityRemovalFilters;

public class AdvancedBlock{
	protected Block b;
	Item holdingitem;
	AdvancedLocation al;
	
	public AdvancedBlock(Block b) {
		this.b = b;
		this.al = new AdvancedLocation(b);
		this.holdingitem = p_getItemAboveBlock();
	}
	
	public Block getBlock() {
		return b;
	}
	
	public AdvancedLocation getLocation() {
		return al;
	}

	private Item p_getItemAboveBlock() {
		Collection<Entity> ents = al.getNearbyEntities(0.5,EntityRemovalFilters.allItemDrops());
		if (ents.size()>0) {
			return (Item)ents.iterator().next();
		} else {
			return null;
		}
	}
	
	public Item getItemAboveBlock() {
		return holdingitem;
	}
	
	public boolean isBlockItemPedestal() {
		return ItemPedestal.isItemPedestalMaterial(new MaterialData(b.getType(),b.getData()));
	}

	public boolean isExplosionProof() {
		return b.getType()==Material.BEDROCK ||
				b.getType()==Material.CHEST ||
				b.getType()==Material.TRAPPED_CHEST ||
				b.getType()==Material.WALL_SIGN ||
				b.getType()==Material.SIGN ||
				b.getType()==Material.SIGN_POST ||
				b.getType()==Material.ITEM_FRAME ||
				b.getType().name().contains("SHULKER_BOX");
	}
}