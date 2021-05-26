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

		int winnerCount = 0;
		int[] winners = new int[playerCount];

		GameCell[] cells = game.getGameCells();

		int player = playerCount - 1;
		int counter = 0;
		boolean repeat = false;
		while ((winnerCount < (playerCount - 1)) && counter <= 1000) {
			player = (++player) % playerCount;
			if (player == 0 && !repeat) {
				System.out.println();
			}
			repeat = false;
			counter++;
			
			if (pos[player] == 99) { //player already won
				continue;
			}			

			int dice = rollDice();
			System.out.print("\nPlayer " + (player + 1) + " rolled dice... " + dice);

			if (pos[player] == -1 && dice != 1) {
				System.out.print("\t=> No move");
				continue;
			}

			int newPos = pos[player] + dice;
			System.out.print("\t=> Player "+ (player + 1) + " moved to position: " + (newPos + 1));
			if (newPos == 99) {
				winners[winnerCount] = player + 1;
				pos[player] = newPos;
				winnerCount++;
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

		setLooser(winners, playerCount);
		winnerCount++;

		if (winnerCount == playerCount) {
			System.out.println("\n******************************************");

			for (int i = 1; i <= winnerCount; i++) {
				if (i == winnerCount) {
					System.out.println("Looser   =>\tPlayer "+winners[i-1]);
					break;
				}
				System.out.println("Winner "+i + " =>\tPlayer "+winners[i-1]);
			}

			System.out.println("******************************************\n");
		}

		System.out.println("\nGame Play finished for "+ playerCount + " players in " + counter + " counts");

	}

	private void setLooser(int[] winners, int playerCount) {
		int totalSum = (playerCount * (playerCount + 1)) / 2;
		int i = 0;
		for (i = 0; i < playerCount - 1; i++) {
			totalSum -= winners[i];
		}
		winners[i] = totalSum;
	}

	private int rollDice() {
		return 1 + (int)(Math.random() * 6);
	}

}