package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedBlock;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedPlayer;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;

public class ItemPedestalCheckCommand implements Command{
	CommandSender p;
	
	public ItemPedestalCheckCommand(CommandSender sender) {
		this.p = sender;
	}

	@Override
	public CommandResult runCommand() {
		if (p instanceof Player) {
			AdvancedBlock pedestal = new AdvancedPlayer((Player)p).getBlockLookingAt();
			if (pedestal.isBlockItemPedestal()) {
				ItemPedestal ped = new ItemPedestal(pedestal);
				if (ped.isActivePedestal()) {
					p.sendMessage("This is an "+ChatColor.YELLOW+"active"+ChatColor.RESET+" pedestal!");
					ped.respawnItem();
				} else {
					p.sendMessage("This is a pedestal!");
				}
			} else {
				p.sendMessage("This is not a pedestal!");
			}
			return CommandResult.OKAY;
		} else {
			return CommandResult.NOTAPLAYER;
		}
	}

}
