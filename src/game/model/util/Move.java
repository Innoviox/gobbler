package game.model.util;

import game.model.Tile;

public class Move {
	private int x;
	private int y;
	
	private Tile t;
		
	public Move(int x, int y, Tile t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}
