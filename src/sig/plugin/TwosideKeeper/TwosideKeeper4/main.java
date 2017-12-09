package sig.plugin.TwosideKeeper.TwosideKeeper4;

import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import sig.plugin.TwosideKeeper.TwosideKeeper4.commands.CommandHandler;

public class main extends JavaPlugin{
	
	public static Logger logger;
	public static main plugin;
	public static EventListener listener;
	
	public void onEnable() {
		logger = Bukkit.getLogger();
		plugin = this;
		listener = new EventListener();
		Bukkit.getPluginManager().registerEvents(listener, this);
	}

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return (new CommandHandler(sender,cmd,label,args)).runCommand();
	}
}
