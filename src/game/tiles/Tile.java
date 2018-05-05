package game.tiles;

import org.newdawn.slick.opengl.Texture;

public class Tile {
	private int x, y, tileSize;
	private Texture texture;
	private TileType type;
	
	public Tile(int x, int y, int tileSize, TileType type) {
		this.x = x;
		this.y = y;
		this.tileSize = tileSize;
		this.type = type;
	}
}
