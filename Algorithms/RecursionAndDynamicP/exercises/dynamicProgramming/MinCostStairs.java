package exercises.dynamicProgramming;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
 * Once you pay the cost, you can either climb one or *TWO* steps. You can either start from the 
 * step with index 0, or the step with index 1. 
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * APPROACH:
 * This is a easy problem for Dynamic Programming. Since we are calculating the min, it's not enough
 * accumulating a calculated sum in every iteration based on the minimum of the next two items in the cost 
 * array. We have to track the *TWO* possibilities in an array (dp[i] = pos1 and dp[i+1] = pos2).
 * 
 * */
public class MinCostStairs {
	public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i =2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            System.out.println("New cost: " + dp[i]);
        }
        
        return Math.min(dp[n-1], dp[n-2]);
    }
}
