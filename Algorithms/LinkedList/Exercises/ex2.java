package Exercises;

/**
 * Implement an algorithm to find the kth to the last element of a singly linked list
 * @author luisa
 * */
public class ex2 {
	
	/**
	 * Returns the kht to the last element of a singly linked list.
	 * Note that this solution use the length method implemented in LinkedList, as it-s described below
	 * 
	 * @param root	Linked list
	 * @param kth	Position to the last element
	 * @return 		Element in the kth position to the last element
	 * */
	public <T> T KthElement(LinkedList<T> root, int kth) {
		LinkedList<T>.Node<T> current = root.head;
		
		// We can use the length method to know how many elements are in the linked list.
		//Otherwise (and most likely) we will have to count them up apart O(n)
		int n_elements = root.length();
		
		while(current != null) {
			if(kth == n_elements)
				return current.value;
			n_elements --;
			current = current.next;
			
		}
		return null;		
	}

}
