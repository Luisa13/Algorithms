package sortingSearching.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Writes a method to sort an array of strings so that all the anagrams are next to each other.
 * @author luisa
 * */
public class ex2 {

	/**
	 * Groups in a list all the anagrams stored in a array of strings
	 * 
	 * @param String[]
	 * @return List<String>
	 * */
	public static List<String> groupByAnagrams(String[] strings){
		Map<String, List<String>> map= new HashMap<>();
		for(String s: strings) {
			String key = sortChars(s);
			if(! map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			List<String> strlist = map.get(key);
			strlist.add(s);
			map.put(key, strlist);
		}
		
		// Turn the map into a list with all the results
		List<String> result = new ArrayList<>();
		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			result.addAll(entry.getValue());
		}
		
		return result;
	}
	
	
	/**
	 * Returns a string with their characters sorted
	 * 
	 * @param String
	 * @return String
	 * */
	private static String sortChars(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort( chars );
		return String.valueOf(chars);
	}
	
}
