package game.entities;

import game.Game;
import game.commands.Command;
import game.locations.Location;
import game.locations.Locations;
import game.tiles.TileGrid;

//import java.io.*;

public class Player {
	private int x = 1, y = 4, previousX, previousY;
	private Locations biome;
	private Entity entity;
	private Location location;
	private Command comm;
	
	public Player(TileGrid grid) {
		this.previousX = x;
		this.previousY = y;
		this.biome = Locations.PLAINS;
		this.entity = new Entity(grid);
		this.location = new Location(grid);
		this.comm = new Command(location);
	}
	
	public void startGame() {
		Game.setRunning(true);
		
		System.out.println("Welcome to Text Adventure!");
		Game.Sleep(1);
		System.out.println("You wake up on an abandoned island");
		Game.Sleep(1);
		System.out.println("The storm destroyed your cruise ship");
		Game.Sleep(1);
		System.out.println("You are the only survivor");
	}
	
	public void Update() {
		entity.update();
		location.update();
		comm.update();
		comm.TestForCommand();
	}
	
	public void requestLocationChange(int[] direction) {
		if(x  == 0 && direction[0] == -1 || y == 0 && direction[1] == -1) {
			System.out.println("You can't go there");
		} else {
			previousX = x;
			previousY = y;
			x += direction[0];
			y += direction[1];
			
			location.ChangePlayerLocation(x, y, previousX, previousY, biome);
		}
	}
	
	public void requestSearch() {
		if(entity.getExploredLocations()[y][x][0] == true) {
			System.out.println("You have already explored this location");
			Game.Sleep(1);
			entity.Found();
		} else {
			entity.Search(biome.getEntitiesProbabilities());
		}
	}

/*	public static void main(String[] args) {
		String[] inventory = {"1 Food", "2 Drink"};
		String fileName = "output.txt";

		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	
			for(String i:inventory) {
				bufferedWriter.write(i);
				bufferedWriter.newLine();
			}
	
			bufferedWriter.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}*/
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPreviousX() {
		return previousX;
	}

	public void setPreviousX(int previousX) {
		this.previousX = previousX;
	}

	public int getPreviousY() {
		return previousY;
	}

	public void setPreviousY(int previousY) {
		this.previousY = previousY;
	}

	public Locations getBiome() {
		return biome;
	}

	public void setBiome(Locations biome) {
		this.biome = biome;
	}
}