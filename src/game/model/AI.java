package game.model;

import game.model.util.Color;
import game.model.util.Move;

public class AI extends Player {
	private int max_depth = 3;
	
	public AI(Color color) {
		super(color);
	}
	
	public AI(Color color, int max_depth) {
		super(color);
		
		this.max_depth = max_depth;
	}
	
    public Move play(Game game) {
        int best_val = Integer.MIN_VALUE;
        Move best_move = null;
        
        for (Move move: game.possibleMoves(color)) {
        	int[] alphaBeta = {Integer.MIN_VALUE, Integer.MAX_VALUE};
            
            Game nextState = game.step(move);
            
//            if state != nil {
//                let w = state?.winner().0
//                if w == color {
//                    return move
//                }
            	int value = minimax(0, nextState, false, alphaBeta);
//                let value = minimax(depth: 0, state: state!, maximizing: false, alpha: &alpha, beta: &beta)
                if (value >= best_val) {
                    best_val = value;
                    best_move = move;
                }
//            }
        }
        return best_move;
    }
    
    public int minimax(int depth, Game state, boolean maximizing, int[] alphaBeta) {
        if (depth >= max_depth) {
            return state.evaluate(color);
        }
        
        if (maximizing) {
            int best = Integer.MIN_VALUE;
            for (Move m: state.possibleMoves(color)) {
                best = Math.max(best, minimax(depth + 1, state.step(m), false, alphaBeta));
                alphaBeta[0] = Math.max(alphaBeta[0], best);
                if (alphaBeta[0] >= alphaBeta[1]) return best; 
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (Move m: state.possibleMoves(color)) {
            	best = Math.min(best, minimax(depth + 1, state.step(m), true, alphaBeta));
                alphaBeta[1] = Math.min(alphaBeta[1], best);
                if (alphaBeta[1] <= alphaBeta[0]) return best;
            }
            return best;
        }
    }
}
