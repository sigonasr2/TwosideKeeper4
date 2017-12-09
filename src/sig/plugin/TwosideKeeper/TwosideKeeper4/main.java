package sig.plugin.TwosideKeeper.TwosideKeeper4;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import sig.plugin.TwosideKeeper.TwosideKeeper4.commands.CommandHandler;

public class main extends JavaPlugin{

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return (new CommandHandler(sender,cmd,label,args)).runCommand();
	}
}
