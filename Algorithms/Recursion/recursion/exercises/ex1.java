package recursion.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Triple Set: A child is running up a staircase with n steps and can hop either 1 steps, 2 steps, or 3 steps at a time. 
 * Implement a method to count how many possible ways a child can run up the stairs
 * 
 * APPROACH (I)
 * So this is actually a combinatory problem, when we need to get the total number of stairs the child has to climb (n) 
 * as the summatory using just the combination of the different steps {1,2,3}. The most direct and straightforward way 
 * to tackle this, is by using backtracking.
 * 
 * 
 * APPROACH (II) - Dynamic Programming
 * Nevertheless the previous approach is not really efficient, mainly, due to the fact that it's recursive. 
 * In addition , the algorithm is evaluating cases for which already got an answer before. A way to cut this off, 
 * is storing the new values as they are calculated (memoization).
 * 
 * */
public class ex1 {
	public int climbStaircase(int n, int steps[]) {
		int count = 0;
		climbStaircase(n, steps, 0, count);
		
		return count;
		
	}
	
	/**
	 * Returns the number of different possible ways to climb n staircases combining different hops.
	 * It uses the BACKTRACKING approach. 
	 * @param n		 int
	 * @param steps	 int[]
	 * @param count  int 
	 * @return int
	 * */
	private void climbStaircase(int n, int steps[], int pos,  int count) {
		if(n == 0) {
			count ++;
		}
		
		for(int i= 0; i < steps.length; i++) {
			climbStaircase(n-steps[i], steps, i, count);
		}
	}
	
	/**
	 * Returns the number of different possible ways to climb n staircases combining different hops
	 * It uses the DYNAMIC PROGRAMMING approach. 
	 * */
	public int climbStaircaseDP(int n, int steps[], int memo[]) {
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;
			
		
			//memo[i] = memo[i-1] + memo[i-2] + memo[i-3];

		for(int i =3;  i<n; i++) {
			for(int j =3;  j<steps.length; j++) //This is: memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
				memo[i] = memo[i-j];
		}
		
		return memo[n-1];
	}
}
