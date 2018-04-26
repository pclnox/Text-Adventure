package game;

import entities.Entity;
import entities.Player;
import game.Location;
import globals.Commands;
import globals.Locations;

public class Command {
	private String statement;
	
	public static void main(String[] args) {
		Command command = new Command();
		while(Game.isRunning() == true) {
			command.TestForCommand();
		}
	}
	
	public void TestForCommand() {
		if(Game.userInput.hasNextLine()) {
			statement = Game.userInput.nextLine();
			
			switch(statement) {
			case("help"):    Help();    break;
			case("north"):   North();   break;
			case("east"):    East();    break;
			case("south"):   South();   break;
			case("west"):    West();    break;
			case("explore"): Explore(); break;
			case("run"):     Run();     break;
			case("exit"):    Exit();    break;
			default:
				System.out.println();
				System.out.println("Enter a valid command");
				System.out.println("Type help for a list of commands");
			}
		}
	}
	
	public void Help() {
		System.out.println();
		System.out.println("Commands:");
		for(Commands commands : Commands.values()) {
			System.out.println(commands.getCommandName());
		}
	}

	Location location = new Location();
	Entity entity = new Entity();
	
	public void North() {
		System.out.println();
		System.out.println("You head north");
		Game.Sleep(1);
		Player.setPreviousx(Player.getX());
		Player.setPreviousy(Player.getY());  
		Player.setY(Player.getY() - 1);
		location.ChangePlayerLocation(
				Player.getX(), 
				Player.getY(), 
				Player.getPreviousx(), 
				Player.getPreviousy(), 
				Player.getBiome(), 
				Locations.getMap());
	}
	
	public void East() {
		System.out.println();
		System.out.println("You head east");
		Game.Sleep(1);
		Player.setPreviousx(Player.getX());
		Player.setPreviousy(Player.getY());
		Player.setX(Player.getX() + 1);
		location.ChangePlayerLocation(
				Player.getX(), 
				Player.getY(), 
				Player.getPreviousx(), 
				Player.getPreviousy(), 
				Player.getBiome(), 
				Locations.getMap());
	}
	
	public void South() {
		System.out.println();
		System.out.println("You head south");
		Game.Sleep(1);
		Player.setPreviousx(Player.getX());
		Player.setPreviousy(Player.getY());  
		Player.setY(Player.getY() + 1);
		location.ChangePlayerLocation(
				Player.getX(), 
				Player.getY(), 
				Player.getPreviousx(), 
				Player.getPreviousy(), 
				Player.getBiome(), 
				Locations.getMap());
	}
	
	public void West() {
		System.out.println();
		System.out.println("You head west");
		Game.Sleep(1);
		Player.setPreviousx(Player.getX());
		Player.setPreviousy(Player.getY());
		Player.setX(Player.getX() - 1);
		location.ChangePlayerLocation(
				Player.getX(), 
				Player.getY(), 
				Player.getPreviousx(), 
				Player.getPreviousy(), 
				Player.getBiome(), 
				Locations.getMap());
	}
	
	public void Explore() {
		System.out.println();
		System.out.println("You search the nearby area");
		Game.Sleep(1);
		entity.Search(Player.getBiome().getEntitiesProbabilities(), Player.getX(), Player.getY());
	}
	
	public void Run() {
		System.out.println();
		System.out.println("Which way?");
		System.out.println("north, east, south or west?");
	}
	
	public void Exit() {
		System.out.println();
		System.out.println("You exited the game");
		Game.setRunning(false);
	}
}