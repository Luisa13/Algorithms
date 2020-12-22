package exercises;

public class ex9 {

	static boolean isRotation(String str1, String str2) {
		String str = str1 + str1;
		return isSubstring(str2, str);
	}
	
	/**
	 * Returns true if s1 is substring of s2. 
	 * Therefore is a condition that s2 should be larger than s1
	 * */
	static boolean isSubstring(String s1, String s2) {
		if(s1.length() > s2.length())
			return false;
		else if(s1.equals(s2))
			return true;
		
		int endIndex = s1.length();
		int i = 0;
		while(i < s2.length() && endIndex < s2.length()) {
			endIndex = i + (s1.length());
			String s2Substring = s2.substring(i, endIndex);
			
			if (s2Substring.equals(s1))
				return true;
			
			i ++;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "CDAB";
		if (isRotation(s1, s2))
			System.out.println("Yes");
		else 
			System.out.println("No");

	}

}
