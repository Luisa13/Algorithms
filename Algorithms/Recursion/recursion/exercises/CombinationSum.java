package recursion.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique 
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in 
 * any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique 
 * if the frequency of at least one of the chosen numbers is different.
 * 
 * @author luisa
 * 
 * */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        recursion(candidates, target, 0, new ArrayList<Integer>(), list);
        
        return list;
    }
    
    public void recursion(int[] arr, int target, int pos, List<Integer> elements, List<List<Integer>>combinations){
        if(target < 0){
            return;
        }
        else{
            if(0 == target){
                combinations.add(new ArrayList(elements));
            }
        
            for(int i = pos; i< arr.length; i ++){
                elements.add(arr[i]);
                recursion(arr, target - arr[i], i, elements, combinations);
                elements.remove( (elements.size() -1) );
            }
        }
        
    }
}
