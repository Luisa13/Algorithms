package graphs.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import graphs.exercises.union.MostStonesRemoved;

class MostStonesRemoved_Test {
	
	static final int[] RESPONSES = {5,3,0}; 
	
	
	@Test
	void oneGroupStones_Five() {
		int[][] arr = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		Integer num = MostStonesRemoved.removeStones(arr);
		assertTrue(num.equals(RESPONSES[0]));
	}
	
	@Test
	void twoSeparateGroups_Three() {
		int[][] arr = {{0,0},{0,2},{1,1},{2,0},{2,2}};
		Integer num = MostStonesRemoved.removeStones(arr);
		assertTrue(num.equals(RESPONSES[1]));
	}
	
	@Test
	void notMatchingGroups_Zero() {
		int[][] arr = {{0,1},{1,0}};
		Integer num = MostStonesRemoved.removeStones(arr);
		assertTrue(num.equals(RESPONSES[2]));
	}

}
