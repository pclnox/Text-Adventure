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
			for(int i : generatedEntities) {
				System.out.print(i + "-");
			}
			System.out.println("You found:");
			if(generatedEntities[Entities.LAKE.getEntityMapLocation()] == 1) {
				if(Entities.getExploredLocations()[y][x][1] == true) {
					System.out.println("A big lake (" + generatedEntities[SubEntities.FISH.getEntityMapLocationStart()] + " fish)");
					
				} else {
					System.out.println("A lake (" + generatedEntities[SubEntities.FISH.getEntityMapLocationStart()] + " fish)");
				}
			}
			if(generatedEntities[Entities.GROVE.getEntityMapLocation()] == 2) {
				System.out.println("2 groves (" + generatedEntities[SubEntities.TREES.getEntityMapLocationStart()] + ", " + generatedEntities[SubEntities.TREES.getEntityMapLocationEnd()] + " trees)");
				if(generatedEntities[SubEntities.LAKE.getEntityMapLocationStart()] == 2) {
					System.out.println("In each grove there is a lake (" + generatedEntities[SubEntities._FISH.getEntityMapLocationStart()] + ", " + generatedEntities[SubEntities._FISH.getEntityMapLocationEnd()] + " fish)");
				
				} else if(generatedEntities[SubEntities.LAKE.getEntityMapLocationStart()] == 1) {
					System.out.println("In the first grove there is a lake (" + generatedEntities[SubEntities._FISH.getEntityMapLocationStart()] + " fish)");
				}
			} else if(generatedEntities[Entities.GROVE.getEntityMapLocation()] == 1) {
				System.out.println("A grove (" + generatedEntities[3] + " trees)");
				if(generatedEntities[SubEntities.LAKE.getEntityMapLocationStart()] == 1) {
					System.out.println("In the grove there is a lake (" + generatedEntities[SubEntities._FISH.getEntityMapLocationStart()] + " fish)");
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
