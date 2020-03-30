package game.model;

import java.util.List;
import java.util.ArrayList;

public class Player {
	private List<List<Tile>> stacks;
	
	public Player() {
		this(3, 4);
	}
	
	public Player(int n_stacks, int stack_size) {
		this.stacks = new ArrayList<>();
		
		for (int stack = 0; stack < n_stacks; stack++) {
			this.stacks.add(new ArrayList<>());
			for (int size = stack_size; size > 0; size--) {
				this.stacks.get(stack).add(new Tile(size));
			}
		}
	}
}
