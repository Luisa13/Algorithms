package exercises;

import com.sun.security.jgss.InquireSecContextPermission;

/**
 * Given two strings, write a method to decide if one is permutation of the other.
 * 
 * @author luisa
 * */
public class ex2 {
	
	/**
	 * Given two strings, returns true if one is permutation of the other. False otherwise.
	 * */
	public static boolean isPermutation(String str1, String str2) {
		
		if(str1.length() != str2.length())
			return false;
		int map[] = new int[256];
		
		for(char c: str1.toCharArray()) {
			map[c]++;
		}
		
		for(char c: str2.toCharArray()) {
			if(map[c] == 0)
				return false;
			
			map[c]--;
		}
		
		return true;
	}
	public static void main(String[] args) {
		String s1 = "TOCAT";
		String s2 = "OCATT";
		
		if(isPermutation(s1, s2))
			System.out.println("They are permutation");
		else 
			System.out.println("They are not permutation");
	}

}
