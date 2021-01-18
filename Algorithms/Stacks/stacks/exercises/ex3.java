package stacks.exercises;

/**
 * Given a situation where a stack might get topple, an ideal case would be start a new one when the previous 
 * one exceeds some threshold. Implement a class that mimics it. This class should be composed of several 
 * stacks and should create a new stack once the previous exceeds the capacity; pop and push should behave 
 * identicall to a single stack
 * 
 * @author luisa
 * */

public class ex3 {

	/**
	 * 
	 * */
	public static class SetOfStacks <T>{
		private int size, capacity;
		private Node <T> top;
		private NodeStack<T> stacks;
		
		/**
		 * 
		 * */
		static class Node<T>{
			T value;
			Node <T> prev;
			
			public Node(T element) {
				this.value = element;
				this.prev = null;
			}
		}
		/**
		 * 
		 * */
		static class NodeStack<T>{
			Node<T> head;
			NodeStack<T> prev;
			public NodeStack() {
				// TODO Auto-generated constructor stub
			}
		}
		
		/**
		 * Class constructor
		 * 
		 * @param cap Total capacity of the stack,
		 * */
		public SetOfStacks(int cap) {
			this.size = 0;
			this.capacity = cap;
			this.stacks = new NodeStack<>();
			this.top = null;
		}
		
		/**
		 * Push a new element into the current stack. If it's full, store the whole 
		 * current stack and create a new one.
		 * 
		 * @param element New element to be pushed.
		 * */
		public void push(T element) {
			if(isFull()) {
				// Store the current stack in the stack of stacks.
				NodeStack<T> newStack = new NodeStack<>();
				newStack.head = this.top;
				newStack.prev = this.stacks;
				this.stacks = newStack;
				this.size = 0;
				// Clear it up to start over
				this.top = new Node<T>(element);
				
			}else {
				Node<T> newNode = new Node<T>(element);
				newNode.prev = this.top;
				this.top = newNode;
			}
			this.size ++;
		}
		
		/**
		 * Returns true if the current stack is full. False otherwise.
		 * 
		 * */
		private boolean isFull() {
			if(this.capacity == this.size)
				return true;
			else
				return false;
		}
		
		/**
		 * Returns the last element stored in the current stack. If the 
		 * current stack is empty, then pull out the last one and operate 
		 * with it
		 * 
		 * @return current Last element pushed into the stack.
		 * */
		public Node<T> top(){
			if(isEmpty()) {
				// The pull out the last stack stored and load it into top.
				Node<T> oldStack = this.stacks.head;
				this.stacks.head = null;
				this.stacks = this.stacks.prev;
				this.top = oldStack;
				this.size = this.capacity;	
			}
			Node<T> current = this.top;
			this.top = this.top.prev;
			this.size --;
			
			return current;
		}
		
		/**
		 * Returns true if the current stack is empty. False otherwise.
		 * */
		private boolean isEmpty() {
			if(this.size == 0)
				return true;
			else 
				return false;
		}
	}
}
