package entities;

import globals.Locations;
//import java.io.*;

public class Player {
	private static int x = 1, y = 4, previousx, previousy;
	
	private static Locations biome = Locations.PLAINS;

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
	
	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Player.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Player.y = y;
	}

	public static int getPreviousx() {
		return previousx;
	}

	public static void setPreviousx(int previousx) {
		Player.previousx = previousx;
	}

	public static int getPreviousy() {
		return previousy;
	}

	public static void setPreviousy(int previousy) {
		Player.previousy = previousy;
	}

	public static Locations getBiome() {
		return biome;
	}

	public static void setBiome(Locations biome) {
		Player.biome = biome;
	}
}