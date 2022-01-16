package moderate.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Diving Board You are building a diving board by placing a bunch of planks of
 * wood end-to-end. There are two types of planks, one of length shorter and one
 * the length. Write a method to generate all possible lengths of the diving board.
 * 
 * APPROACH:
 * This problem is basically asking how many different sums we can get if we combine
 * shorter size and large size in k different ways, which lead us to backtracking,
 * now let's think in the backtracking frame to address the problem.
 * 
 * My choice, is limited by the numbers I can combine. That is the space of choice, 
 * and this are the option among I can choose. There is only two types of size, so
 * there is only 2 I can combine.
 * 
 * My constrains are the conditions I set to my algorithm. In this case, my condition
 * is I can only choose k planks. No more than that. Aslo we want to cut down all the 
 * redundant results, so let's use a Set to store the elements.
 * 
 * My goal or solution is the sum as a result of combining all those numbers. So there 
 * you go.
 * 
 * #Backtracking, #Recursion
 * 
 * @author luisa
 */
public class ex11 {

	public static void getLenghts(int k, int largePlank, int shortPlank, int sum, Set<Integer> lengths) {
		if(k == 0) {
			lengths.add(sum);
			return;
		}
		
		
		getLenghts(k-1, largePlank, shortPlank, sum + largePlank, lengths);
		getLenghts(k-1, largePlank, shortPlank, sum + shortPlank, lengths);
	}	
	
	public static void main(String[] args) {
		Set<Integer> list = new HashSet<>();
		
		getLenghts(10, 3, 6, 0, list);
		
		System.out.println(list);

	}

}
