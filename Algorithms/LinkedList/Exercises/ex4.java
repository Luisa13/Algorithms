package Exercises;

/**
 * Write a code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less than x. The partition element x can appear anywhere in the right
 * partition; it does not need to appear between the left and right partition.
 * 
 * Example:
 * 		Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5] 
 * 		Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * 
 * My solution achieve it by attach the picked element to the head, so therefore will be necessary
 * to keep the previous node too. Another way is to attache it to the end and in this case we will
 * have to give the reference of the tail.
 * 
 * @author luisa
 * 
 */
public class ex4 {

	/**
	 * Returns a linked list of integers that has been partitioned around a given
	 * value, from another unsorted singly linked list.
	 * 
	 * @param root Linked list of integers
	 * @param x    Partition value
	 * @return Linked list as a result
	 */
	public LinkedList<Integer> partition(LinkedList<Integer> root, int x) {
		LinkedList<Integer>.Node<Integer> head = root.head;
		LinkedList<Integer>.Node<Integer> current = root.head;
		LinkedList<Integer>.Node<Integer> prev = null;

		while (current != null) {
			//The value that will be pointing to the head is not already in the head!
			if (current.value < x && current != head) {

				LinkedList<Integer>.Node<Integer> minorNode = current;
				LinkedList<Integer>.Node<Integer> next = current.next;

				// Point to the head of the list
				minorNode.next = head;
				head = minorNode;
				
				prev.next = next;
				current = next;

			}
			else {
			prev = current;
			current = current.next;
			}
		}

		root.head = head;
		return root;
	}
}
