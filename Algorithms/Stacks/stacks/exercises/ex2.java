package stacks.exercises;

/**
 * Design a stack which, in addition to push and pop, has a function min which returns the minimum element. 
 * They should operate in O(1)
 * 
 * @author luisa
 * */

public class ex2 {

	/**
	 * Implements a stack structure that manage to store the minimum element.
	 * */
	public static class StackMin {
		// Points to the top of the stack
		private Node top;
		// Stores the min in order
		private Node min;
		// Positions relative to where the mins are stored
		private Node pos;
		private int size;

		class Node {
			int value;
			Node prev;

			public Node(int val) {
				this.value = val;
				this.prev = null;
			}
		}// Node class

		/**
		 * Class constructor
		 */
		public StackMin() {
			this.top = null;
			this.min = null;
			this.pos = null;
			this.size = 0;
		}

		/**
		 * Class constructor
		 * 
		 * @param val First value to be pushed onto the stack.
		 */
		public StackMin(int val) {
			this.top = new Node(val);
			this.min = new Node(val);
			this.pos = new Node(0);
			this.size = 1;
		}

		/**
		 * Keeps the position where the new min is stored in the normal stack order
		 * 
		 * @param position
		 */
		private void keepPosition(int position) {
			Node posNode = new Node(position);
			posNode.prev = this.pos;
			this.pos = posNode;
		}

		/**
		 * Push an element at the top of the stack and manage if the new element is a
		 * min
		 * 
		 * @param element
		 */
		public void push(int element) {
			// Push the new node
			Node newNode = new Node(element);
			Node newNode2 = new Node(element);
			newNode.prev = this.top;
			this.top = newNode;

			// In case the element is not the min, then we traverse the stack until
			// find the correct position to attach it
			int posCount = 0;
			if (element >= this.min.value) {
				Node current = this.min;
				while (current.prev != null && element > current.prev.value) {
					current = current.prev;
					posCount++;
				}
				Node prev = current.prev;
				current.prev = newNode2;
				newNode2.prev = prev;

			} else { // Just push it at the top otherwise
				newNode2.prev = this.min;
				this.min = newNode2;
			}
			this.keepPosition(posCount);
			this.size++;

		}

		/**
		 * Given the position, remove it from min stack
		 * 
		 * @param position Position of the element to be removed
		 * */
		private void topRemoveMin(int position) {
			if (position != 0) {
				Node current = this.min;
				int i = 0;
				while (i < position) {
					current = current.prev;
					i++;
				}
				Node prev = current.prev;
				current.prev = prev.prev;
				prev = null;
			} else
				this.min = this.min.prev;
		}

		/**
		 * Pull out the last element on the top of the stack.
		 * 
		 * @return Last node pushed which is placed on top of the stack
		 */
		public Node top() {
			Node result = this.top;
			this.top = this.top.prev;

			// Remove it from min: get the ritght position
			int posAtStack = this.pos.value;
			this.pos = this.pos.prev;
			// Remove it from min
			this.topRemoveMin(posAtStack);

			this.size--;
			return result;
		}

		/**
		 * Returns the value of the smallest element in the stack.
		 */
		public int min() {
			return this.min.value;

		}

		/**
		 * Prints the stack in forward order
		 */
		public void print() {
			this.print(this.top);
		}

		/**
		 * Prints all the mins stored
		 */
		public void printMins() {
			this.print(this.min);
		}

		/**
		 * Print a stack.
		 * @param current First node in the stack
		 * */
		private void print(Node current) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.size; i++) {
				sb.append(" >- " + current.value);
				current = current.prev;
			}
			sb = sb.reverse();

			System.out.print(sb);
			System.out.println();
		}
	}
}
