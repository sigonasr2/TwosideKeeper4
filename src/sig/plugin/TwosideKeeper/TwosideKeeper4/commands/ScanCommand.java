package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScanCommand {
	CommandSender p;
	
	public ScanCommand(CommandSender sender) {
		this.p = sender;
	}
	
	public CommandResult runCommand() {
		if (p instanceof Player) {
			//Get block looking at and get item.
			Item i = 
			return CommandResult.OKAY;
		} else {
			return CommandResult.NOTAPLAYER;
		}
	}
}
