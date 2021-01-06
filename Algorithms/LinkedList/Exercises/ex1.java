package Exercises;

import java.util.HashSet;

public class ex1 {
	

	public <T> LinkedList<T> removesDuplicated(final LinkedList<T> root){
		//Map to control the repeated elements 
		HashSet<T> set = new HashSet<>();
		
		// Deep copy of the head to traverse the list without modifying it
		LinkedList<T>.Node<T> current = root.head;
		LinkedList<T>.Node<T> prev = null;
		
		while(current != null) {
			T element = current.value;
			// Skip the node if we aleady see that value
			if(set.contains(element)) {
				LinkedList<T>.Node<T> next = current.next;
				prev.next = next;
			}
			else {
				set.add(element);
				prev = current;
			}
			
			// Move forward
			current = current.next;
		}

		return root;
	}
}
