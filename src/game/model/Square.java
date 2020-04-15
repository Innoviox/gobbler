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
		return empty() ? null : tiles.get(0);
	}
	
	public void addTile(Tile t) {
		tiles.add(0, t);
		
		t.setX(x);
		t.setY(y);
	}
	
	public boolean empty() {
		return tiles.size() == 0;
	}
}
