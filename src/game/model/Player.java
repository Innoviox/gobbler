package game.model;

import java.util.List;
import java.util.ArrayList;

import game.model.util.Color;

public class Player {
	private List<List<Tile>> stacks;
	protected Color color;
	private String name;
	
	public Player(Color color) {
		this(3, 4, color);
	}
	
	public Player(int nStacks, int stackSize, Color color) {
		this.stacks = new ArrayList<>();
		
		for (int stack = 0; stack < nStacks; stack++) {
			this.stacks.add(new ArrayList<>());
			for (int size = stackSize; size > 0; size--) {
				this.stacks.get(stack).add(new Tile(size, color));
			}
		}
		
		this.color = color;
		this.name = color.toString();
	}
	
	public Tile[] getAvailable() {
		return (Tile[]) stacks.stream()
				.map(stack -> stack.size() == 0 ? 0 : stack.get(0))
				.toArray();
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
}
