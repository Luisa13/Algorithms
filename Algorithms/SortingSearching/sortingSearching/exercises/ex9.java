package sortingSearching.exercises;


/**
 * Given an M x N matrix in which each row and each column is sorted in ascending order, write a 
 * method to find an element.
 * 
 * @author luisa
 * */
public class ex9 {
	
	public static void searchSortedMatrix(int[][] m, int M, int N, int element) {
		if(M <=0 || N <= 0)
			return null;
		
		int row = getRowPosition(m, element);
		int col = N;
		if(m[row][N] != element)
			col = searchElement(m[row], element);
		
		if(col > 0)
			System.out.println("Element found at" + row + ", " + col);
		
		else
			System.out.println("The element could not be found");
		
	}
	
	/**
	 * Gets the row index where the closest larger value in comparison with the element is
	 * 
	 * @param int[][]
	 * @param int
	 * @return int
	 * */
	private static int getRowPosition(int[][] m, int element) {
		
	}
	
	
	/**
	 * Returns the position at the array where the given element is. In case it 
	 * could not be found, returns -1.
	 * 
	 * @param int[][]
	 * @param int
	 * @return int
	 * */
	private static int searchElement(int[] arr, int element) {
		
	}

}
