package service;

import model.Game;
import model.GameCell;

public class GameSetupService {

	public void setupGame(Game game) {
		System.out.println("Game setup started");

		GameCell[] cells = game.getGameCells();

		//create cells
		for (int i = 0; i < cells.length; i++) {
			GameCell cell = new GameCell(i);
			cells[i] = cell;
		}

		int min;
		int max;
		int range;

		//setting snakes
		int snakeCount = 0;
		while (snakeCount < game.getSnakeCount()) {
			min = 10; //snake not present in the lowest row
			max = 98; //snake not allowed in last cell
			range = max - min + 1;
			int randCellIndex = (int)(Math.random() * range) + min;
			if (cells[randCellIndex].hasSnakeOrLadder()) {
				continue;
			}
			
			min = 0;
			max = randCellIndex - (randCellIndex % 10) - 1;
			range = max - min + 1;
			int randSnakeIndex = (int)(Math.random() * range) + min;
			if (cells[randSnakeIndex].hasSnakeOrLadder()) {
				continue;
			}

			cells[randCellIndex].setSnakeLadder(null, randSnakeIndex);
			snakeCount++;
		}

		//setting ladders
		int ladderCount = 0;
		while (ladderCount < game.getLadderCount()) {
			min = 1; //ladder not allowed in first cell
			max = 89; //ladder not present in cells connecting in topmost row
			range = max - min + 1;
			int randCellIndex = (int)(Math.random() * range) + min;
			if (cells[randCellIndex].hasSnakeOrLadder()) {
				continue;
			}
			
			min = (randCellIndex + 10) - (randCellIndex + 10) % 10; //immediate next row's start index
			max = 98;
			range = max - min + 1;
			int randLadderIndex = (int)(Math.random() * range) + min;
			if (cells[randLadderIndex].hasSnakeOrLadder()) {
				continue;
			}

			cells[randCellIndex].setSnakeLadder(randLadderIndex, null);
			ladderCount++;
		}
		printGame(cells);

		System.out.println("Game setup completed");
	}



	private void printGame(GameCell[] cells) {
		System.out.println("\nPrinting Game");
		System.out.println("ID\tSnake\tLadder\n-------------------------------");
		for (int i = 0; i < cells.length; i++) {
			cells[i].printGameCell();
		}
		System.out.println("----------------------------\nGame printed\n");
	}

}