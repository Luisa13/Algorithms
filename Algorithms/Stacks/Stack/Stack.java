package Stack;

public class Stack<T> {

	Node<T> top;
	
	static class Node<T>{
		T value;
		Node<T> prev;
		public Node(T val) {
			this.value = val;
			this.prev = null;
		}
	}
	
	public Stack() {
		this.top = null;
	}
	
	public Stack(T val) {
		Node<T> firstNode = new Node<T>(val);
		this.top = firstNode;
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
	}
	
	/**
	 * Returns the element at the top of the stack and remove it from it.
	 * 
	 * @return result Element at the top
	 * */
	public Node<T> top(){
		Node<T> result = this.top;
		this.top = this.top.prev;
		return result;
	}
	
	/**
	 * Returns the value of the element at the top of the stack without 
	 * removing from it.
	 * */
	public T peek() {
		return this.top.value;
	}
}
