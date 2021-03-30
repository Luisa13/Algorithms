package sortingSearching.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sortingSearching.algo.Listy;

class ex4 {
	
	private Listy init() {
		Listy l = new Listy();
		l.add(1);
		l.add(3);
		l.add(5);
		l.add(9);
		l.add(11);
		l.add(14);
		l.add(20);
		l.add(40);
		
		return l;
	}

	@Test
	void testSearchInListy() {
		Listy l = init();
		int pos = sortingSearching.exercises.ex4.searchNoSize(l, 5);
		assertTrue(pos == 2);
	}
	
	@Test
	void testSearchLastElementInListy() {
		Listy l = init();
		int pos = sortingSearching.exercises.ex4.searchNoSize(l, 40);
		assertTrue(pos == 7);
	}
	
	@Test
	void testSearchFirstElementInListy() {
		Listy l = init();
		int pos = sortingSearching.exercises.ex4.searchNoSize(l, 1);
		assertTrue(pos == 0);
	}
	
	@Test
	void testSearchNoElementInListy() {
		Listy l = init();
		int pos = sortingSearching.exercises.ex4.searchNoSize(l, 7);
		assertTrue(pos < 0);
	}

}
