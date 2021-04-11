package sortingSearching.exercises;


/**
 * Peaks and valleys
 * 
 * @author luisa
 * */
public class ex11 {

	/**
	 * Sorts an array interspelling the highest numbers and the lowest ones
	 * */
	public int[] peaksAndValleys(int[] arr) {
		return sort(arr, new int[arr.length], 0, arr.length);
	}
	
	/**
	 * Sorts an array
	 * 
	 * @param arr int[]
	 * @param helper int[]
	 * @param low int
	 * @param hight int
	 * */
	private int[] sort(int[] arr, int[] helper, int low, int high) {
		if(low < high) {
			int mid = low + (high + low)/2;
			sort(arr, helper, low, mid);
			sort(arr, helper, mid+1, high);
			return mergePeakAndValley(arr, helper, low, mid, high);
		}
		
		return null;
	}
	
	/**
	 * Merges two sorted array in one of them
	 * 
	 * @param arr int[]
	 * @param helper int[]
	 * @param low int
	 * @param mid int
	 * @param high int
	 * */
	private int[] mergePeakAndValley(int[] arr, int[] helper, int low, int mid, int high) {
		for(int i = low; i< high; i++) 
			helper[i] = arr[i];
		
		int left = low;
		int current = low;
		int right = high;
		
		while(mid > left && mid <= right) {
			// if got a valley
			if(helper[left] < helper[right]) {
				if( isPair(current) ) 
					arr[current] = helper[left];
				
				else {
					arr[current + 1] = helper[left];
					arr[current] = helper[right];
					current --;
				}
			}
			else {
				if( !isPair(current)) 
					arr[current] = helper[high];
				else {
					arr[current  +1] = helper[right];
					current --;
				}
				right ++;
				
			}
			current ++;
		}
		
		for(int i = 0; i<(mid-left); i++) 
			arr[current + i] = helper[left + i];
		
		return arr;
		
	}
	
	/**
	 * Returns true if an index is pair. False otherwise
	 * 
	 * @param index int
	 * */
	private boolean isPair(int index) {
		if(index%2 <= 0)
			return true;
		
		return false;
	}
	
}
