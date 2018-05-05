package game.entities;

public enum SubEntities {
	FISH("fish", 1, 150, 1, 1),
	TREES("trees", 10, 20, 3, 4),
	GROVE_LAKE("lake", 0, 0, 5, 5),
	GROVE_FISH("fish", 0, 0, 6, 7),
	CAVE_LAKE("lake", 0, 0, 11, 11),
	CAVE_FISH("fish", 0, 0, 12, 13);
	
	String subEntityName;
	int subEntityMinSpawns, subEntityMaxSpawns, entityMapLocationStart, entityMapLocationEnd;
	
	private SubEntities(String subEntityName, int subEntityMinSpawns, int subEntityMaxSpawns, int entityMapLocationStart, int entityMapLocationEnd) {
		this.subEntityName = subEntityName;
		this.subEntityMinSpawns = subEntityMinSpawns;
		this.subEntityMaxSpawns = subEntityMaxSpawns;
		this.entityMapLocationStart = entityMapLocationStart;
		this.entityMapLocationEnd = entityMapLocationEnd;
	}

	public String getSubEntityName() {
		return subEntityName;
	}

	public int getSubEntityMinSpawns() {
		return subEntityMinSpawns;
	}

	public int getSubEntityMaxSpawns() {
		return subEntityMaxSpawns;
	}

	public int getEntityMapLocationStart() {
		return entityMapLocationStart;
	}

	public int getEntityMapLocationEnd() {
		return entityMapLocationEnd;
	}
}
