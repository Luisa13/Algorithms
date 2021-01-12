package Exercises;

import java.lang.reflect.Array;

/**
 * How to use a single array to implement three stack.
 * @author luisa
 * */

public class ex1 {
	
	/**
	 * Manage three stacks independently as one.
	 * @author luisa
	 * */
	class ThreeStacks<T> {
		private static final int K = 3;
		// Availabe capacity for each stack
		private int size = 0;
		// Array with the top index positions of each stack.
		private int top[];
		// Array that contains the three stacks
		private T vector[];

		/**
		 * Class Constructor
		 * */
		public ThreeStacks() {
			this.top = new int[K];
			this.vector = null;
		}
		
		/**
		 * Class Constructor
		 * 
		 * @param clazz Class tipe
		 * @param size Capacity of the stack
		 * */
		@SuppressWarnings("unchecked")
		public ThreeStacks(Class<T> clazz, int size) {
			this.size = size;
			this.top = new int [K];
			this.vector  = (T[]) Array.newInstance(clazz, size);
		}
		
		/**
		 * Returns true if the stack is full. False otherwise.
		 * 
		 * @param kStack Index of the stack to check
		 * */
		boolean isFull(int kStack) {
			int cap = (kStack+1)*this.size;
			if(cap == this.top[kStack]+1)
				return true;
			else
				return false;
		}
		
		/**
		 * Push a new element into the stack and place it at the top of it.
		 * 
		 * @param element 	T object to push into the stack
		 * @param nStack	Index of the stack
		 * */
		public void push(T element, int nStack) {
			if(this.isFull(nStack)) {
				// error
				return;
			}
			int index = top[nStack];
			this.vector[index+1] = element;
			this.top[nStack] = index +1; 
		}
		
		/**
		 * Pull out the element at the top of the stack.
		 * 
		 * @param nStack Index of the stack
		 * */
		public T top(int nStack) {
			int index = this.top[nStack];
			T element = this.vector[index];
			this.vector[index] = null;
			this.top[nStack] = index -1;
			
			return element;
		}
		
	}
}
