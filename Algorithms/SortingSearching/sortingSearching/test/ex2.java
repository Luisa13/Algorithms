package sortingSearching.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ex2 {

	@Test
	void testBasic() {
		String[] arrayStr = {"ABC", "NNH", "BAC" ,"CCN", "HNN", "CBA"};
		List<String> result = sortingSearching.exercises.ex2.groupByAnagrams(arrayStr);
		
		List<String> answer = Arrays.asList("ABC", "BAC", "CBA", "NNH", "HNN", "CCN");
		assertTrue(result.equals(answer));
	}
	
	@Test
	void testNoAnagramsToGroup() {
		String[] arrayStr = {"ABRC", "NNH", "BAC" ,"CPCN", "SHNN", "UCBA"};
		List<String> result = sortingSearching.exercises.ex2.groupByAnagrams(arrayStr);
		List<String> answer = Arrays.asList("BAC", "NNH", "SHNN", "CPCN", "UCBA", "ABRC");

		assertTrue(result.equals(answer));
	}
	
	@Test
	void allAnagramsButOne() {
		String[] arrayStr = {"ABRC", "NNHU", "ABRC" ,"ABRC", "ABRC", "ABRC"};
		List<String> result = sortingSearching.exercises.ex2.groupByAnagrams(arrayStr);
		List<String> answer = Arrays.asList("ABRC", "ABRC" ,"ABRC", "ABRC", "ABRC", "NNHU");
		System.out.print(result);
		assertTrue(result.equals(answer));
		
	}

}
