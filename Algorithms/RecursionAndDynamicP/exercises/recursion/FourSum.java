package exercises.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] 
 * such as: Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]].
 * The result may be returned in any order.
 * 
 * Example:
 * 
 * 		Input: nums = [1,0,-1,0,-2,2], target = 0
 * 		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * */
public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        allSums(nums, target, 0, 0, new ArrayList<Integer>(), result);
        
        List<List<Integer>> lists = new ArrayList<>();
        result.stream().forEach(l -> lists.add(l));
        
        return lists;
    }
    
    public void allSums(int[] nums, int target, int sum, int pos, List<Integer> options, Set<List<Integer>> quadruplets){
        if(options.size() > 4)
            return;
            
        else if(options.size() == 4 && sum == target){
            quadruplets.add(new ArrayList<Integer>(options
                                                   .stream()
                                                   .sorted()
                                                   .collect(Collectors.toList()) 
                                                  ));
        }
        
        for(int i =pos; i< nums.length; i++){
                options.add(nums[i]);
                allSums(nums, target, sum + nums[i], i+1, options, quadruplets);
                options.remove(options.size() -1);
        }
        
        
        
    }
}
