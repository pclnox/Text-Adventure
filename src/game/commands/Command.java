package game.commands;

import java.util.Scanner;

import game.Game;
import game.entities.Player;
import game.locations.Location;

public class Command {
	private String statement;
	
	private int[] direction;
	private Scanner userInput;
	private Player player;
	
	public Command(Location location) {
		this.direction = new int[2];
		this.direction[0] = 0;
		this.direction[1] = 0;
		this.userInput = new Scanner(System.in);
	}
	
	public void update() {
		this.direction[0] = 0;
		this.direction[1] = 0;
		this.player = Game.getPlayer();
	}
	
	public void TestForCommand() {	
		if(userInput.hasNextLine()) {
			statement = userInput.nextLine();
			
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
				Game.Sleep(1);
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
	
	public void North() {
		System.out.println();
		System.out.println("You head north");
		Game.Sleep(1);
		direction[1] = -1;
		player.requestLocationChange(direction);
	}
	
	public void East() {
		System.out.println();
		System.out.println("You head east");
		Game.Sleep(1);
		direction[0] = 1;
		player.requestLocationChange(direction);
	}
	
	public void South() {
		System.out.println();
		System.out.println("You head south");
		Game.Sleep(1);
		direction[1] = 1;
		player.requestLocationChange(direction);
	}
	
	public void West() {
		System.out.println();
		System.out.println("You head west");
		Game.Sleep(1);
		direction[0] = -1;
		player.requestLocationChange(direction);
	}
	
	public void Explore() {
		System.out.println();
		System.out.println("You search the nearby area");
		Game.Sleep(1);
		player.requestSearch();
	}
	
	public void Run() {
		System.out.println();
		System.out.println("Which way?");
		Game.Sleep(1);
		System.out.println("north, east, south or west?");
	}
	
	public void Exit() {
		System.out.println();
		System.out.println("You exited the game");
		Game.setRunning(false);
	}
}