package exercises.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * APPROACH:
 * So this is still a problem that might be tacked by using backtracking since the description 
 * is talking about 'all possible[...]' with means combinations. The twist here is we still need 
 * to keep traversing those items we left behind as it's a permutation. To do so, we attach the 
 * current node to the tail of the list.
 * 
 * @author luisa
 * 
 * */
public class Permutations {

public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>>combinations = new ArrayList<List<Integer>>();
        allPermutations(nums, 0, nums.length, combinations);
        return combinations;
    }
    
    private void allPermutations(int[] nums, int pos, int len, List<List<Integer>>combinations){
        if(pos >= nums.length){
            combinations.add(arrayIntToList(nums));
            //Arrays.stream(nums).forEach(p-> System.out.print( p));
            //System.out.println("end");
        }
        
        
        for(int i =pos; i < len; i++){
            int aux = nums[pos];
            nums[pos] = nums[i];
            nums[i] = aux;

            allPermutations(nums, pos+1, len, combinations);
            
            aux = nums[pos];
            nums[pos] = nums[i];
            nums[i] = aux;
                           
            
        }
    }
    
    List<Integer> arrayIntToList(int[] arr){
        
        List<Integer> list = new ArrayList<Integer>();
        for(int num: arr){
            list.add(num);
        }   
        return list;
    }
}
