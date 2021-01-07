package Exercises;

public class ex5 {

	public LinkedList<Integer> sumList( LinkedList<Integer>l1, LinkedList<Integer> l2) {
		int dec = 1;
		int sum = 0;
		
		// First off we get the sum of the two lists
		while (l1.head != null && l2.head != null) {
			int num = (l1.current() + l2.current()) * dec;
			sum += num;
			dec *= 10;
			l1.head = l1.next();
			l2.head = l2.next();
		}
		
		// Turn the integer into a linked list digit by digit
		LinkedList<Integer> result = new LinkedList<Integer>();
		while(sum > 0) {
			int digit = sum % 10;
			sum = sum /10;
			result.insert(digit);
		}
		
		return result;
	}
}
