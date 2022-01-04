package moderate.exercises;

import java.util.Arrays;

/**
 * Given two arrays of integer, compute the pair of values(one value in each
 * array) with the smallest (non-negative) difference.
 * Example: 
 * input: {1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * output: 3; (11,8)
 * 
 * @author luisa
 */
public class ex6 {

	public static int getMinDifference(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		
		while(i <arr1.length && j < arr2.length) {
			int diff = Math.abs(arr1[i] - arr2[j]);
			if(arr1[i] < arr2[j])
				i++;
			else
				j++;
			
			// Update the minimum
			min = min > diff? diff: min;
		}

		
		return min;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 3, 15, 11, 2};
		int[] b ={23, 127, 235, 19, 8};
		
		int diff = getMinDifference(a, b);
		System.out.println(diff);

	}

}
