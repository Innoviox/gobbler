package game.model;

public class Board {
	private Square[][] board;
	
	public Board() {
		this(4);
	}
	
	public Board(int size) {
		this.board = new Square[4][4];
		
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				this.board[y][x] = new Square(x, y);
			}
		}
	}
}
