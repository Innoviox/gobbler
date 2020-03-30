package game.model;

import game.model.util.Color;

public class Tile {
	private int size;
	private Color color;
	
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
}
