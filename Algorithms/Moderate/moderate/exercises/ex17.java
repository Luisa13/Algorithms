package moderate.exercises;

/**
 * Contiguous Sequence You are given an array of integer (both positive and
 * negative). Find the contiguous sequence with the largest sum. Return the sum.
 * FOLLOW UP
 * What if I want to return the sequence as a list (the chosen numbers to make 
 * the final sum)
 * 
 * @author luisa
 */
public class ex17 {

	public static int maxSequence(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int[] memo = new int[arr.length];
		memo[0] = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			memo[i] = Math.max(arr[i], memo[i-1] + arr[i]);
			maxSum = maxSum < memo[i]? memo[i] : maxSum;
		}
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		int[] test = {2, -8, 3, -2, 4, -10};
		
		System.out.println(maxSequence(test));

	}

}
