package game.model;

import java.util.List;
import java.util.ArrayList;

import game.model.util.Color;
import game.model.util.Move;

public class Game {
	private Board board;
	private Player[] players;
	private int currentPlayer = 0;
	
	public Game() {
		this.board = new Board();
		this.players = new Player[] {new Player(Color.WHITE), new Player(Color.BLACK)};
	}
	
	public void takeTurn() {
		Player p = this.getCurrentPlayer();
		System.out.println(board);
		System.out.println("Taking turn for: " + p.getName());
		
		nextPlayer();
	}
	
	public Player getCurrentPlayer() {
		return players[currentPlayer];
	}
	
	public Player getPlayer(Color c) {
		return players[c == Color.WHITE ? 0 : 1];
	}
	
	public void nextPlayer() {
		currentPlayer = (currentPlayer + 1) % 2;
	}
	
	public List<Move> possibleMoves(Color c) {
		ArrayList<Move> moves = new ArrayList<>();
		
		int size = board.getSize();
		for (int i: getPlayer(c).getAvailable()) {
			for (int x = 0; x < )
		}
		
		return moves;
	}
	
	public void doMove(Move m) {
		
	}
	
	public Game step(Move m) {
		
	}
	
	public int evaluate(Color c) {
		
	}
}
