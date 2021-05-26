package service;

import java.util.Arrays;
import java.lang.Math;
import model.Game;
import model.GameCell;

public class GameplayService {
	
	public void playGame(int playerCount, Game game) {
		System.out.println("Game Play started for "+ playerCount + " players");
		int[] pos = new int[playerCount];
		Arrays.fill(pos, -1);

		Integer winner = null;

		GameCell[] cells = game.getGameCells();

		int player = 3;
		int counter = 0;
		boolean repeat = false;
		while (winner == null && counter <= 1000) {
			player = (++player) % playerCount;
			if (player == 0 && !repeat) {
				System.out.println();
			}
			repeat = false;
			counter++;
			int dice = rollDice();
			System.out.print("\nPlayer " + (player + 1) + " rolled dice... " + dice);

			if (pos[player] == -1 && dice != 1) {
				System.out.print("\t=> No move");
				continue;
			}

			int newPos = pos[player] + dice;
			System.out.print("\t=> Player "+ (player + 1) + " moved to position: " + (newPos + 1));
			if (newPos == 99) {
				winner = player + 1;
				pos[player] = newPos;
				continue;
			} else if (newPos > 99) {
				System.out.print("\t=> No move");
				continue;
			}

			if (cells[newPos].hasSnakeOrLadder()) {
				newPos = cells[newPos].getNext();
				System.out.print("\t=> Player "+ (player + 1) + " moved to position: " + (newPos + 1));
			}
			pos[player] = newPos;

			if (dice == 6) {
				repeat = true;
				player--; //player gets one more chance
			}

		}

		if (winner != null) {
			System.out.println("\n\n****************************\nPlayer " + winner + " is the winner!!!\n*********************************");
		}

		System.out.println("\nGame Play finished for "+ playerCount + " players in " + counter + " counts");

	}

	private int rollDice() {
		return 1 + (int)(Math.random() * 6);
	}

}