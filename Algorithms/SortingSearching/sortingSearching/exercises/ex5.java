package sortingSearching.exercises;


/**
 * Given a sorted array of strings that is interspersed with empty strings, 
 * write a method to find the location of a given string.
 * 
 * APPROACH:
 * The approach is to use a classic binary search and in the case you got an 
 * empty string in the mid position, look for the closest not-empty-string either 
 * moving forward or backward. 
 * E.g:
 * In the array: arr = {"asd", "", "", "", "baff", ""} where my mid position is 3, we got arr[3] = ""
 * Then, we could see in arr[0]= "asd" and in arr[4] = baff, so the non empty string position to 3, is 4.
 * 
 * @author luisa
 * */
public class ex5 {
	
	/**
	 * Look for a string into an array interspersed with empty strings
	 * 
	 * @param String[] 	Array with all the elements
	 * @param String	Element to be found
	 * @return int 		Position in the array of the element. -1 in case was not found.	
	 * */
	public static int sparseSearch(String [] arr, String x) {
		return sparseSearch(arr, 0, arr.length, x);
	}
	
	private static int sparseSearch(String[] arr, int min, int max, String x) {
		if(max >= min) {
			int mid = min + (max-min)/2;
			
			// Before starting to compare, we need to get a non-empty-string position
			if(arr[mid] == "") {
				mid = closerToNotEmpty(arr, mid);
				if(mid < min || mid < 0)
					return -1;
			}
			
			if(arr[mid] == x)
				return mid;
			if( x.compareTo(arr[mid]) > 0)
				return sparseSearch(arr, mid+1, max, x);
			if(x.compareTo(arr[mid]) < 0)
				return sparseSearch(arr, min, mid-1, x);
		}
		
		return -1;
	}
	
	
	/**
	 * Returns the position closer to a non empty string either moving forward or backward.
	 * 
	 * @param String[] 	Array with all the elements
	 * @param int 		Element to be found
	 * @return int 		Position of the element. -1 in case could no be found.
	 * 
	 * */
	private static int closerToNotEmpty(String [] arr, int position) {
		int left = position -1;
		int right = position +1;
		
		while(left >= 0 && right <= arr.length) {
			if(left >= 0 && arr[left] != "")
				return left;
			if(right <= arr.length && arr[right] != "")
				return right;
			
			right ++;
			left --;
			
		}
		
		return -1;
	}

}
