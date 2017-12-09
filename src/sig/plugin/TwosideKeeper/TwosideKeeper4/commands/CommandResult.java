package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

public enum CommandResult {
	OKAY("Command executed with no issues."),
	NOTAPLAYER("This command can only be issued by a player!");
	
	String response;
	
	CommandResult(String response) {
		this.response = response;
	}
}
