package sortingSearching.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;



class ex1 {

	@Test
	void testFirstAElementSmallestThanB() {
		int a[] = {1,2,4,7,30,37,-1,-1,-1,-1,-1};
		int b[] = {2,3,5,20,50};
		
		int[] answer = {1, 2, 2, 3, 4, 5, 7, 20, 30, 37, 50};
		int[] res = sortingSearching.exercises.ex1.merge(a, b);
		
		assertTrue(Arrays.equals(answer, res));
	}
	
	@Test
	void testBRightAfterA() {
		int a[] = {3,5,12,20,-1,-1,-1,-1,-1};
		int b[] = {21,25,26,40,60};
		
		int[] answer = {3,5,12,20,21,25,26,40,60};
		int[] res = sortingSearching.exercises.ex1.merge(a, b);
		assertTrue(Arrays.equals(answer, res));
	}
	
	@Test
	void testFirstAElementLargerThanB() {
		int a[] = {7,9,19,40,44,-1,-1,-1,-1,-1,-1};
		int b[] = {1,2,10,20,26,30};
		
		int[] answer = {1,2,7,9,10,19,20,26,30,40};
		int[] res = sortingSearching.exercises.ex1.merge(a, b);
		assertTrue(Arrays.equals(answer, res));
	}

}
