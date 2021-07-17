package recursion.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible
 * unique permutations in any order.
 *  
 * Beware that every combination of numbers might contain duplicates, but the items in the list 
 * of combinations is unique.
 * 
 * @author luisa
 * */
public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>combinations = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        permutationsWithDuplicates(nums, 0, set);
        set.stream().forEach(p -> combinations.add(p));
        
        return combinations;
    }
    
    private void permutationsWithDuplicates(int[] nums, int pos, Set<List<Integer>>set){
        
        if(pos >= nums.length){ 
           set.add(arrayIntToList(nums)); 
        }
        
        for(int i = pos; i < nums.length; i++){
            int aux = nums[pos];
            nums[pos] = nums[i];
            nums[i] = aux;
            
            permutationsWithDuplicates(nums, pos+1, set);
            
            aux = nums[pos];
            nums[pos] = nums[i];
            nums[i] = aux;
        }
    }
    
    private List<Integer> arrayIntToList(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        for(int num: arr)
            list.add(num);
        
        return list;
    }
}
