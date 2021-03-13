package sortingSearching.App;

import sortingSearching.exercises.ex1;

public class app {

	public static void main(String[] args) {
		
		// EXERCISE 1
		int a[] = {7,9,19,40,44,-1,-1,-1,-1,-1,-1};
		int b[] = {1,2,10,20,26,30};
		
		int[] res = ex1.merge(a, b);
		
		for(int n: res)
			System.out.print(n + ", ");
	}

}
