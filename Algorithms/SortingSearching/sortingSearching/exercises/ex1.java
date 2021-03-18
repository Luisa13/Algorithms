package sortingSearching.exercises;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at 
 * the end to hold B. Write a method to merge B into A in sorted order.
 * 
 * 
 * WARNING: more test are needed in order to guarantee a free bugs code :P
 * 
 * @author luisa
 * */
public class ex1 {
	
	
	public static int[] merge(int[] a, int[] b) {
		if(a.length < b.length)
			return null;
		
		return merges(a, b);
	}
	
	// NAIVE APPROACH
	private static int[] merges(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		
		while(a.length > i) {
			while(a[i] <= b[j] && a[i] > 0) {
				i++;
			}
			if(a[i] < 0 && q.isEmpty()) {
				while(j < b.length) {
					a[i] = b[j];
					i++;
					j++;
				}
			// Inserts b' elements into a until the next larger one
			}else if(a[i] > b[j] || a[i] < 0) {	 
				do {
					if( a[i] > 0 ) 
						q.add(a[i]);
					a[i] = b[j];
					i++;
					j++;
				}while(j < b.length && q.peek() > b[j]);
				// Once we found in a an element larger, we need to catch up 
				//with those we kept to make some room.
				while(!q.isEmpty() && q.peek() < b[j]) {
					if( a[i] > 0 ) 
						q.add(a[i]);
					a[i] = q.poll();
					i++;
				}
			}
		}
		
		return a;
	}
	
	
	// IMPROVEMENT
	// It's actually way better start off by the END, since we already 
	//have some space there (less messy cause there is no need to move aaaall the elements)
	private static int[] merges2(int[] a, int[] b) {
		
		return a;
	}
	
}
