package exercises.dynamicProgramming;

/**
 * Fibonacci sequence with a twist. The nth element is the result of the sum of the last three numbers in the sequence 
 * assuming that:
 * 
 * if n = 0 => 0
 * if n = 1 => 1
 * if n = 2 => 1
 * 
 * Solve it with dynamic programming
 * */
public class Tribonacci {
	public int tribonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;

		n++;
		int[] memo = new int[n];

		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;

		for (int i = 3; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
		}

		return memo[n - 1];
	}
}
