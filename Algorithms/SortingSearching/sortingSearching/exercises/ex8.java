package sortingSearching.exercises;

import java.util.LinkedList;

/**
 * You have an array with all the numbers from 1 to N, where N is at most 32000. The array may 
 * have duplicate entries and you do no know what N is. With only 4 kilobytes of memory available, 
 * how would you print all duplicate elements in the array.
 * 
 * @author luisa
 * */

public class ex8 {
	
	/**
	 * Prints all the duplicates from a list where the size is unknown
	 * 
	 * @param LinkedList<Integer>
	 * 
	 * */
	public static void printDuplicates(LinkedList<Integer> arr) {
		int size = (int)Math.pow(2, 15);
		boolean duplicates[] = new boolean[size];
		
		for(int n: arr) {
			if( duplicates[n] )
				System.out.print(n);
			
			else
				duplicates[n] = true;
		}
	}

}
