package entities;

import globals.Entities;
import globals.SubEntities;

public class Entity {
	int[] generateEntitiesList = new int[13];
	
	public void Search(int[] entitiesProbabilities, int x, int y) {		
		int[] generatedEntities = generateAllEntities(entitiesProbabilities, x, y);
		
		
		if(Entities.getExploredLocations()[y][x][3] == true) {
			System.out.println("You didn't find anything worth noting");
		} else {
			System.out.println("You found:");
			if(generatedEntities[0] > 0) {
				if(Entities.getExploredLocations()[y][x][1] == true) {
					System.out.println("A big lake (" + generatedEntities[1] + " fish)");
				} else {
					System.out.println("A lake (" + generatedEntities[1] + " fish)");
				}
			}
			if(generatedEntities[2] > 0 && generatedEntities[2] == 2) {
				System.out.println("2 groves (" + generatedEntities[3] + ", " + generatedEntities[4] + " trees)");
			} else if(generatedEntities[2] > 0 && generatedEntities[2] == 1) {
				System.out.println("A grove (" + generatedEntities[3] + " trees)");
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
			entities.setEntityMap(entities.getEntityMapLocation(), x, y, k);
			generateEntitiesList[entities.getEntityMapLocation()] = k;
			i++;
		}
		
		return generateEntitiesList;
	}
	
	public void generateSubEntities(Entities entities, int[] subEntitiesProbabilities, int x, int y) {
		int i = 0, j = 0, k = 0;
		
		for(SubEntities subEntities : SubEntities.values()) {
			if(subEntities == SubEntities._FISH) {
				break;
				
			} else {
				if((int)(Math.random() * 100 + 1) <= subEntitiesProbabilities[i]) {
					if(entities == Entities.LAKE && subEntities == SubEntities.LAKE) {
						Entities.setExploredLocations(1, x, y, true);
			
						k = Entities.getEntityMap(SubEntities.FISH.getEntityMapLocationStart(), x, y) + 300;
						Entities.setEntityMap(SubEntities.FISH.getEntityMapLocationStart(), x, y, k);
						generateEntitiesList[SubEntities.FISH.getEntityMapLocationStart()] = k;
						
					} else if(entities == Entities.GROVE && subEntities == SubEntities.LAKE) {
						Entities.setExploredLocations(2, x, y, true);
						
						j = Entities.getEntityMap(subEntities.getEntityMapLocationStart(), x, y) + 1;
						k = (int)(Math.random() * SubEntities.FISH.getSubEntityMaxSpawns() + SubEntities.FISH.getSubEntityMinSpawns());
						if(Entities.getEntityMap(SubEntities._FISH.getEntityMapLocationStart(), x, y) == 0) {
							Entities.setEntityMap(SubEntities._FISH.getEntityMapLocationStart(), x, y, k);
							generateEntitiesList[SubEntities._FISH.getEntityMapLocationStart()] = k;
							
						} else {
							Entities.setEntityMap(SubEntities._FISH.getEntityMapLocationEnd(), x, y, k);
							generateEntitiesList[SubEntities._FISH.getEntityMapLocationEnd()] = k;
						}
						
					} else {
						j = (int)(Math.random() * 100 + subEntities.getSubEntityMinSpawns());
					}
				}
				if(Entities.getEntityMap(subEntities.getEntityMapLocationStart(), x, y) == 0 && j != 0) {
					Entities.setEntityMap(subEntities.getEntityMapLocationStart(), x, y, j);
					generateEntitiesList[subEntities.getEntityMapLocationStart()] = j;
				} else if(j != 0) {
					Entities.setEntityMap(subEntities.getEntityMapLocationEnd(), x, y, j);
					generateEntitiesList[subEntities.getEntityMapLocationEnd()] = j;
				}
				i++;
				j = 0;
				k = 0;
			}
		}
	}
}
