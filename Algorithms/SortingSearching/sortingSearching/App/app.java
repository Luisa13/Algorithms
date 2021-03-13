package sortingSearching.App;

import sortingSearching.exercises.ex1;

public class app {

	public static void main(String[] args) {
		
		// EXERCISE 1
		int a[] = {1,2,4,7,30,37,-1,-1,-1,-1,-1};
		int b[] = {2,3,5,20,50};
		
		int[] res = ex1.merge(a, b);
		
		for(int n: res)
			System.out.print(n + ", ");
	}

}
