import model.Game;
import service.GameSetupService;
import service.GameplayService;

class SnakeNLadder {
	
	public static void main(String[] args) {
		System.out.println("Snake N Ladder Game started");

		Game game = new Game(100, 8, 7);
		
		GameSetupService gameSetupService = new GameSetupService();
		gameSetupService.setupGame(game);		

		GameplayService gameplayService = new GameplayService();
		gameplayService.playGame(4, game);
		
		System.out.println("\nSnake N Ladder Game ends");
	}

}