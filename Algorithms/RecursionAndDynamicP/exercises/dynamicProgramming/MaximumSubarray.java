package exercises.dynamicProgramming;


/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the 
 * largest sum and return its sum. A subarray is a contiguous part of an array.
 * 
 * Example:
 * [-2,1,-3,4,-1,2,1,-5,4], 
 * the largest sum of a subarray is 6 -> [4,-1,2,1]
 * 
 * */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int[] memo = new int[nums.length -1];
        memo[0] = Math.max(nums[0] + nums[1], nums[1]);
        
        int max = Math.max(nums[0] + nums[1], Math.max(nums[0], nums[1]));
        
        for(int i = 2; i<nums.length; i++){
            memo[i-1] = Math.max(nums[i], nums[i] + memo[i-2]);
            max = Math.max(max, memo[i-1]);
            
        }
        
        
        return max;
    }
}
