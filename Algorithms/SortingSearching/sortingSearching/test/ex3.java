package sortingSearching.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ex3 {
	
	static final int arr[] = {15,16,20,1,5,14};

	@Test
	void testSearchInRotatedArray() {
		int pos = sortingSearching.exercises.ex3.searchRotated(arr, 5);
		assertTrue(pos == 4);
	}
	
	@Test
	void testSearchInRotatedArrayLastElement() {
		int pos = sortingSearching.exercises.ex3.searchRotated(arr, 14);
		assertTrue(pos == 5);
	}
	
	@Test
	void testSearchInRotatedArrayNoElement() {
		int pos = sortingSearching.exercises.ex3.searchRotated(arr, 7);
		assertTrue(pos < 0);
	}

}
