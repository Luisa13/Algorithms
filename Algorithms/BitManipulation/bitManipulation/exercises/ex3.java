package bitManipulation.exercises;

/**
 * Flip to win.
 * 
 * @author luisa
 * */
public class ex3 {

	public static int flipToWin(int num) {

		int lastZero = -1;
		int count = 0;
		int maxCount = 0;
		int i = 0;
		
		while(num > 0) {
			int b = getLastBit(num);
			num = num >> 1;
			if(b == 0) {
				maxCount = (count > maxCount) ? count : maxCount;
				
				if(lastZero > 0) 
					count = i - lastZero;
				
				lastZero = i;
				
			}
			count ++;
			i++;
		}
		return maxCount;
	}
	
	private static int getLastBit(int num) {
		int mask = 1 << 0;
		return (num & mask) !=0 ? 1: 0;
	}
	
	public static void main(String[] args) {
		int number = 0b11010101111;
		int maxNumb = flipToWin(number);
		
		System.out.println(maxNumb);

	}

}
