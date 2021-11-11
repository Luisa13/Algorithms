package exercises.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Method that returns all subset of a set
 * 
 * @author luisa
 * */
public class ex4 {

	
	public List<List<Integer>> powerSet(int[] set) {
		List<List<Integer>>combinations = new ArrayList<List<Integer>>();
		powerSet(set, combinations, new ArrayList<Integer>(), 0);
		
		return combinations;
	}
	
	private void powerSet(int[] set, List<List<Integer>>combinations, List<Integer>options, int pos) {
		combinations.add(new ArrayList<>(options));
		
		for(int i= pos; i<set.length; i++) {
			options.add(set[i]);
			powerSet(set, combinations, options, i+1);
			options.remove(options.size() -1);
		}
	}
	
	
}
