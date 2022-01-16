package moderate.exercises;

/**
 * Operations.
 * 
 * Write a method to implement the multiply, subtract, and divide
 * operations for integers. The result of all of these are integers. Use only
 * the add operator.
 * 
 * APPROACH: 
 * We are going to first off with the subtract method since it's the
 * simplest one, and can be addressed with bitwise operations.
 * 
 * We will continue with multiplication, where we will just need to sum up the
 * max number as many times as the min number said (for optimal reasons, we just 
 * want to loop as less times as possible). We should cover if any of the numbers 
 * are 0, and giving the fact we are actually adding, if they're negatives.
 * 
 * And finally, we implemented division, using the above method, multiplication.
 * The key point here is to think we don't need to give an exact result as we have 
 * to return an integer. So what we are going to do, is to go through the range 
 * from 1 to a, and iteatively multiply* b by the iteator. 
 * As we do that, calculate the distance between that result and the target (a) which
 * should be less and less. When it stops improving (when the previous distance is less
 * than the one we just get), return the previous position (i-1)
 * 
 * 
 * @author luisa
 */
public class ex9 {

	/**
	 * Returns the subtraction a - b
	 * 
	 * @param int
	 * @param int
	 * 
	 * @return int
	 */
	public static int subtract(int a, int b) {
		if (a < 0 || b < 0)
			return a + b;

		b = negative(b);
		return a + b;
	}

	/**
	 * Multiply two integers an return que result.
	 * 
	 * @param int
	 * @param int
	 * 
	 * @return int
	 */
	public static int multiply(int a, int b) {
		if (a == 0 || b == 0)
			return 0;

		boolean negative = false;

		if (a < 0) {
			a = negative(a);
			negative = !negative;
		}

		if (b < 0) {
			b = negative(b);
			negative = !negative;
		}

		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int sumElement = max;

		for (int i = 1; i < min; i++)
			max += sumElement;

		return negative ? negative(max) : max;
	}

	private static int negative(int num) {
		return ((~num) + 1);
	}

	/**
	 * Returns the integer as the result of the division between two numbers
	 * @param int
	 * @param int
	 * @return int
	 * */
	public static int division(int a, int b) {
		// Check if it's a division by 0
		if (b == 0) {
			System.out.println("ERROR: Division by Zero is undefined");
			return 0;
		}

		// It's just easier to treat the numbers as positives
		boolean negative = false;
		if (a < 0) {
			a = negative(a);
			negative = !negative;
		}

		if (b < 0) {
			b = negative(b);
			negative = !negative;
		}

		int i = 1;
		int prev = Integer.MAX_VALUE;
		// Approximate the best result (the one which present a minor distance)
		while (i < a) {
			int result = multiply(b, i);
			int difference = a - result;
			if (difference < 0 || prev < difference)
				return negative? negative(i - 1): (i-1);
			
			prev = difference;
			i++;
		}

		return 0;
	}

	public static void main(String[] args) {
		// int result = subtract(6, 2); // 6-2= 4 2-9= -6
		// int result = multiply(-2, -1); // 2*6 0*5 8*0 4*-6 -1-2
		int result = division(-9, 4); // 6/3 10/4, 5/15 -8/4 9/-3
		System.out.println(result);
	}
}
