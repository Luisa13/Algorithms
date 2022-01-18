package moderate.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Pond Sizes
 * You have an integer matrix representing a plot of land, where the
 * value at that location represents the height above sea level. A value of zero
 * indicates water. A pond is a region of water connected vertically,
 * horizontally, or diagonally. The size of the pond is the total number of
 * connected water cells. Write a method to compute the sizes of all ponds in
 * the matrix.
 * 
 * APPROACH
 * First we need to realize that all the connected water pounds (important data we 
 * want to notice), might be represented as graphs, since every cell is related to 
 * other cells around it.
 * 
 * We need to traverse those blocks once we know where they are in order to count 
 * the number of cells that form it. To do so, we can apply DFS as it exhaust all 
 * possibilities around it.
 * 
 * So, wrapping it up, let's traverse the matrix and then when we detect a target
 * value (aka 0 here), we can use DFS to traverse that block of 0s.
 * 
 * Two things to remark here: 
 * 1) The obvious need to have a data structure to track all the visited nodes. 
 * Since the code is divided in different methods and both iterate over the board,
 * we have to share the very same structure. 
 * 2) Highlight the fact we are interested in the individual blocks of 0s, that is
 * counting the 0s up as long as they are together. We can actually traverse the 
 * matrix by doing DFS (or BFS for the matter) starting for any position and we will
 * end up traversing the whole matrix. We don't want that. We want to do DFS as long
 * as we detect a 0, and when there is no more 0 AROUND (no more adjacent 0), then 
 * stop DFS. So we need to limit that iteration by meeting a condition: 
 * If the children of the current node are not the target value (0), then not stack 
 * them up.
 * 
 * 
 * # Graphs #DFS #BFS
 * 
 * @author luisa
 */
public class ex19 {
	
	private final static Set<Cell> visited = new HashSet<>();
	
	public static class Cell{
		private final static int BOARD_ROW_MAX = 4;
		private final static int BOARD_COL_MAX = 4;
		
		Integer x;
		Integer y;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		private boolean isRowValid() {
			return this.x >=0 && this.x < BOARD_ROW_MAX;
		}
		
		private boolean isColValid() {
			return this.y >=0 && this.y < BOARD_COL_MAX;
		}
		
		public boolean isOffLimit() {
			return !isRowValid() || !isColValid();
		}
		
		public List<Cell> getChildren(){
			List<Cell> children = new ArrayList<>();
			
			// Up
			children.add(new Cell(this.x, this.y+1));
			// Down
			children.add(new Cell(this.x, this.y-1));
			// Left
			children.add(new Cell(this.x-1, this.y));
			//Right
			children.add(new Cell(this.x+1, this.y));
			
			return children;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null)
				return false;
			
			if(obj == this)
				return true;
			
			Cell cell = (Cell)obj;
			return cell.x.equals(this.x) &&
					cell.y.equals(this.y);
		}
		
		@Override
		public int hashCode() {
			int result = 11;
			
			if(this.x != null)
				result  = 31 * result + this.x.hashCode();
			if(this.y != null)
				result = 31 * result + this.y.hashCode();
			
			return result;
		}
		
		@Override
		public String toString() {
			return "(" + this.x + ", " +this.y + ")";
		}
	}

	/**
	 * Return a list with the water pound sizes (defined by the 0 value) that a board contains. 
	 * @param int[][]
	 * @param target
	 * */
	public static List<Integer> pondSizes(int[][] board, int target){
		List<Integer> solution = new ArrayList<>();
		
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col <board[row].length; col++) {
				if(board[row][col] == target) {
					int count = getPoundSizeDFS(board, row, col, target);
					if(count > 0 )
						solution.add(count);
				}
			}
		}
		
		return solution;
	}
	
	/**
	 * Traverse using DFS all the adjacent cells to a specific one given by its coordinates (x, y)
	 * and count up all the relevant nodes by comparing them with target
	 * @param in[][]
	 * @param int
	 * @param int
	 * @param int
	 * @return int
	 * */
	public static int getPoundSizeDFS(int[][] board, int row, int col, int target) {
		
		Stack<Cell> stack = new Stack<>();
		stack.add(new Cell(row, col));
		int count = 0;
		
		while(! stack.isEmpty()) {
			Cell current = stack.pop();

			if(isValid(current)) {
				if(board[current.x][current.y] == target)
					count ++;
				
				for(Cell child: current.getChildren()) 
					if(!child.isOffLimit() && board[child.x][child.y] == target)
						stack.add(child);
				
				visited.add(current);
			}
			
		}
		
		return count;	
	} 
	
	/**
	 * Returns true if a cell is valid by checking if its coordinates are off board limits and
	 * if it has been visited before.
	 * @param Cell
	 * @return boolean
	 * */
	public static boolean isValid(Cell cell) {
		if(!cell.isOffLimit() && !visited.contains(cell))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] board = {{0,2,1,1}, {0,1,0,0}, {1,1,0,1}, {0,1,0,1}};
		List<Integer> sizes = pondSizes(board, 0);
		
		System.out.print(sizes);
		
	}

}
