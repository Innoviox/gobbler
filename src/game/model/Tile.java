package game.model;

import game.model.util.Color;

public class Tile {
	private int size;
	private Color color;
	
	private int x = -1;
	private int y = -1;
	
	public Tile(int size, Color color) {
		this.size = size;
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		switch (color) {
		case WHITE: return "W" + size; // return Character.toString(10111 + size);
		case BLACK: return "B" + size; // return Character.toString(10121 + size);
		default: return null;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
