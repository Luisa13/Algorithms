package Stack;

/**
 * Basic representation of a Stack with the purpose to help in the implementation of 
 * this set of exercises. Though some of them might have its own implementation of the
 *  Stack to meet the restrictions
 * 
 * @author luisa
 * @param <T>
 * 
 * */

public class Stack<T> {

	protected Node<T> top;
	private int size;
	
	public static class Node<T>{
		public T value;
		public Node<T> prev;
		
		public Node(T val) {
			this.value = val;
			this.prev = null;
		}
	}
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	
	public Stack(T val) {
		Node<T> firstNode = new Node<T>(val);
		this.top = firstNode;
		this.size = 1;
	}
	
	/**
	 * Place a new element of type T at the top of the stack.
	 * 
	 * @param value Element
	 * */
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		newNode.prev = this.top;
		top = newNode;
		this.size ++;
	}
	
	/**
	 * Returns the element at the top of the stack and remove it from it.
	 * 
	 * @return result Element at the top
	 * */
	public Node<T> top(){
		Node<T> result = this.top;
		this.top = this.top.prev;
		this.size --;
		return result;
	}
	
	
	/**
	 * Returns the value of the element at the top of the stack without 
	 * removing from it.
	 * */
	public T peek() {
		return this.top.value;
	}
	
	/**
	 * Returns true if the stack has no elements left. False otherwise
	 * 
	 * */
	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Print the stack in forward order
	 * */
	public void print() {
		Node<T> copy = this.top;
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< this.size; i++) {
			sb.append(" >- " + copy.value);
			copy = copy.prev;
		}
		sb = sb.reverse();
		
		System.out.print(sb);
		System.out.println();
	}
}
