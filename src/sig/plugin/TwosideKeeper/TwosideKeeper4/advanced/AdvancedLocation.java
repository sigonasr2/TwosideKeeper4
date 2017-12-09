package sig.plugin.TwosideKeeper.TwosideKeeper4.advanced;

import java.util.Collection;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public class AdvancedLocation {
	Location l;
	
	public AdvancedLocation(Block b) {
		this(b.getLocation());
	}
	
	public AdvancedLocation(Entity e) {
		this(e.getLocation());
	}
	
	public AdvancedLocation(Location l) {
		this.l = l;
	}
	
	public Collection<Entity> getNearbyEntities(double distance) {
		return l.getWorld().getNearbyEntities(l, distance, distance, distance).removeIf())
	}
	
}
