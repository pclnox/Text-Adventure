package game.locations;

import game.Game;
import game.entities.Player;
import game.tiles.TileGrid;

public class Location {	
	
	private int[][] map;
	private Player player;
	
	public Location(TileGrid grid) {
		this.map = grid.getMap();
	}
	
	public void update() {
		this.player = Game.getPlayer();
	}
	
	public void ChangePlayerLocation(int x, int y, int previousX, int previousY, Locations biome) {
		if(map[y][x] == Locations.START.getMapValue()) {
			if(biome == Locations.PLAINS) {
				System.out.println("You are still on the plains");
				Game.Sleep(1);
				System.out.println("You are back where you started");
				Game.Sleep(1);
				System.out.println("explore or run?");
			} else {
				player.setBiome(Locations.PLAINS);
				System.out.println("You are on the plains");
				Game.Sleep(1);
				System.out.println("You are back where you started");
				Game.Sleep(1);
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.SHORE.getMapValue()) {	
			if(biome == Locations.SHORE) {
				System.out.println("You are still on the beach");
				Game.Sleep(1);
				System.out.println("It seems to strech on forever, wrapping the island");
				Game.Sleep(1);
				System.out.println("swim, explore or run?");
			} else {
				player.setBiome(Locations.SHORE);
				System.out.println("You have reached the shore");
				Game.Sleep(1);
				System.out.println("swim, explore or run?");
			}
		} else if(map[y][x] == Locations.WOODS.getMapValue()) {
			if(biome == Locations.WOODS) {
				System.out.println("You are still in the woods");
				Game.Sleep(1);
				System.out.println("It seems to strech on forever");
				Game.Sleep(1);
				System.out.println("explore or run?");
			} else {
				player.setBiome(Locations.WOODS);
				System.out.println("You enter the woods");
				Game.Sleep(1);
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.PLAINS.getMapValue()) {
			if(biome == Locations.PLAINS) {
				System.out.println("You are still on the plains");
				Game.Sleep(1);
				System.out.println("It seems to strech on forever");
				Game.Sleep(1);
				System.out.println("explore or run?");
			} else {
				player.setBiome(Locations.PLAINS);
				System.out.println("You are on the plains");
				Game.Sleep(1);
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.MOUNTAINS.getMapValue()) {
			if(biome == Locations.MOUNTAINS) {
				System.out.println("You are still in the mountains");
				Game.Sleep(1);
				System.out.println("They seem to reach endlessly into the sky and on into the distance");
				Game.Sleep(1);
				System.out.println("explore or run?");
			} else {
				player.setBiome(Locations.MOUNTAINS);
				System.out.println("You climb the mountains");
				Game.Sleep(1);
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.DESERT.getMapValue()) {
			if(biome == Locations.DESERT) {
				System.out.println("You are still in the desert");
				Game.Sleep(1);
				System.out.println("It seems to strech on forever, but is that a mirage?");
				Game.Sleep(1);
				System.out.println("explore or run?");
			} else {
				player.setBiome(Locations.DESERT);
				System.out.println("You enter the arid desert");
				Game.Sleep(1);
				System.out.println("explore or run?");
			}
		} else if(map[y][x] == Locations.VOLCANO.getMapValue()) {
			player.setBiome(Locations.VOLCANO);
			System.out.println("You climb the lone volcano");
			Game.Sleep(1);
			System.out.println("explore or run?");
		} else {
			player.setX(previousX);
			player.setY(previousY);
			System.out.println("That's the sea"); 
			Game.Sleep(1);
			System.out.println("swim or run?");
		}
	}
}