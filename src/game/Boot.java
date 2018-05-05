package game;

public class Boot {
	public static void main(String[] args) {
		new Boot();
	}

	public Boot() {
		int[][] map = {
				{-1, 1, 1, 1, 1, 1, -1},
				{1, 1, 4, 2, 2, 1, 1},
				{1, 4, 2, 3, 2, 2, 1},
				{1, 4, 3, 5, 5, 5, 1},
				{1, 0, 3, 5, 6, 5, 1},
				{1, 3, 2, 3, 5, 5, 1},
				{1, 5, 5, 4, 4, 1, 1},
				{1, 1, 1, 1, 1, 1, -1},
		};
		
		 Game game = new Game(map);
		
		while(Game.isRunning()) {
			game.update();			
		}
	}
}
