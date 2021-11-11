package exercises.dynamicProgramming;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each 
 * element in the array represents your maximum jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 * 
 * APPROACH:
 * This problem actually does not look like a dynamic programming type, but it can be addressed to maximize
 * a certain benefit while traversing across the array. 
 * The  key is to compute how  far we can jump for every index as long as we can move forward (this means, if
 * we can not step into a 0 that prevents from keep going). To control whether there is a 0 we cannot skip, 
 * and therefore  the array cannot be traversed  by jumping, the current position must not overpass the 
 * highest jump.
 * 
 * */
public class JumpGame {

	public boolean canJump(int[] nums) {
	    
        if(nums.length == 1)
            return true;
        
        int pos = 0;
        int highestJump = 0;
        
        while(pos < nums.length && pos <= highestJump){
            highestJump = Math.max(nums[pos] + pos, highestJump);
            pos++;
            
            if(highestJump >= nums.length-1)
                return true;
        }
        
        if(highestJump >= nums.length-1)
            return true;
        
        return false;
    }
}
