package recursion.dynamicProgramming;


/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you 
 * can rob tonight without alerting the police.
 * 
 * APPROACH:
 * if the array is: [2, 0, 3, 5, 6, 4]
 * let's compare the result of: 
 * * [0, 3, 5, 6, 4]     &     [2, 2, 3, 5, 6]
 * */
public class CycleRobHouse {

	public int rob(int[] nums) {
        int n = nums.length;
        // Base cases:
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];
        
        if(n ==2)
            return Math.max(nums[0], nums[1]);
        
        //System.out.println( robInSegment(nums, 0, n-1) + " and " + robInSegment(nums, 1, n));
        
        return Math.max(
            robInSegment(nums, 0, n-1),
            robInSegment(nums, 1, n)
        );
        
    }
    
    private int robInSegment(int[] nums, int start, int end){
        int[] memo = new int[end];
        memo[0] = nums[start];
        memo[1] = Math.max(nums[start], nums[start+1]); 
        //System.out.println("Memo init: " + memo[0]  + " and "  + memo[1]);
        for(int i = start + 2; i<end; i++){
            //System.out.println("Im at i: " + i);
            //System.out.println("Check: " + memo[(i-1)] + " y (" + memo[(i-2)] + " + "+ nums[ i] + ")");
            int index = i-start;
            memo[index] = Math.max(memo[(index-1)], memo[(index-2)] + nums[i]); 
            //System.out.println("Sum: " + memo[index] + " at index -> " + i);
        }
        
        
        return Math.max(memo[end-1], memo[end-2]);
    }
}
