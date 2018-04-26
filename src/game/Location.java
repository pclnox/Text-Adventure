package game;

import entities.Player;
import globals.Locations;

public class Location {		
	public void ChangePlayerLocation(int x, int y, int previousx, int previousy, Locations biome, int[][] map) {
		if(map[y][x] == Locations.START.getMapValue()) {
			if(biome == Locations.PLAINS) {
				System.out.println("You are still on the plains");
				System.out.println("You are back where you started");
				System.out.println("explore or run?");
			} else {
				Player.setBiome(Locations.PLAINS);
				System.out.println("You are on the plains");
				System.out.println("You are back where you started");
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.SHORE.getMapValue()) {	
			if(biome == Locations.SHORE) {
				System.out.println("You are still on the beach");
				System.out.println("It seems to strech on forever, wrapping the island");
				System.out.println("swim, explore or run?");
			} else {
				Player.setBiome(Locations.SHORE);
				System.out.println("You have reached the shore");
				System.out.println("swim, explore or run?");
			}
		} else if(map[y][x] == Locations.WOODS.getMapValue()) {
			if(biome == Locations.WOODS) {
				System.out.println("You are still in the woods");
				System.out.println("It seems to strech on forever");
				System.out.println("explore or run?");
			} else {
				Player.setBiome(Locations.WOODS);
				System.out.println("You enter the woods");
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.PLAINS.getMapValue()) {
			if(biome == Locations.PLAINS) {
				System.out.println("You are still on the plains");
				System.out.println("It seems to strech on forever");
				System.out.println("explore or run?");
			} else {
				Player.setBiome(Locations.PLAINS);
				System.out.println("You are on the plains");
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.MOUNTAINS.getMapValue()) {
			if(biome == Locations.MOUNTAINS) {
				System.out.println("You are still in the mountains");
				System.out.println("They seem to reach endlessly into the sky and on into the distance");
				System.out.println("explore or run?");
			} else {
				Player.setBiome(Locations.MOUNTAINS);
				System.out.println("You climb the mountains");
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.DESERT.getMapValue()) {
			if(biome == Locations.DESERT) {
				System.out.println("You are still in the desert");
				System.out.println("It seems to strech on forever, but is that a mirage?");
				System.out.println("explore or run?");
			} else {
				Player.setBiome(Locations.DESERT);
				System.out.println("You enter the arid desert");
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.VOLCANO.getMapValue()) {
			Player.setBiome(Locations.VOLCANO);
			System.out.println("You climb the lone volcano");
			System.out.println("explore or run?");
		} else {
			Player.setX(previousx);
			Player.setY(previousy);
			System.out.println("That's the sea"); 
			System.out.println("swim or run?");
		}
	}
}