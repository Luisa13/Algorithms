package stacks.exercises;

/**
 * Given a situation where a stack might get topple, an ideal case would be start a new one when the previous 
 * one exceeds some threshold. Implement a class that mimics it. This class should be composed of several 
 * stacks and should create a new stack once the previous exceeds the capacity; pop and push should behave 
 * identically to a single stack.
 * 
 * The solution to this exercise might be tackled by using a inner stack of stacks (the one designed in this 
 * folder, for example) which would make the operations easier to handle. Nevertheless, I decided to implement 
 * it by using two different designs of Node classes, increasing the difficulty, just in case the use of another 
 * whole structure is not allowed (Again, should not be any problem because the Stack class is designed by myself
 * using these Node class, but...you know).
 * 
 * @author luisa
 * */

public class ex3 {

	/**
	 * Simulates a stack that create a new stack when the previous one topple.
	 * @param T
	 * */
	public static class SetOfStacks <T>{
		private int size, capacity;
		private Node <T> top;
		private NodeStack<T> stacks;
		
		/**
		 * Modulate a singly connected node
		 * @param T
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
		 * Modulate a node where each instance point both, the previous 
		 * element and the head of a stack.
		 * @param T
		 * */
		static class NodeStack<T>{
			Node<T> head;
			NodeStack<T> prev;
			public NodeStack() {
				this.head = null;
				this.prev = null;
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
		
		/**
		 * Returns the value of the last element on the stack
		 * */
		public T peek() {
			if(!isEmpty())
				return this.top.value;
			else 
				return null;
		}
		
		public int size() {
			return this.size;
		}
	}
}
