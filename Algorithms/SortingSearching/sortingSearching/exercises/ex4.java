package sortingSearching.exercises;

import java.util.List;


/**
 * You are given an array like data structure Listy which lacks a size method. 
 * It does, however have an elementAt(i) --> get(i) method that return the element at index 
 * i in O(1) time. If i is beyond the bounds of the data structure, it returns -1.
 * 
 * Given a Listy which contains sorted, positive integers, find the index at which 
 * an element x occurs. If x occurs multiple times, you may return any index
 * 
 * @author luisa
 * */
public class ex4 {
	
	static final int PERC = 30;
	
	public int searchNoSize(List<Integer> listy, int x) {
		int max = 0;
		int min = 0;
		int i = 0;
		
		while(listy.get(i) != x && listy.get(i) > 0) {
			while(listy.get(i) > 0 && listy.get(i) < x) {
				i = jump(i, max);
				min = i;
			}
			if(listy.get(i) < 0)
				return -1;
			
			max = i;
			i = min;
		}
		return i;
			
	}
	
	private int jump(int i, int max) {
		if(max > 0) {
			i += (PERC * max)/100;
			return i;
		}
		
		return i*i +1;
	}
	
	//IMPROVEMENT

}
