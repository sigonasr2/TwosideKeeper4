package sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedBlock;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedPlayer;

public class ItemPedestal extends AdvancedBlock{
	boolean activePedestal = false;

	public ItemPedestal(Block b) {
		super(b);
		this.activePedestal = p_isActivePedestal();
	}

	public ItemPedestal(AdvancedBlock b) {
		this(b.getBlock());
		this.activePedestal = p_isActivePedestal();
	}

	private boolean p_isActivePedestal() {
		Item i = getItemAboveBlock();
		if (i!=null && i.getPickupDelay()>=200) {
			//Bukkit.getServer().broadcastMessage(Integer.toString(i.getPickupDelay()));
			return true;
		} else {
			return false;
		}
	}
	
	public void respawnItem() {
		Item i = getItemAboveBlock();
		if (i!=null && i.getPickupDelay()>=200) {
			RespawnPedestalItem(i);
			i.remove();
		}
	}

	public static void RespawnPedestalItem(Item i) {
		Item new_i = i.getWorld().dropItem(i.getLocation().add(0,0.5,0), i.getItemStack());
		new_i.setItemStack(i.getItemStack());
		SetItemPedestalProperties(new_i);
		//new_i.teleport(new_i.getLocation(), TeleportCause.PLUGIN);
	}

	private static void SetItemPedestalProperties(Item new_i) {
		new_i.setPickupDelay(12000);
		new_i.setVelocity(new Vector(0,0,0));
		new_i.setInvulnerable(true);
	}

	public static void SpawnPedestalItem(Location l, ItemStack i) {
		Item new_i = l.getWorld().dropItem(l, i);
		new_i.setItemStack(i);
		SetItemPedestalProperties(new_i);
		//new_i.teleport(new_i.getLocation(), TeleportCause.PLUGIN);
	}
	
	public boolean isActivePedestal() {
		return activePedestal;
	}

	public static boolean isItemPedestalMaterial(MaterialData mat) {
		return mat.getItemType()==Material.SMOOTH_BRICK && mat.getData()==(byte)3;
	}
}
