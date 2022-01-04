package bitManipulation.exercises;


/**
 * Next Number
 * @author luisa
 * */
public class ex4 {

	public static void printNextNumbers(int num) {
		// Count the number of 1s
		int nBits = 0;
		int unos = 0;
		while(num > 0 ) {
			if(oneInLastBit(num))
				unos ++;
			num = num >> 1;
			nBits ++;
		}

		int nextSmallest = ~(~0 << unos); // Bring the 1s in the last unos positions. e.g 111
		int nextLargest = nextSmallest << nBits - unos; // Shift right the 1s set up before. e.g 111000
		
		System.out.println("The next Largest: " + Integer.toBinaryString(nextLargest) );
		System.out.println("The next Smallest: " + Integer.toBinaryString(nextSmallest) );
		
	}
	
	private static boolean oneInLastBit(int num) {
		int mask = 1;
		return (num & mask) != 0;
	}
	
	public static void main(String[] args) {
		int num = 25;
		System.out.println("The number is: " + Integer.toBinaryString(num));
		printNextNumbers(num);
	}

}
