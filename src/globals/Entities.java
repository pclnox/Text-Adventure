package globals;

public enum Entities {
	LAKE("lake", 1, 0, new int[3], 100, 0, 40), 
	GROVE("grove", 2, 2, new int[3], 0, 100, 40), 
	CAVE("cave", 2, 8, new int[3], 0, 0, 40);
	//RIVER("river", 1, 14);
	
	String entityName;
	int entityMaxSpawns, entityMapLocation, fishProb, treesProb, lakeProb;
	static final int MAX_SPAWNS = 6;
	int[] subEntitiesProbabilities;
	static int[][][] entityMap = new int[Locations.getTilesHigh()][Locations.getTilesWide()][14];
	static boolean[][][] exploredLocations = new boolean[Locations.getTilesHigh()][Locations.getTilesWide()][5];
	
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

	public static int getMaxSpawns() {
		return MAX_SPAWNS;
	}

	public static int getEntityMap(int x, int y, int z) {
		return entityMap[z][y][x];
	}
	
	public static void setEntityMap(int x, int y, int z, int element) {
		entityMap[z][y][x] = element;
	}

	public static boolean[][][] getExploredLocations() {
		return exploredLocations;
	}

	public static void setExploredLocations(int x, int y, int z, boolean element) {
		exploredLocations[z][y][x] = element;
	}
	
}
