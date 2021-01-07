package Exercises;

import Exercises.LinkedList.Node;

/**
 * Given two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such the 1st digit is at the head of the list. The
 * class provide some methods to returns the sum as a linked list.
 * 
 * Example:
 * 		617 + 295 : 7->1->6  +  5->9->2
 * 		912	:	2->1->9
 *  
 *  @author luisa
 * */
public class ex5 {

	/**
	 * Returns a linked list that represent the sum of two linked lists of integers 
	 * whose digits are stored in reverse order.
	 * 
	 * @param l1 First term represented as a singly linked list of integers
	 * @param l2 Second term represented as a singly linked list of integers
	 * @return result
	 * */
	public LinkedList<Integer> sumListReverse( LinkedList<Integer>l1, LinkedList<Integer> l2) {
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
	
	//Improvement
	public LinkedList<Integer> sumListReverse2( LinkedList<Integer>l1, LinkedList<Integer> l2) {
		int digit = 0;
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		while (l1.head != null && l2.head != null) {
			double val = (l1.current() + l2.current() + digit)* 0.1;
			digit = (int)val;
			int decimal = (int)((val - digit) *10);
			result.insert(decimal);
			
			l1.head = l1.next();
			l2.head = l2.next();
			
		}
		
		return result;
	}
	
	/**
	 * FOLLOW UP
	 * 
	 * Returns a linked list that represent the sum of another two linked lists
	 * of integers whose digits are stored in forward order
	 * 
	 * @param l1 First term represented as a singly linked list of integers
	 * @param l2 Second term represented as a singly linked list of integers
	 * @return result
	 * */
	
	public LinkedList<Integer> sumList( LinkedList<Integer>l1, LinkedList<Integer> l2) {
		int sum = 0;
		
		// We got the sum of the lists
		while(l1.head != null && l2.head != null) {
			sum *= 10;
			int digit = l1.current() + l2.current();
			sum += digit;
		}
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		while(sum > 0) {
			int r = sum%10;
			sum = sum / 10;
			Node<Integer> node =new Node<Integer>(r);
			if(result.head != null) {
				result.head.next = node;
				node.next = result.head;
			}
			else
				result.head = node;
		}
		return result;
		
	}
	
	
}
