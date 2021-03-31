package sortingSearching.exercises;


/**
 * Given an M x N matrix in which each row and each column is sorted in ascending order, write a 
 * method to find an element.
 * 
 * @author luisa
 * */
public class ex9 {
	
	static final int N = 3;
	static final int M =3;
	
	public static void searchSortedMatrix(int[][] m, int M, int N, int element) {
		if(M <=0 || N <= 0) {
			System.out.println("ERROR: The matrix dimensions are not correct");
			return;
		}
		
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
		return getClosestPosition(m, 0, m.length, m.length, element);
	}
	
	/**
	 * 
	 * */
	private static int getClosestPosition(int[][]m, int left, int right, int previous, int element) {
		
		if(m[right][N] > m[previous][N]) {
			
			int mid = left + (right-left)/2;
			
			// We'll update previous just when the current item is SMALLER but at the 
			// same time that item is LARGER than the key element. 
			// So we can make sure we are keeping the smaller value out of all the larger than the element
			
			if(m[previous][N] < m[mid][N] && m[mid][N]> element)
				previous = mid;
			
			if(m[mid][N] > element)
				getClosestPosition(m, left, mid-1, previous, element);
			
			if(m[mid][N] < element)
				getClosestPosition(m, mid+1, right, previous, element);
		}
		return -1;
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
		return searchElement(arr, 0, arr.length, element);
	}
	
	/**
	 * Classic binary search in an integer array
	 * */
	private static int searchElement(int[] arr, int left, int right, int element) {
		if(right >= left) {
			int mid = left + (right-left)/2;
			if(arr[mid] == element)
				return mid;
			
			if(arr[mid] > element)
				return searchElement(arr, left, mid-1, element);
			
			if(arr[mid] < element)
				return searchElement(arr, mid+1, right, element);
		} 
		return -1;
	}

}
