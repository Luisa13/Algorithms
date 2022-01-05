package moderate.exercises;

import java.util.Arrays;

/**
 * Sub Sorting Given an array of integers, write a method fo find indices m and
 * n such that if you sorted elements m through n, the entire array would be
 * sorted. Minimize n - m (that is, find the smallest such sequence).
 * 
 * APPROACH:
 * 1. Have two pointers at the opposite extremes of the array.
 * 
 * 2. Move forwards/ backwards respectively as long as:
 * 		right => arr[right] > arr[right - 1]
 * 		left =>  arr[left] > arr[left + 1]
 * 		left < right
 * 3. What we got, is the unsorted resulting array segment, and we just minimized
 * that sub-array, but still we can find a number in there where might fit somewhere
 * in the supposedly sorted extremes, so it's not the optimal solution. Then, we 
 * have to get the min and the max out of that unsorted array.
 * 
 * 4. For the min, find the place in the left segment where it fits. And do exactly the
 * same for the max and the right one. 
 * 
 * @author luisa
 */
public class ex16 {

	private static final boolean MAX = false;
	private static final boolean MIN = true;

	/**
	 * Get a minimum range [pos1, pos2] of an unsorted sub array.
	 * @param int[]
	 * @param int[]
	 * */
	public static int[] getSubSortRange(int[] arr) {
		if (arr.length <= 0)
			return new int[] { -1, -1 };

		int left = 0;
		int right = arr.length - 1;

		while ((left < right) && (arr[left] < arr[left + 1]) && (arr[right] > arr[right - 1])) {
			left++;
			right--;
		}

		int min = getMinMax(arr, left, right, MIN);
		int max = getMinMax(arr, left, right, MAX);

		int n = whereItFits(arr, 0, left, min);
		int m = whereItFits(arr, right, arr.length - 1, max);

		return new int[] { n, m };
	}

	/**
	 * Given an array and their respective start and end positions, get the max or the min
	 * element as is specified in the parameters
	 * @param int[]
	 * @param int
	 * @param int
	 * @param boolean
	 * 
	 * @return int
	 * */
	private static int getMinMax(int[] arr, int start, int end, final boolean MIN) {
		int[] array = Arrays.copyOfRange(arr, start, end + 1);
		Arrays.sort(array);

		if (MIN)
			return array[0];

		else
			return array[array.length - 1];
	}

	/**
	 * Returns a position where a target fits in the sub array given their certain extremes.
	 * @param int []
	 * @param int
	 * @param int
	 * @param int
	 * 
	 * @return int
	 * */
	private static int whereItFits(int[] arr, int start, int end, int target) {

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (target > arr[mid] && target < arr[mid + 1])
				return mid + 1;

			if (arr[mid] < target)
				start = mid;
			else
				end = mid;
		}

		return -1;

	}

	public static void main(String[] args) {
		int[] arrayTest = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		int[] range = getSubSortRange(arrayTest);

		System.out.print(range[0] + ", " + range[1]);

	}

}
