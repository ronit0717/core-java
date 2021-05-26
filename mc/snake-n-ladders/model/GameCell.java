package model;

public class GameCell {
	
	private int id;
	private Integer ladderId;
	private Integer snakeId;

	public GameCell(int id) {
		this.id = id;
	}

	public void setSnakeLadder(Integer ladderId, Integer snakeId) {
		if (id == 99) {
			return;
		}
		if (ladderId != null) {
			this.ladderId = ladderId;
			return;
		}
		this.snakeId = snakeId;
	}

	public boolean hasSnakeOrLadder() {
		if (this.ladderId != null || this.snakeId != null) {
			return true;
		}
		return false;
	}

	public int getNext() {
		if (this.ladderId != null) {
			System.out.print("\tYAY LADDER");
			return this.ladderId;
		} else if (this.snakeId != null) {
			System.out.print("\tOOPS SNAKE");
			return this.snakeId;
		}
		return this.id;
	}

	public void printGameCell() {
		System.out.print(this.id + "\t" + this.snakeId + "\t" + this.ladderId + "\n");
	}

}