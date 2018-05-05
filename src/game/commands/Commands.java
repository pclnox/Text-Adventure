package game.commands;

public enum Commands {	
	HELP("help"),
	NORTH("north"),
	EAST("east"),
	SOUTH("south"),
	WEST("west"),
	SWIM("swim"),
	EXPLORE("explore"),
	RUN("run"),
	EXIT("exit");
	
	String commandName;
	
	private Commands(String commandName) {
		this.commandName = commandName;
	}
	
	public String getCommandName() {
		return commandName;
	}
}