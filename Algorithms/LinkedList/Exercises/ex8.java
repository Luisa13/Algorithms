package Exercises;

import Exercises.LinkedList.Node;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * @author luisa
 * */
public class ex8 {
	
	/**
	 * Detects if there is a loop in a singly linked list and returns the 
	 * node at the beginning of the loop.
	 * 
	 * @param l1 
	 * 
	 * */
	public boolean loopDetection(LinkedList<Integer> l1){
		Node<Integer> slow = l1.head;
		Node<Integer> fast = l1.next().next;
		
		while(fast != null) {
			if(fast == slow) 
				return true;
			
			fast = fast.next;
			if(fast == null)
				return false;
			fast = fast.next;
			slow = slow.next;	
		}
		
		return false;
	}

}
