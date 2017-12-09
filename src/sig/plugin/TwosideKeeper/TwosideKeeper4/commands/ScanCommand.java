package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedPlayer;

public class ScanCommand implements Command{
	CommandSender p;
	
	public ScanCommand(CommandSender sender) {
		this.p = sender;
	}
	
	public CommandResult runCommand() {
		if (p instanceof Player) {
			//Get block looking at and get item.
			Item i = new AdvancedPlayer((Player)p).getBlockLookingAt().getItemAboveBlock();
			if (i!=null) {
				p.sendMessage(i.getItemStack().toString());
			} else {
				p.sendMessage("Invalid block, or no item found!");
			}
			return CommandResult.OKAY;
		} else {
			return CommandResult.NOTAPLAYER;
		}
	}
}
