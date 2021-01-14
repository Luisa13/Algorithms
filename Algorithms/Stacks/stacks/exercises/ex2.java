package stacks.exercises;

/**
 * 
 * */

public class ex2 {
	
	/**
	 * 
	 * */
	public static class StackMin{
		private Node top;
		private Node min;
		private int size;
		
		class Node{
			int value;
			Node prev;
			public Node(int val) {
				this.value = val;
				this.prev = null;
			}
		}// Node class
		
		/**
		 * Class constructor
		 * */
		public StackMin() {
			this.top = null;
			this.min = null;
			this.size = 0;
		}
		
		/**
		 *  Class constructor
		 *  
		 *  @param val First value to be pushed onto the stack.
		 * */
		public StackMin(int val) {
			Node newNode = new Node(val);
			this.top = newNode;
			this.min = newNode;
			this.size = 1;
		}
		
		/**
		 * Push an element at the top of the stack and manage if the new element is a min
		 * 
		 * @param element
		 * */
		public void push(int element) {
			Node newNode = new Node(element);
			Node newNode2 = new Node(element);
			newNode.prev = top;
			top = newNode;
			
			// In case the element is not the min, then we traverse the stack until 
			// find the correct position to attach it
			if(element >= this.min.value) {
				Node current = this.min;
				while(current.prev != null && element > current.prev.value) {
					current = current.prev;
				}
				Node prev = current.prev;
				current.prev = newNode2;
				newNode2.prev = prev;
			
			}else { // Just push it at the top otherwise
				newNode2.prev = this.min;
				this.min = newNode2;
			}
			this.size ++;
			
		}
		
		/**
		 * Pull the last element on the top out.
		 * 
		 * @return Last node pushed which is placed on top of the stack
		 * */
		public Node top() {
			Node result = this.top;
			this.top = this.top.prev;
			this.size --;
			return result;
		}
		
		/**
		 * Returns the value of the smallest element in the stack.
		 * */
		public int min() {
			return this.min.value;
			
		}
		
		/**
		 * Prints the stack in forward order
		 * */
		public void print() {
			StringBuilder sb = new StringBuilder();
			for(int i =0; i< this.size; i++) {
				sb.append(" >- " + this.top.value);
				this.top = this.top.prev;
			}
			sb = sb.reverse();
			
			System.out.print(sb);
			System.out.println();
		}
		
		/**
		 * Prints all the mins stored
		 * */
		public void printMins() {
			StringBuilder sb = new StringBuilder();
			for(int i =0; i< this.size; i++) {
				sb.append(" >- " + this.min.value);
				this.min = this.min.prev;
			}
			sb = sb.reverse();
			
			System.out.print(sb);
			System.out.println();
		}
		
	}
}
