package sig.plugin.TwosideKeeper.TwosideKeeper4.commands;

public enum CommandResult {
	OKAY("Command executed with no issues."),
	NOTAPLAYER("This command can only be issued by a player!"),
	INVALIDCOMMAND("This is not a valid command!");
	
	String response;
	
	CommandResult(String response) {
		this.response = response;
	}
	
	public String getResponse() {
		return response;
	}
}
