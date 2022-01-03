package bitManipulation.exercises;

/**
 * Swap odds
 * @author luisa
 * */
public class ex7 {

	public static int swappingOdds(int num) {
		int maskOdds =0xaaaaaaaa;
		int n1 = (num & maskOdds) >> 1 ;
		int maskEven =0x55555555;
		int n2 = (num & maskEven) << 1 ;
	
		return n1 | n2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0b10000110;
		int swapped = swappingOdds(n);
		
		System.out.print(Integer.toBinaryString(swapped));

	}

}
