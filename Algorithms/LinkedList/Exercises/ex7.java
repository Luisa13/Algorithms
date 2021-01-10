package Exercises;

import Exercises.LinkedList.Node;

public class ex7 {
	/**
	 * given two linked lists, determine if the two lists intersect and return the
	 * intersecting node. Note that the intersection is defined based on the
	 * reference, not the value. That is, if the kth node of the first linked list
	 * is the exact same node (by reference) as the jth node of the second one, then
	 * they are intersecting.
	 * 
	 * @author luisa
	 * @param <T>
	 * 
	 */

	/**
	 * Returns the intersection between two singly linked lists. This solution
	 * implies changing the inner structure in the linked list and it checks if the
	 * node has been visited before.
	 * 
	 * @param l1
	 * @param l2
	 * @return intersection
	 */
	public <T> Node<T> intersection(LinkedList<T> l1, LinkedList<T> l2) {
		if (l1.head == null || l2.head == null)
			return null;

		Node<T> intersection = new Node<T>(null);
		
		if (l1.length() != l2.length()) {
			while (l1.head != null && l2.head != null) {
				if (l1.visited() || l2.visited())
					return l1.head;

				if (l1.head != null) {
					l1.visited(true);
					l1.head = l1.next();
				}
				if (l2.head != null) {
					l2.visited(true);
					l2.head = l2.next();
				}
			}
		}else {
			while (l1.head != null && l2.head != null) {
				if (l1.head == l2.head)
					return l1.head;
				
				l1.head = l1.next();
				l2.head = l2.next();
				
			}
		}

		return intersection;
	}
}
