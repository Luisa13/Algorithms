package exercises;

public class ex6 {
	
	static String stringCompression(String str) {
		String strCompressed = "";
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			int count = 0;
			while(i< str.length() && c == str.charAt(i)) {
				count ++;
				i ++;
			}
			String newEntry = c + "" + count;
			strCompressed += newEntry;
			
		}
		
		//If the size of the compressed version is bigger, return the original
		if(strCompressed.length() > str.length())
			return str;
		
		return strCompressed;
	}
	public static void main(String[] args) {
		
		String s = "aaaaabaanbbbgggggg";
		System.out.println("Original string: " + s);
		System.out.println("Compressed:" + stringCompression(s));
		
	}
}
