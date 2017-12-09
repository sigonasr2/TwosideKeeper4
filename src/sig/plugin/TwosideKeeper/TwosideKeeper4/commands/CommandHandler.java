package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {
	CommandSender sender;
	Command cmd;
	String label;
	String[] args;
	
	public CommandHandler(CommandSender sender, Command command, String label, String[] args) {
		this.sender = sender;
		this.cmd = command;
		this.label = label;
		this.args = args;
	}
	
	public boolean runCommand() {
		
	}
}
