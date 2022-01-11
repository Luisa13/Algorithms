package moderate.exercises;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

/**
 * English Int Given any integer, print an English phrase that describes, the
 * integer like: 1234 -> One thousand two hundred thirty four.
 * 
 * APPROACH It's clear we need a dictionary, but we don't need to store all the
 * existing numbers int it. We can store all of those whose name doesn't respond
 * a logic rule like the units, all the teens, the dozens, and then hundred,
 * thousand, and million. So we proceed as follows: 1. Decompose the number
 * dividing by 10, 100..., getting the last part of it 1.1. Accumulate the rest
 * of the module and subtract the ratio as the value we will look in the
 * dictionary. 2. Look the number in the dictionary. 2.1 In case we come across
 * with something like 400, decompose it.
 * 
 * 3. We need to be careful in case we got something like 118 when it's One
 * hundred eighteen and not one hundred ten eight. Or 15723 which is fifteen
 * thousand... and not ten thousand five thousand. So we might as well got a
 * count up to three for cent-groups.
 */
public class ex8 {

	private static Map<Integer, String> dictionary = Map.ofEntries(entry(1, "One"), entry(2, "Two"), entry(3, "Three"),
			entry(4, "Four"), entry(5, "Five"), entry(6, "Six"), entry(7, "Seven"), entry(8, "Eight"), entry(9, "Nine"),
			entry(10, "Ten"), entry(11, "Eleven"), entry(12, "Twelve"), entry(13, "Thirteen"), entry(14, "Fourteen"),
			entry(15, "Fifteen"), entry(16, "Sixteen"), entry(17, "Seventeen"), entry(18, "Eighteen"),
			entry(19, "Nineteen"), entry(20, "Twenty"), entry(30, "Thirty"), entry(40, "Fourty"), entry(50, "Fifty"),
			entry(60, "Sixty"), entry(70, "Seventy"), entry(80, "Eighty"), entry(90, "Ninety"), entry(100, "hundred"),
			entry(1_000, "thousand"), entry(1_000_000, "million"));

	public static String integerDescription(int number) {
		if (number == 0)
			return "Zero";

		String strNumber = "";
		int rest = 0;
		int div = 10;
		int prev = 0;
		int cent_counter = 0;
		int nextThree = 0;

		while (number != rest) {
			rest = number % div;

			// Look it up in the dictionary
			String strValue = "";
			if (dictionary.containsKey(rest - prev))
				strValue = dictionary.get(rest - prev);
			else
				strValue = getComplexValue((rest - prev), div / 10);

			strNumber = strValue + " " + strNumber;

			if (cent_counter >= 2) {
				int temp = rest - nextThree;
				nextThree = temp;
			}
			
			// Update values
			prev = rest;
			div *= 10;

			cent_counter++;
			cent_counter = cent_counter % 3;
		}

		return strNumber;
	}

	public static String getComplexValue(final int keyNumber, final int divider) {
		if (keyNumber == 0)
			return "";

		int unit = keyNumber / divider;
		int mult = keyNumber / unit;

		return dictionary.get(unit) + "-" + dictionary.get(mult);
	}

	public static void main(String[] args) {
		String numEnglish = integerDescription(128270);

		System.out.println(numEnglish);

	}

}
