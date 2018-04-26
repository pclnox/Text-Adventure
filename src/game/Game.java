package game;

import globals.Entities;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Game {
	private static boolean running = true;	

	public static Scanner userInput = new Scanner(System.in);
	
	public static void Sleep(int time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch(InterruptedException e) {
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Text Adventure!");
		System.out.println("You wake up on an abandoned island");
		System.out.println("The storm destroyed your cruise ship");
		System.out.println("You are the only survivor");

		for(int i = 0; i < Entities.getExploredLocations().length; i++) {
			for(int j = 0; j < Entities.getExploredLocations()[0].length; j++) {
				Entities.setExploredLocations(0, j, i, false);
			}
		}
		
		Command.main(null);
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Game.running = running;
	}
}