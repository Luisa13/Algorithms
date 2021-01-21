package stacks.exercises;

import Stack.Stack;

/**
 * Implement a queue using twq stacks
 * @author luisa
 * */
public class ex4 {
	
	/**
	 * Implement a queue using twq stacks
	 * @author luisa
	 * */
	public static class MyQueue<T>{
		private Stack<T> in;
		private Stack<T> out;
		private T first;
		
		/**
		 * Class constructor
		 * */
		public MyQueue() {
			this.in = new Stack<T>();
			this.out = new Stack<T>();
			this.first = null;
		}
		
		/**
		 * Attaches a new element into the queue
		 * 
		 * @param element New element to be attached to the queue
		 * */
		public void push(T element) {
			this.in.push(element);
			this.first = element;
		}
		
		/**
		 * Pull out the first element pushed into the queue.
		 * 
		 * @return First element pushed into the queue.
		 * */
		public T top() {
			if(this.out.isEmpty()) {
				while(!this.in.isEmpty()) {
					this.out.push(this.in.top().value);
				}
			}
			this.first = this.out.peek();
			return this.out.top().value;
		}
		
		/**
		 * Return the value of the first element without removing it from the queue
		 * */
		public T peek() {
			return this.first;
		}
		
		/**
		 * Return the number of elements in total in que queue
		 * 
		 * @return size of the queue
		 * */
		public int size() {
			return this.out.size() + this.in.size();
		}
	}
}
