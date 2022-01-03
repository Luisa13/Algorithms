package bitManipulation.exercises;

/**
 * Conversion
 * @author luisa
 * */
public class ex6 {

	public static int numberForConversion(int num1, int num2) {
		int resultXOR = num1 ^ num2;
		int count = 0;
		
		while(resultXOR > 0) {
			if(lastBitIsOne(resultXOR))
				count ++;
			
			resultXOR =  resultXOR >> 1;
		}
		
		return count;
	}
	
	private static boolean lastBitIsOne(int num) {
		int mask = 1;
		return (num & mask) != 0;
	}
	
	public static void main(String[] args) {
		int a = 0b11101;
		int b = 0b01111;
		
		int numConversions = numberForConversion(a, b);
		System.out.println(numConversions);

	}

}
