package game.model;

import game.model.util.Color;

public class Board {
	private Square[][] board;
	private Player[] players;
	
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
		
		this.players = new Player[] {new Player(Color.WHITE), new Player(Color.BLACK)};
	}
	
	public String toString() {
		int size = board.length;
		
		StringBuilder s = new StringBuilder();
		s.append("┌" + "─┬".repeat(size - 1) + "─┐\n");
		for (int y = 0; y < size; y++) {
			s.append("│");
			for (int x = 0; x < size; x++) {
				Tile top = this.board[y][x].getTopTile();
				int top_size = 0;
				if (top != null) {
					top_size = top.getSize();
				}
				
				s.append(top_size + "│");
			}
			if (y != size - 1) {
				s.append("\n├" + "─┼".repeat(size - 1) + "─┤");
			}
			s.append("\n");
		}
		s.append("└" + "─┴".repeat(size - 1) + "─┘");
		
		return s.toString();
	}
}
