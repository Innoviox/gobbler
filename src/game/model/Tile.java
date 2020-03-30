package game.model;

import game.model.util.Color;

public class Tile {
	private int size;
	private Color color;
	
	public Tile(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		switch (color) {
		case WHITE: return Character.toString(10112 + size);
		case BLACK: return Character.toString(10122 + size);
		default: return null;
		}
	}
}
