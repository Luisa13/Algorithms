package recursion.dynamicProgramming;


/**
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following 
 * operation any number of times:
 *  1) Pick any nums[i] and delete it to earn nums[i] points. 
 *  2) Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 *  3) Return the maximum number of points you can earn by applying the above operation some number of times.
 *  
 * */
public class DeleteAndEarn {
	
	public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n ==2)
            return Math.max(nums[0], nums[1]);
        
        int[] memo = new int[n];
        memo[0] = nums[0];    
        int lastMax = 0;
        
        for(int i =1; i<n ; i++){
            memo[i] = 0;
            int prev = memo[i-1];
            //System.out.println("Total sum: " + memo[i-1]);
            if(notAllowed(nums[i], nums[i-1])){
                //System.out.println (nums[i] + " is incompatible with " + nums[i-1] + ". So I change");
                memo[i] = lastMax;
                lastMax = memo[i-1];
                prev = 0;
            }
            
            memo[i] += nums[i] + prev;
        }
        
        
        return Math.max(memo[n-1], lastMax);
    }
    
    
    private boolean notAllowed(int current, int prev){
        return (current-1 == prev) || (current+1 == prev);
    }
}
