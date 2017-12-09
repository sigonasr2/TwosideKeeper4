package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.AdvancedPlayer;
import sig.plugin.TwosideKeeper.TwosideKeeper4.advanced.block.ItemPedestal;

public class ItemPedestalCreateCommand implements Command{
	CommandSender p;
	
	public ItemPedestalCreateCommand(CommandSender sender) {
		this.p=sender;
	}

	@Override
	public CommandResult runCommand() {
		if (p instanceof Player) {
			AdvancedPlayer ap = new AdvancedPlayer((Player)p);
			if (ap.getBlockLookingAt().isBlockItemPedestal()) {
				ItemPedestal pedestal = new ItemPedestal(ap.getBlockLookingAt());
				ItemPedestal.SpawnPedestalItem(ap.getBlockLookingAt().getLocation().getLocation(), ((Player) p).getEquipment().getItemInMainHand());
			}
			return CommandResult.OKAY;
		} else {
			return CommandResult.NOTAPLAYER;
		}
	}
}
