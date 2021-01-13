package linkedlist.exercises;

import linkedlist.exercises.LinkedList.Node;

/**
 * Checks if a linked list is a palindrome
 * 
 * @author luisa
 */

public class ex6 {

	/**
	 * Checks if a linked list is a palindrome. This solution uses a string as an
	 * auxiliar structure
	 * 
	 * @param list List to check if whose values form a palindrome
	 * @param <T>
	 */
	public <T> boolean isPalindromeStr(LinkedList<T> list) {
		int n_elements = list.length();
		String str = "";
		Node<T> current = list.head;

		for (int i = 0; i < n_elements / 2; i++) {
			char c = (char) current.value;
			str += c;
			current = current.next;
		}

		str = new StringBuilder(str).toString();
		int i = 0;

		while (list.head != null) {
			if (str.charAt(i) != (char) list.current())
				return false;
			i++;
			list.head = list.next();
		}

		return true;
	}

	/**
	 * Checks if a linked list is a palindrome.
	 * 
	 * @param list List to check if whose values form a palindrome
	 * @param <T>
	 */
	public <T> boolean isPalindrome(LinkedList<T> list) {
		LinkedList<T> reversed = new LinkedList<T>();
		Node<T> current = list.head;

		while (current != null) {
			Node<T> node = new Node<T>(current.value);
			if (reversed.head != null) {
				node.next = reversed.head;
				reversed.head = node;
			} else
				reversed.head = node;

			current = current.next;
		}

		while (list.head != null) {
			if (list.current() != reversed.current())
				return false;

			reversed.head = reversed.next();
			list.head = list.next();
		}

		return true;

	}

}
