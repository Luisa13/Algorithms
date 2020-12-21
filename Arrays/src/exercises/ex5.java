package exercises;

public class ex5 {

	static boolean isOneAway(String str1, String str2) {
		boolean diffSizes = str1.length() != str2.length();
		int i = 0, j = 0;
		int edits = 0; 
		
		while(i >= str1.length() && j >= str2.length()) {
			if(str1.charAt(i) != str2.charAt(j)) {
				edits ++;
				if(edits > 1 )
					return false;
				//In case the sizes are different
				if (diffSizes){
					//Keep iterating over the bigger one
					if(str1.length() > str2.length())
						i ++;
					else
						j ++;
				}
			}
			else { //Keep comparing the same positions
				i ++;
				j ++;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		if(isOneAway("PALE", "POLE"))
			System.out.print("Is one away");
		else System.out.print("Is not one away");

	}

}
