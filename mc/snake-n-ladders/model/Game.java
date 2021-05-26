package model;

import model.GameCell;
import java.lang.Math;
import java.util.Arrays;

public class Game {
	
	private GameCell[] cells;
	private int snakes;
	private int ladders;

	public Game(int cellCount, int snakeCount, int ladderCount) {
		cells = new GameCell[cellCount];
		snakes = snakeCount;
		ladders = ladderCount;
	}

	public GameCell[] getGameCells() {
		return cells;
	}

	public int getSnakeCount() {
		return snakes;
	}

	public int getLadderCount() {
		return ladders;
	}

}