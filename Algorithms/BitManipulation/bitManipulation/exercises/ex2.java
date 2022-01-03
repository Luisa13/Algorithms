
package bitManipulation.exercises;

/**
 * Binary to String
 * */
public class ex2 {

	public static String binaryToString(double num) {
		
		if(num >=1  || num <= 0){
			System.out.println("ERROR");
			return "";
		}
		
		String strRes = "0.";

		while (num > 0) {
			if (strRes.length() > 32) {
				System.out.println("ERROR");
				return "";
			}
			
			int ratio = (int) (num *2);
			
			strRes = ratio == 1 ? strRes + "1"  : strRes + "0" ;
			num = num *2 - ratio;
			
		}

		return strRes;

	}

	
	public static void main(String[] args) {
		double num = 0.125;

		String res = binaryToString(num);
		System.out.println(res);

			
	}

}
