package sortingSearching.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ex5 {

	@Test
	void testSearchInSparseString() {
		String strings [] = {"asd", "", "", "", "baff", "", "cft", "", "", "fsd", "tre", "", "", ""};
		int pos = sortingSearching.exercises.ex5.sparseSearch(strings, "baff");
		assertTrue(pos == 4);
	}
	
	@Test
	void testSearchLastElementInSparseString() {
		String strings [] = {"asd", "", "", "", "baff", "", "cft", "", "", "fsd", "tre", "", "", ""};
		int pos = sortingSearching.exercises.ex5.sparseSearch(strings, "tre");
		assertTrue(pos == 10);
	}
	
	@Test
	void testSearchFirstElementInSparseString() {
		String strings [] = {"asd", "", "", "", "baff", "", "cft", "", "", "fsd", "tre", "", "", ""};
		int pos = sortingSearching.exercises.ex5.sparseSearch(strings, "asd");
		assertTrue(pos == 0);
	}
	
	@Test
	void testSearchNoElementInSparseString() {
		String strings [] = {"asd", "", "", "", "baff", "", "cft", "", "", "fsd", "tre", "", "", ""};
		int pos = sortingSearching.exercises.ex5.sparseSearch(strings, "ewr");
		assertTrue(pos < 0);
	}
	
	

}
