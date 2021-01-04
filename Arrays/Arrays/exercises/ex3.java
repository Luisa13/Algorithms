package exercises;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume 
 * that the string has sufficient psace at the end to hold the additional characters, 
 * and that you are given the true lenght of the string. Use chars array.
 * 
 * @author luisa
 * */
public class ex3 {
	
	
	public static char[] getURLify(char[] str, int len) {
		int end = len;
		int spaces = 0;
		
		//Count the spaces in the array
		for (int i = 0; i<len; i++) {
			if(str[i] == ' ')
				spaces ++;
		}
		
		int newEnd = ((spaces*3) + (end-spaces));
		while(end > 0) {
			newEnd --;
			end --;
			//Copy the chars at the very end of the string
			str[newEnd] = str[end];
			// In case we come across a space
			if(str[end] == ' ') {
				str[newEnd] = '0';
				newEnd --;
				str[newEnd] = '2';
				newEnd --;
				str[newEnd] = '%';
			}
			
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		String str = "Hello mr Jhon    ";
		System.out.print(str);
		char [] charArray = getURLify(str.toCharArray(), 13);
		System.out.print(charArray);
				
		
				
				
	}
}
