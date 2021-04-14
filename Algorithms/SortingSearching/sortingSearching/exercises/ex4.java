package sortingSearching.exercises;

import java.util.List;

import sortingSearching.aditional.Listy;

/**
 * You are given an array like data structure Listy which lacks a size method.
 * It does, however have an elementAt(i) method that return the element at index
 * i in O(1) time. If i is beyond the bounds of the data structure, it returns
 * -1.
 * 
 * Given a Listy which contains sorted, positive integers, find the index at
 * which an element x occurs. If x occurs multiple times, you may return any
 * index.
 * 
 * TODO: Control the jump in case go beyond the limit.
 * 
 * @author luisa
 */
public class ex4 {

	static final int PERC = 30;

	public static int searchNoSize_deprecated(Listy listy, int x) {
		int max = 0;
		int min = 0;
		int i = 0;

		while (listy.elementAt(i) != x && listy.elementAt(i) > 0) {
			while (listy.get(i) > 0 && listy.elementAt(i) < x) {
				i = jump(i, max);
				min = i;
			}
			if (listy.elementAt(i) < 0)
				return -1;

			max = i;
			i = min;
		}
		return i;

	}

	private static int jump(int i, int max) {
		if (max > 0) {
			i += (PERC * max) / 100;
			return i;
		}

		return i * i + 1;
	}
	
	
	//===============================
	// 			IMPROVEMENT
	//===============================

	/**
	 * Search an element x in a {@link Listy} structure 
	 * 
	 * @param Listy List that contains all the elements
	 * @param int Element to be found
	 * */
	public static int searchNoSize(Listy listy, int x) {
		int max = 0;
		int min = 0;
		int i = 0;

		if (listy.elementAt(i) == x)
			return i;

		// Sets a range in the array to use a binary search
		while (listy.elementAt(i) > 0 && listy.elementAt(i) < x) {
			min = i;
			i = jump(i, max);
		}
		while(listy.elementAt(i) < 0)
			i--;
		
		max = i;
		return binarySearch(listy, min, max, x);
	}

	
	/**
	 * Binary search to look an integer into a list
	 * 
	 * @param Listy Data structure that contains all the elements
	 * @param int	Minimal value in the range to look for
	 * @param int	Maximal value in the range to look for
	 * @param int	Element to be found
	 * */
	private static int binarySearch(Listy listy, int min, int max, int x) {

		if (min <= max) {
			int mid = min+  (max-min)/ 2;

			if (listy.elementAt(mid) == x)
				return mid;

			if (listy.elementAt(mid) > x)
				return binarySearch(listy, min, mid - 1, x);
			if (listy.elementAt(mid) < x)
				return binarySearch(listy, mid + 1, max, x);
		}

		return -1;
	}

}
