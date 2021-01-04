package exercises;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 * @author luisa
 * */
public class ex1 {
	
	/**
	 * Check if a string has all unique characters
	 * */
	public static boolean isUnique(String str) {
		
		boolean[] isRepeated = new boolean[256];
		
		for(char c: str.toCharArray()) {
			if(isRepeated[c]) 
				return false;
			else
				isRepeated[c] = true;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		String str1 = "ASDHMBA";
		String str2 = "ABNGMU";
		
		if(isUnique(str1))
			System.out.println("All chars are unique in str1");
		else
			System.out.println("Not all chars are unique in str1");

	}

}
