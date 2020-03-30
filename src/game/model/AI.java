package game.model;

import game.model.util.Color;

public class AI extends Player {
	private int max_depth = 3;
	
	public AI(Color color) {
		super(color);
	}
	
	public AI(Color color, int max_depth) {
		super(color);
		
		this.max_depth = max_depth;
	}

	public void doMove(Game game) {
		
	}

	private int minimax(int depth, int nodeIndex, boolean isMax, Game game, int last_score) { 
	    // Terminating condition. i.e leaf node is reached 
	    if (depth == max_depth) return last_score;
	  
	    // If current move is maximizer, find the maximum attainable 
	    // value 
	    if (isMax) {
	    	
	    }
	    return Math.max(minimax(depth+1, nodeIndex*2, false, scores, h), 
	            minimax(depth+1, nodeIndex*2 + 1, false, scores, h)); 
	  
	    // Else (If current move is Minimizer), find the minimum 
	    // attainable value 
	    else
	        return Math.min(minimax(depth+1, nodeIndex*2, true, scores, h), 
	            minimax(depth+1, nodeIndex*2 + 1, true, scores, h)); 
	} 
}
