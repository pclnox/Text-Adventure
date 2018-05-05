package game.entities;

import game.Game;
import game.tiles.TileGrid;

public class Entity {
	private int x, y;
	private int[][][] entityMap;
	private boolean[][][] exploredLocations;
	private Player player;
	
	public Entity(TileGrid grid) {
		this.entityMap = new int[grid.getTilesHigh()][grid.getTilesWide()][14];
		this.exploredLocations = new boolean[grid.getTilesHigh()][grid.getTilesWide()][5];
	}
	
	public void update() {
		this.player = Game.getPlayer();
		this.x = player.getX();
		this.y = player.getY();
	}
	
	public void Search(int[] entitiesProbabilities) {
		generateAllEntities(x, y, entitiesProbabilities);

		if(isAnyEntities(entityMap[y][x])) {
			exploredLocations[y][x][4] = true;
		}
		
		Found();
	}
		
	public void Found() {
		if(exploredLocations[y][x][4]) {
			System.out.println("You didn't find anything worth noting");
		} else {
			System.out.println("You found:");
			if(exploredLocations[y][x][1]) {
				Game.Sleep(1);
				System.out.println("A big lake (" + entityMap[y][x][SubEntities.FISH.getEntityMapLocationStart()] + " fish)");
					
			} else if(entityMap[y][x][Entities.LAKE.getEntityMapLocation()] == 1){
				Game.Sleep(1);
				System.out.println("A lake (" + entityMap[y][x][SubEntities.FISH.getEntityMapLocationStart()] + " fish)");
			}
			if(entityMap[y][x][Entities.GROVE.getEntityMapLocation()] == 2) {
				Game.Sleep(1);
				System.out.println("2 groves (" + entityMap[y][x][SubEntities.TREES.getEntityMapLocationStart()] + ", " + entityMap[y][x][SubEntities.TREES.getEntityMapLocationEnd()] + " trees)");
				if(entityMap[y][x][SubEntities.GROVE_LAKE.getEntityMapLocationStart()] == 2) {
					Game.Sleep(1);
					System.out.println("In each grove there is a lake (" + entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationStart()] + ", " + entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationEnd()] + " fish)");
				
				} else if(entityMap[y][x][SubEntities.GROVE_LAKE.getEntityMapLocationStart()] == 1) {
					Game.Sleep(1);
					System.out.println("In the first grove there is a lake (" + entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			} else if(entityMap[y][x][Entities.GROVE.getEntityMapLocation()] == 1) {
				Game.Sleep(1);
				System.out.println("A grove (" + entityMap[y][x][3] + " trees)");
				if(exploredLocations[y][x][2]) {
					Game.Sleep(1);
					System.out.println("In the grove there is a lake (" + entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			}
			if(entityMap[y][x][Entities.CAVE.getEntityMapLocation()] == 2) {
				Game.Sleep(1);
				System.out.println("2 caves");
				if(entityMap[y][x][SubEntities.CAVE_LAKE.getEntityMapLocationStart()] == 2) {
					Game.Sleep(1);
					System.out.println("In each cave there is a lake (" + entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationStart()] + ", " + entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationEnd()] + " fish)");
				
				} else if(entityMap[y][x][SubEntities.CAVE_LAKE.getEntityMapLocationStart()] == 1) {
					Game.Sleep(1);
					System.out.println("In the first cave there is a lake (" + entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			} else if(entityMap[y][x][Entities.CAVE.getEntityMapLocation()] == 1) {
				Game.Sleep(1);
				System.out.println("A cave");
				if(exploredLocations[y][x][3]) {
					Game.Sleep(1);
					System.out.println("In the cave there is a lake (" + entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationStart()] + " fish)");
				}
			}
		}
	}
	
	private void generateAllEntities(int x, int y, int[] entitiesProbabilities) {
		exploredLocations[y][x][0] = true;
		
		int i = 0, k = 0;
		
		for(Entities entities : Entities.values()) {
			for(int j = 0; j < entities.getEntityMaxSpawns(); j++) {
				if((int)(Math.random() * 100 + 1) <= entitiesProbabilities[i]) {
					generateSubEntities(x, y, entities.getSubEntitiesProbabilities(), entities);
					k++;
				}
			}
			entityMap[y][x][entities.getEntityMapLocation()] = k;
			i++;
			k = 0;
		}
	}
	
	private void generateSubEntities(int x, int y, int[] subEntitiesProbabilities, Entities entities) {
		int i = 0, j = 0, k = 0;
		
		for(SubEntities subEntities : SubEntities.values()) {
			if(subEntities != SubEntities.GROVE_FISH || subEntities != SubEntities.CAVE_FISH) {
				if((int)(Math.random() * 100 + 1) <= subEntitiesProbabilities[i]) {
					if(entities == Entities.LAKE && subEntities == SubEntities.GROVE_LAKE) {
						exploredLocations[y][x][1] = true;
			
						k = entityMap[y][x][SubEntities.FISH.getEntityMapLocationStart()] + 300;
						entityMap[y][x][SubEntities.FISH.getEntityMapLocationStart()] = k;
						
					} else if(entities == Entities.GROVE && subEntities == SubEntities.GROVE_LAKE) {
						exploredLocations[y][x][2] = true;
						
						j = entityMap[y][x][subEntities.getEntityMapLocationStart()] + 1;
						k = (int)(Math.random() * SubEntities.FISH.getSubEntityMaxSpawns() + SubEntities.FISH.getSubEntityMinSpawns());
						if(entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationStart()] == 0) {
							entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationStart()] = k;
							
						} else {
							entityMap[y][x][SubEntities.GROVE_FISH.getEntityMapLocationEnd()] = k;
						}
					} else if(entities == Entities.CAVE && subEntities == SubEntities.CAVE_LAKE) {
						exploredLocations[y][x][3] = true;
						
						j = entityMap[y][x][subEntities.getEntityMapLocationStart()] + 1;
						k = (int)(Math.random() * SubEntities.FISH.getSubEntityMaxSpawns() + SubEntities.FISH.getSubEntityMinSpawns());
						if(entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationStart()] == 0) {
							entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationStart()] = k;
							
						} else {
							entityMap[y][x][SubEntities.CAVE_FISH.getEntityMapLocationEnd()] = k;
						}
					} else {
						j = (int)(Math.random() * subEntities.getSubEntityMaxSpawns() + subEntities.getSubEntityMinSpawns());
					}
				}
				if(entityMap[y][x][subEntities.getEntityMapLocationStart()] == 0 && j != 0) {
					entityMap[y][x][subEntities.getEntityMapLocationStart()] = j;
					
				} else if(j != 0) {
					entityMap[y][x][subEntities.getEntityMapLocationEnd()] = j;
				}
				if(subEntities == SubEntities.FISH || subEntities == SubEntities.TREES) {
					i++;
				}
				j = 0;
				k = 0;
			}
		}
	}
	
	private boolean isAnyEntities(int[] generatedEntities) {
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
	
	public boolean[][][] getExploredLocations() {
		return exploredLocations;
	}
}
