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
	
	public String toString() {
		int size = board.length;
		
		StringBuilder s = new StringBuilder();
		s.append("\n   ");
		for (int c = 0; c < size; c++) s.append((c + 1) + " ");
		s.append("\n  ┌" + "─┬".repeat(size - 1) + "─┐\n");
		for (int y = 0; y < size; y++) {
			s.append((y + 1) + " │");
			for (int x = 0; x < size; x++) {
				Tile top = this.board[y][x].getTopTile();
				String top_size = " ";
				if (top != null) {
					top_size = top.toString();
				}
				
				s.append(top_size + "│");
			}
			if (y != size - 1) {
				s.append("\n  ├" + "─┼".repeat(size - 1) + "─┤");
			}
			s.append("\n");
		}
		s.append("  └" + "─┴".repeat(size - 1) + "─┘\n");

		return s.toString();
	}
}
