package entities;

import globals.Entities;
import globals.SubEntities;

public class Entity {
	int[] generateEntitiesList = new int[14];
	
	public void Search(int[] entitiesProbabilities, int x, int y) {		
		int[] generatedEntities = generateAllEntities(entitiesProbabilities, x, y);

		if(isAnyEntities(generatedEntities)) {
			Entities.setExploredLocations(4, x, y, true);
		}
		
		if(Entities.getExploredLocations()[y][x][4]) {
			System.out.println("You didn't find anything worth noting");
		} else {
			System.out.println("You found:");
			if(Entities.getExploredLocations()[y][x][1]) {
				System.out.println("A big lake (" + generatedEntities[SubEntities.FISH.getEntityMapLocationStart()] + " fish)");
					
			} else if(generatedEntities[Entities.LAKE.getEntityMapLocation()] == 1){
				System.out.println("A lake (" + generatedEntities[SubEntities.FISH.getEntityMapLocationStart()] + " fish)");
			}
			if(generatedEntities[Entities.GROVE.getEntityMapLocation()] == 2) {
				System.out.println("2 groves (" + generatedEntities[SubEntities.TREES.getEntityMapLocationStart()] + ", " + generatedEntities[SubEntities.TREES.getEntityMapLocationEnd()] + " trees)");
				if(generatedEntities[SubEntities.GROVE_LAKE.getEntityMapLocationStart()] == 2) {
					System.out.println("In each grove there is a lake (" + generatedEntities[SubEntities.GROVE_FISH.getEntityMapLocationStart()] + ", " + generatedEntities[SubEntities.GROVE_FISH.getEntityMapLocationEnd()] + " fish)");
				
				} else if(generatedEntities[SubEntities.GROVE_LAKE.getEntityMapLocationStart()] == 1) {
					System.out.println("In the first grove there is a lake (" + generatedEntities[SubEntities.GROVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			} else if(generatedEntities[Entities.GROVE.getEntityMapLocation()] == 1) {
				System.out.println("A grove (" + generatedEntities[3] + " trees)");
				if(Entities.getExploredLocations()[y][x][2]) {
					System.out.println("In the grove there is a lake (" + generatedEntities[SubEntities.GROVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			}
			if(generatedEntities[Entities.CAVE.getEntityMapLocation()] == 2) {
				System.out.println("2 caves");
				if(generatedEntities[SubEntities.CAVE_LAKE.getEntityMapLocationStart()] == 2) {
					System.out.println("In each cave there is a lake (" + generatedEntities[SubEntities.CAVE_FISH.getEntityMapLocationStart()] + ", " + generatedEntities[SubEntities.CAVE_FISH.getEntityMapLocationEnd()] + " fish)");
				
				} else if(generatedEntities[SubEntities.CAVE_LAKE.getEntityMapLocationStart()] == 1) {
					System.out.println("In the first cave there is a lake (" + generatedEntities[SubEntities.CAVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			} else if(generatedEntities[Entities.CAVE.getEntityMapLocation()] == 1) {
				System.out.println("A cave");
				if(Entities.getExploredLocations()[y][x][3]) {
					System.out.println("In the cave there is a lake (" + generatedEntities[SubEntities.CAVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			}
		}
	}
	
	public int[] generateAllEntities(int[] entitiesProbabilities, int x, int y) {
		int i = 0, k = 0;
		
		for(Entities entities : Entities.values()) {
			for(int j = 0; j < entities.getEntityMaxSpawns(); j++) {
				if((int)(Math.random() * 100 + 1) <= entitiesProbabilities[i]) {
					generateSubEntities(entities, entities.getSubEntitiesProbabilities(), x, y);
					k++;
				}
			}
			Entities.setEntityMap(entities.getEntityMapLocation(), x, y, k);
			generateEntitiesList[entities.getEntityMapLocation()] = k;
			i++;
			k = 0;
		}
		
		return generateEntitiesList;
	}
	
	public void generateSubEntities(Entities entities, int[] subEntitiesProbabilities, int x, int y) {
		int i = 0, j = 0, k = 0;
		
		for(SubEntities subEntities : SubEntities.values()) {
			if(subEntities != SubEntities.GROVE_FISH || subEntities != SubEntities.CAVE_FISH) {
				if((int)(Math.random() * 100 + 1) <= subEntitiesProbabilities[i]) {
					if(entities == Entities.LAKE && subEntities == SubEntities.GROVE_LAKE) {
						Entities.setExploredLocations(1, x, y, true);
			
						k = Entities.getEntityMap(SubEntities.FISH.getEntityMapLocationStart(), x, y) + 300;
						Entities.setEntityMap(SubEntities.FISH.getEntityMapLocationStart(), x, y, k);
						generateEntitiesList[SubEntities.FISH.getEntityMapLocationStart()] = k;
						
					} else if(entities == Entities.GROVE && subEntities == SubEntities.GROVE_LAKE) {
						Entities.setExploredLocations(2, x, y, true);
						
						j = Entities.getEntityMap(subEntities.getEntityMapLocationStart(), x, y) + 1;
						k = (int)(Math.random() * SubEntities.FISH.getSubEntityMaxSpawns() + SubEntities.FISH.getSubEntityMinSpawns());
						if(Entities.getEntityMap(SubEntities.GROVE_FISH.getEntityMapLocationStart(), x, y) == 0) {
							Entities.setEntityMap(SubEntities.GROVE_FISH.getEntityMapLocationStart(), x, y, k);
							generateEntitiesList[SubEntities.GROVE_FISH.getEntityMapLocationStart()] = k;
							
						} else {
							Entities.setEntityMap(SubEntities.GROVE_FISH.getEntityMapLocationEnd(), x, y, k);
							generateEntitiesList[SubEntities.GROVE_FISH.getEntityMapLocationEnd()] = k;
						}
					} else if(entities == Entities.CAVE && subEntities == SubEntities.CAVE_LAKE) {
						Entities.setExploredLocations(3, x, y, true);
						
						j = Entities.getEntityMap(subEntities.getEntityMapLocationStart(), x, y) + 1;
						k = (int)(Math.random() * SubEntities.FISH.getSubEntityMaxSpawns() + SubEntities.FISH.getSubEntityMinSpawns());
						if(Entities.getEntityMap(SubEntities.CAVE_FISH.getEntityMapLocationStart(), x, y) == 0) {
							Entities.setEntityMap(SubEntities.CAVE_FISH.getEntityMapLocationStart(), x, y, k);
							generateEntitiesList[SubEntities.CAVE_FISH.getEntityMapLocationStart()] = k;
							
						} else {
							Entities.setEntityMap(SubEntities.CAVE_FISH.getEntityMapLocationEnd(), x, y, k);
							generateEntitiesList[SubEntities.CAVE_FISH.getEntityMapLocationEnd()] = k;
						}
					} else {
						j = (int)(Math.random() * subEntities.getSubEntityMaxSpawns() + subEntities.getSubEntityMinSpawns());
					}
				}
				if(Entities.getEntityMap(subEntities.getEntityMapLocationStart(), x, y) == 0 && j != 0) {
					Entities.setEntityMap(subEntities.getEntityMapLocationStart(), x, y, j);
					generateEntitiesList[subEntities.getEntityMapLocationStart()] = j;
					
				} else if(j != 0) {
					Entities.setEntityMap(subEntities.getEntityMapLocationEnd(), x, y, j);
					generateEntitiesList[subEntities.getEntityMapLocationEnd()] = j;
				}
				if(subEntities == SubEntities.FISH || subEntities == SubEntities.TREES) {
					i++;
				}
				j = 0;
				k = 0;
			}
		}
	}
	
	public boolean isAnyEntities(int[] generatedEntities) {
		int zeroCount = 0;
		
		for(int i : generatedEntities) {
			if(i == 0) {
				zeroCount++;
			}
		}
		
		if(zeroCount == generatedEntities.length) {
			return true;
		
		} else {
			return false;
		}
	}
}
