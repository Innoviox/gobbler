package game.model.util;

public enum Color {
	BLACK, WHITE;
	
	public Color flip() {
		switch (this) {
		case WHITE: return BLACK;
		case BLACK: return WHITE;
		default: return null; // should never be reached
		}
	}
}
