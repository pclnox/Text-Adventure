package game.entities;

public enum Entities {
	LAKE("lake", 1, 0, new int[3], 100, 0, 40), 
	GROVE("grove", 2, 2, new int[3], 0, 100, 40), 
	CAVE("cave", 2, 8, new int[3], 0, 0, 40);
	//RIVER("river", 1, 14);
	
	String entityName;
	int entityMaxSpawns, entityMapLocation, fishProb, treesProb, lakeProb;
	int[] subEntitiesProbabilities;
	
	private Entities(String entityName, int entityMaxSpawns, int entityMapLocation, int[] subEntitiesProbabilities, int fishProb, int treesProb, int lakeProb) {
		this.entityName = entityName;
		this.entityMaxSpawns = entityMaxSpawns;
		this.entityMapLocation = entityMapLocation;
		subEntitiesProbabilities[0] = fishProb;
		subEntitiesProbabilities[1] = treesProb;
		subEntitiesProbabilities[2] = lakeProb;
		this.subEntitiesProbabilities = subEntitiesProbabilities;
	}

	public String getEntityName() {
		return entityName;
	}
	
	public int getEntityMaxSpawns() {
		return entityMaxSpawns;
	}
	
	public int getEntityMapLocation() {
		return entityMapLocation;
	}

	public int[] getSubEntitiesProbabilities() {
		return subEntitiesProbabilities;
	}
}
