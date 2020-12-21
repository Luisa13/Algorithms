package exercises;

import java.util.HashMap;
import java.util.Map;


public class ex4 {

	
	static boolean isPalindrome(String str) {
		//Remove all the spaces
		str = str.replaceAll(" ", "");
		Map<Character, Integer> charMap = new HashMap<>();
		
		//Count all the chars in the string
		for(char c: str.toCharArray()) {
			if(charMap.containsKey(c)) {
				int v = charMap.get(c);
				charMap.put(c, v+1);
			}
			else
				charMap.put(c, 1);
		}
		int odds = 0;
		//Check whether I have a pair number of each char except for one.
		for (Map.Entry<Character, Integer>entry: charMap.entrySet()) {
			if(entry.getValue() %2 != 0 ) {
				if (odds > 0)
					return false;
				else
					odds ++;
			}
				
		}
		
		return true;
	}
	public static void main(String[] args) {
		String s = "tact coa"; 
		if(isPalindrome(s))
			System.out.println("Is palindrome");
		else
			System.out.println("Is not palindrome");

	}

}
