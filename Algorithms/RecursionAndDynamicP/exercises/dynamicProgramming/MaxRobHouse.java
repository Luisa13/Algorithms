package exercises.dynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * This is a medium level problem.
 * 
 * OBSERVATIONS
 * *The optimal solution may not always consist of robbing the closest packing 
 *  of houses we can find. We may want to skip over MORE than one house.
 * 
 * *What is the max distance (and its corresponding profit) between two houses
 *  that we can steal from?
 * 
 * APPROACH:
 * Aggregates the current benefit to the farthest house (memo[i - 2] + nums[i])
 * because is the option where we are sacrificing some gold in between. On the
 * contrary, if we take the closest option, there are more chances later to 
 * increment out profit.
 */
public class MaxRobHouse {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (n <= 0)
			return 0;

		int[] memo = new int[n];
		memo[0] = nums[0];
		memo[1] = Math.max(nums[1], nums[0]);

		for (int i = 2; i < n; i++) {
			memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
		}

		return Math.max(memo[n - 1], memo[n - 2]);
	}
}
