package game.tiles;

public enum TileType {
	
	Water("water tile"), 
	Start("plains tile"),
	Beach("beach tile"),
	Forest("forest tile"),
	Plains("plains tile"),
	Mountains("mountains tile"),
	Desert("desert tile"),
	Volcano("volcano tile");
	
	String textureName;
	
	TileType(String textureName) {
		this.textureName = textureName;
	}
}
