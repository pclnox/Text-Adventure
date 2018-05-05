package game.tiles;

import game.Game;

public class TileGrid {
	private int tilesWide, tilesHigh;
	private int[][] map;
	private Tile[][] tileMap;
	
	public TileGrid(int[][] newMap) {
		this.map = newMap;
		this.tilesWide = map[0].length;
		this.tilesHigh = map.length;
		
		tileMap = new Tile[tilesWide][tilesHigh];
		
		for(int i = 0; i < tileMap.length; i++) {
			for(int j = 0; j < tileMap[i].length; j++) {
				switch(map[j][i]) {
				case -1:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Water);
					break;
				case 0:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Start);
					break;
				case 1:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Beach);
					break;
				case 2:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Forest);
					break;
				case 3:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Plains);
					break;
				case 4:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Mountains);
					break;
				case 5:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Desert);
					break;
				case 6:
					tileMap[i][j] = new Tile(i * Game.tileSize, j * Game.tileSize, Game.tileSize, TileType.Volcano);
					break;
				}
			}
		}
	}
	
	public Tile GetTile(int xPlace, int yPlace)	{
		if (xPlace < tilesWide && yPlace < tilesHigh && xPlace > -1 && yPlace > -1) {
			return tileMap[xPlace][yPlace];
		} else {
			return new Tile(0, 0, Game.tileSize, TileType.Water);
		}
	}

	public int getTilesWide() {
		return tilesWide;
	}

	public int getTilesHigh() {
		return tilesHigh;
	}
	
	public int[][] getMap() {
		return map;
	}
}
