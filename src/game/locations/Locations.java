package game.locations;

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
	
	public int[] getEntitiesProbabilities() {
		return entitiesProbabilities;
	}
}