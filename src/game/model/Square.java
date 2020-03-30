package game.model;

import java.util.List;
import java.util.ArrayList;

public class Square {
	private int x;
	private int y;
	
	private List<Tile> tiles;
	
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.tiles = new ArrayList<>();
	}
	
	public Tile getTopTile() {
		if (this.tiles.size() == 0) {
			return null;
		}
		return this.tiles.get(0);
	}
}
