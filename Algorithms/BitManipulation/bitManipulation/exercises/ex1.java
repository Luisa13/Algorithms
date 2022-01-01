package bitManipulation.exercises;

/**
 * Insertion: You are given two 32 bit numbers M and N and two bit positions, i
 * and j. Write a method to insert M into N such that M starts at bit j and
 * finishes at i.
 */
public class ex1 {

	public static int bitInsertion(int N, int M, int i, int j) {
		if(j < i)
			return -1;
		
		// We have to clear the N number first creating a mask of 1s that have 0s from j to i.
		// The mask we need, must have 0s in the gap [i, j]
		int left = ~0 << j; // if j = 6:  11110000000
		int right  = ~(~0 << 2); // if i = 2: 00000000011
		int mask = left | right; // That will leave us with 11110000011

		
		// Clear the number N (AND)
		int cleared = N & mask; // N = 10111100111 --> 10110000011
		
		// Insert M into N
		// To do so, M should be left shifted to be merged (OR) later
		int shiftedM = M << i; // if M=10011 --> 1001100
		return cleared | shiftedM;
		
		
	}
	
	public static void main(String[] args) {
		int N = 0b110010111101;
		int M = 0b111010;
		int j = 6;
		int i = 2;
		int result = bitInsertion(N, M, i, j);
		
		System.out.println(Integer.toBinaryString(result));
	}

}
