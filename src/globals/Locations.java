package globals;

public enum Locations {
	START("start", 0, new int[3], 0, 0, 0), 
	SHORE("shore", 1, new int[3], 0, 0, 50), 
	WOODS("woods", 2, new int[3], 50, 70, 60), 
	PLAINS("plains", 3, new int[3], 60, 50, 60), 
	MOUNTAINS("mountains", 4, new int[3], 0, 0, 0), 
	DESERT("desert", 5, new int[3], 0, 0, 0), 
	VOLCANO("volcano", 6, new int[3], 0, 0, 0),
	SEA("sea", -2, new int[3], 0, 0, 0);
	
	String locationName;
	int mapValue;
	int[] entitiesProbabilities;
	
	private static int[][] map = {
			{-1, 1, 1, 1, 1, 1, -1},
			{1, 1, 4, 2, 2, 1, 1},
			{1, 4, 2, 3, 2, 2, 1},
			{1, 4, 3, 5, 5, 5, 1},
			{1, 0, 3, 5, 6, 5, 1},
			{1, 3, 2, 3, 5, 5, 1},
			{1, 5, 5, 4, 4, 1, 1},
			{1, 1, 1, 1, 1, 1, -1},
	};
	
	final static int TILES_HIGH = map.length, TILES_WIDE = map[0].length;
	
	private Locations(String locationName, int mapValue, int[] entitiesProbabilities, int lakeProb, int groveProb, int caveProb) {
		this.locationName = locationName;
		this.mapValue = mapValue;
		entitiesProbabilities[0] = lakeProb;
		entitiesProbabilities[1] = groveProb;
		entitiesProbabilities[2] = caveProb;
		this.entitiesProbabilities = entitiesProbabilities;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public int getMapValue() {
		return mapValue;
	}

	public static int[][] getMap() {
		return map;
	}
	
	public int[] getEntitiesProbabilities() {
		return entitiesProbabilities;
	}

	public static int getTilesHigh() {
		return TILES_HIGH;
	}

	public static int getTilesWide() {
		return TILES_WIDE;
	}
	
}