package sig.plugin.TwosideKeeper.TwosideKeeper4.filters;

import java.util.function.Predicate;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class EntityRemovalFilters {
	public static Predicate<Entity> allNonMonsters() {
		return e -> e instanceof Monster;
	}
	public static Predicate<Entity> allNonLivingEntities() {
		return e -> e instanceof LivingEntity;
	}
	public static Predicate<Entity> allItemDrops() {
		return e -> !(e instanceof Item);
	}
	public static Predicate<Entity> allPlayers() {
		return e -> !(e instanceof Player);
	}
}
