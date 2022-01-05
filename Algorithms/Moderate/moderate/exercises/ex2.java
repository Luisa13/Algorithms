package moderate.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Frequencies Design a method to find the frequency of occurrences of any
 * given word in a book. What if we were running this algorithm multiple times?
 * 
 * @author luisa
 */
public class ex2 {
	private static final Map<String, Integer> mapWords = new HashMap<>();

	private static int getWordFrenquency(final String targetWord, final String[] book) {
		if (!mapWords.containsKey(targetWord))
			return getWordFrequencies(targetWord, book);

		return mapWords.get(targetWord);
	}

	private static int getWordFrequencies(final String targetWord, final String[] book) {
		for (String word : book) {
			String lowStr = word.toLowerCase();
			if (!mapWords.containsKey(lowStr)) {
				mapWords.put(lowStr, 0);
			}
			int freq = mapWords.get(lowStr);
			freq ++;
			mapWords.put(lowStr, freq);
		}
		return mapWords.get(targetWord);
	}

	public static void main(String[] args) {
		String book = "En un lugar de la Mancha de cuyo nombre no quiero "
				+ "acordarme, no ha mucho tiempo que vivia un Hidalgo de "
				+ "los de lanza en astillero adarga antigua, rocin flaco y "
				+ "galgo corredor .";
		
		int freq = getWordFrenquency("tiempo", book.split(" "));
		System.out.print(freq);

	}

}
