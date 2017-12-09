package sig.plugin.TwosideKeeper.TwosideKeeper4.advanced;

import java.util.Collection;
import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public class AdvancedLocation {
	Location l;
	
	public AdvancedLocation(Block b) {
		this(b.getLocation().add(0.5,1,0.5));
	}
	
	public AdvancedLocation(Entity e) {
		this(e.getLocation());
	}
	
	public AdvancedLocation(Location l) {
		this.l = l;
	}
	
	public Location getLocation() {
		return l;
	}
	
	public Collection<Entity> getNearbyEntities(double distance) {
		return l.getWorld().getNearbyEntities(l, distance, distance, distance);
	}

	public Collection<Entity> getNearbyEntities(double distance,Predicate<Entity> remove_filter) {
		Collection<Entity> ents = l.getWorld().getNearbyEntities(l, distance, distance, distance);
		ents.removeIf(remove_filter);
		return ents;
	}
	
}
