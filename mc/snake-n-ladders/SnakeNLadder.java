import model.Game;
import service.GameSetupService;
import service.GameplayService;
import java.util.Scanner;

class SnakeNLadder {
	
	public static void main(String[] args) {
		System.out.println("Snake N Ladder Game started");

		Scanner sc = new Scanner(System.in);
		int snakes = -1;
		int ladders = -1;
		int players = -1;
		boolean validInput = false;

		while (!validInput) {
			System.out.println("\nEnter number of snakes (max = 15, min = 5)... -1 to exit");
			snakes = sc.nextInt();

			if (snakes == -1) { 
				System.out.println("\n Exited ... Bye");
				return; 
			}

			System.out.println("\nEnter number of ladders (max = 15, min = 5)... -1 to exit");
			ladders = sc.nextInt();

			if (ladders == -1) { 
				System.out.println("\n Exited ... Bye");
				return; 
			}

			System.out.println("\nEnter number of players (max = 9, min = 2)... -1 to exit");
			players = sc.nextInt();

			if (players == -1) { 
				System.out.println("\n Exited ... Bye");
				return; 
			}

			if (snakes <= 15 && snakes >= 5 && ladders <= 15 && ladders >= 5 && players <= 9 && players >= 2) {
				validInput = true;
			}
			if (!validInput) {
				System.out.println("\n Invalid Input... retry");

			}
		}

		sc.close();

		Game game = new Game(100, snakes, ladders);
		
		GameSetupService gameSetupService = new GameSetupService();
		gameSetupService.setupGame(game);		

		GameplayService gameplayService = new GameplayService();
		gameplayService.playGame(players, game);
		
		System.out.println("\nSnake N Ladder Game ends");
	}

}