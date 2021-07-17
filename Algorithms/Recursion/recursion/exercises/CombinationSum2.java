package recursion.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 * 
 * Example: Input: candidates = [10,1,2,7,6,1,5], target = 8 Output: [[1,1,6],
 * [1,2,5], [1,7], [2,6] ]
 * 
 * @author luisa
 * 
 */
public class CombinationSum2 {

	class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        // The combinations must be unique
	        Set<List<Integer>>combinations = new HashSet<List<Integer>>();
	        combinationTargetSum(candidates, 0, target, 0, new ArrayList<Integer>(), combinations);

	        List<List<Integer>> lists= new ArrayList<>();
	        combinations.stream().forEach(l -> lists.add(l));
	        
	        return lists;
	    }
	    
	    public void combinationTargetSum(int[] candidates, int current, int target, int localSum, List<Integer> sum, Set<List<Integer>>combinations){
	        if(localSum > target )
	            return;
	        
	        else{
	            if(target == localSum){
	                combinations.add(new ArrayList<Integer>(sum
	                                                        .stream()
	                                                        .sorted()
	                                                        .collect(Collectors.toList())
	                ));
	            }
	        
	            for(int i = current; i< candidates.length; i++){
	                if(candidates[i] <= target){
	                    sum.add(candidates[i]);
	                    
	                    combinationTargetSum(candidates, i+1, target, localSum + candidates[i], sum, combinations);
	                    sum.remove(sum.size() -1);
	                }
	            
	            }
	        }
	   }
	        
	  
}
