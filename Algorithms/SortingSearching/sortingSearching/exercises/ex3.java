package sortingSearching.exercises;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, 
 * write code to find an element in the array. You may assume that the array was originally 
 * sorted in increasing order.
 * 
 * @author luisa
 * 
 * */
public class ex3 {

	public static int searchRotated(int[] array, int element) {
		return searchRotated(array, 0, array.length-1, element);
	}
	
	private static int searchRotated(int [] array, int left, int right, int element) {
		int half = (left + right) / 2;
		
		if(array[left] > array[right]) { // ---> e.g. [15|16|20|1|5|14]	
			if(element < array[right]) {
				while(element < array[half])
					half ++;
				
				return search(array, half, right, element);
				
			}else if(element > array[right]) {
				while(element > array[half])
					half --;
				
				return search(array, left, half, element);
			}

			/*if(element < array[left]) {
				//if(element > array[half]) {
					while(element > array[half])
						half --;
				//}
				return search(array, left, half-1, element);
			}*/
		}
		

		return search(array, left, right, element);
		

	}
	
	private static int search(int[] array, int left, int right, int element) {
		if(left < right) {
			int half = (left + right)/2;
			if(element == array[half] )
				return half;
			
			if(element> array[half])
				return search (array, half+1, right, element);
			
			else if(element < array[half])
				return search(array, left, half, element);
			
		}
		
		return -1;
		
		
		
	}
}
