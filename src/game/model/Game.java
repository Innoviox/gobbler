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
	
	public int getCurrentPlayerNumber() {
		return currentPlayer;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Board getBoard() {
		return board;
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
		
		List<Tile> sameColor = new ArrayList<>();
		List<Tile> oppColor = new ArrayList<>();
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Square sq = board.squareAt(x, y);
				if (sq.empty())
					for (Tile t: getPlayer(c).getAvailable()) 
						moves.add(new Move(x, y, t));
				else {
					Tile top = sq.getTopTile();
					if (top.getColor() == c) 
						sameColor.add(top);
					else 
						oppColor.add(top);
				}
			}
		}
		
		for (Tile t: sameColor) {
			for (Tile t1: sameColor) 
				if (t1.getSize() < t.getSize()) 
					moves.add(new Move(t1.getX(), t1.getY(), t));
			
			for (Tile t2: oppColor) 
				if (t2.getSize() < t.getSize()) 
					moves.add(new Move(t2.getX(), t2.getY(), t));			
		}
		
		// todo: gobble from space			
		
		return moves;
	}
	
	public void doMove(Move m) {
		Game g = step(m);
		this.board = g.getBoard();
		this.players = g.getPlayers();
		this.currentPlayer = g.getCurrentPlayerNumber();
	}
	
	public Game step(Move m) {
		
	}
	
	public int evaluate(Color c) {
		
	}
}
