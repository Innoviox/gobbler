package game.model;

import game.model.util.Color;

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
	
	public void nextPlayer() {
		currentPlayer = (currentPlayer + 1) % 2;
	}
}
