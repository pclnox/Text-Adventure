package game;

import java.util.concurrent.TimeUnit;

import game.entities.Player;
import game.tiles.TileGrid;

public class Game {
	private static Player player;
	private TileGrid grid;
	private static boolean running;
	public static final int tileSize = 64;
	
	public Game(int[][] map) {
		grid = new TileGrid(map);
		player = new Player(grid);
		running = false;
		
		player.startGame();
	}
	
	public void update() {
		player.Update();
	}
	
	public static void Sleep(int time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch(InterruptedException e) {
		}
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Game.running = running;
	}
}