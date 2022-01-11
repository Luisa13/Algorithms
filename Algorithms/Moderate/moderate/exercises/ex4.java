package moderate.exercises;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Tic Tac Win
 * Design an algorithm to figure out if someone has won a game of tic tac toe.
 * 
 * APPROACH 1
 * We have to check the result for both players which in a naive approach would
 * could address the issue by traversing the whole array, row by row and column 
 * by column, getting a counter for both sort of marks. However, this is not an 
 * optimal solution if we have a big board (like 100 x 100).
 * So we can start having a method that check the result for one given player that
 * has been set up before. 
 * 
 * 1. Traverse the board by row.
 * 
 * 2. As soon as we come across a wrong piece, jump off to the next row.
 * 
 * 	2.1. Before to do that, store the column we know it's not interesting in order 
 * 		 to don't explore again, and at the same time, the columns would be potentially
 * 		 interesting (and did not explore so far).
 * 
 * 3. Traverse the columns we store as interesting.
 * 
 * 4. In case we have to, traverse the diagonal. 
 * 
 * 
 * @author luisa
 * */
public class ex4 {

	enum Player{
		CIRCLE(true) ,
		CROSS(false);
		
		public final boolean piece;
		
		Player(boolean piece) {
			this.piece = piece;
		}
	}
	
	/**
	 * Represents the game for tic tac toe
	 * 
	 * */
	public static class TicTacToe {
		
		private boolean[][] board;
		private int size = 0;
		private Player player;
		
		public TicTacToe(boolean[][] board) {
			if(board.length != board[0].length) {
				System.out.println("ERROR: The size should be square.");
				return;
			}
			
			this.board = board;
			this.size = board.length;
		}
		
		/**
		 * Check the result for a specific player
		 * @return boolean
		 * */
		public boolean isPlayerWinner() {
			int row = 0;
			int col = 0;
			int count = 0;
			boolean diagonal = true;
			Set<Integer> drawed = new HashSet<>();
			Queue<Integer> q = new LinkedList<Integer>();
			
			
			while(row < this.size && count< this.size) {
				col = 0;
				count = 0;
				// Traverse the row as long as find the player pieces
				while(col < this.size && validPiece(this.board[row][col])) {
					col++;
					count ++;
					if(col == row)
						diagonal = true;
				}
				if(count == this.size)
					return false;
				
				// Store the columns it didn't explore and might be interesting
				drawed.add(col);
				int c = col +1;
				while(c < this.size && !drawed.contains(c)) {
					q.add(c);
					c++;
				}
				
				row++;
			}
			
			//Explore now the promising columns
			while(!q.isEmpty()) {
				row = 0;
				col = q.poll();
				count = 0;
				while(row < this.size && validPiece(this.board[row][col])) {
					count ++;
					row ++;
					if (count == this.size)
						return true;
				}
			}
			
			// Explore the diagonal if not ruled out
			if(diagonal) {
				row = 0;
				col = 0;
				count = 0;
				while(row < this.size && col < this.size && validPiece(this.board[row][col])) {
					count ++;
					row ++;
					col ++;
				}
				if (count == this.size)
					return true;
			}
			
			return false;
		}
		
		private boolean validPiece(boolean piece){
			if(!player.piece)
				return !piece;
			
			return piece;
		}
		
		/**
		 * Prints out the result for the specified player
		 * @param player;
		 * 
		 * */
		public void result(Player player) {
			this.player = player;
			
			if(this.isPlayerWinner())
				System.out.println("The player won!");
			
			else
				System.out.println("Miss...");
		}
		
		
	}
	
	public static void main(String[] args) {
	
		boolean[][] setup = {{false, true, true, true}, {false, true, false, true}, {true, false, false, true}, {true, false, false, true, true}};
			//{{true, false, false}, {false, true, false}, {false, true, true}}; // diagonal
			//{{true, false, false}, {false, true, true}, {true, false, true}}; // lost
		TicTacToe game = new TicTacToe(setup);
		
		game.result(Player.CROSS);
	}

}
