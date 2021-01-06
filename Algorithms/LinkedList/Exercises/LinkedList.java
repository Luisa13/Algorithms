package Exercises;


/**
 * Basic representation of a singly linked list with the purpose to help in the implementation of 
 * this set of exercises. Though some of them might have its own implementation of the Linked List to meet the restrictions
 * 
 * @author luisa
 * @param <T>
 * 
 * */

public class LinkedList<T> {
	 Node<T> head;
	
	 /**
	  * Defines a node of the linked list
	  * */
	 class Node<T> {
		T value;
		Node<T> next;
		boolean repeated;
		
		Node(T data){
			this.value = data;
			this.next = null;
			this.repeated = false;
		}
	}
	 
	/**
	 * Inserts a new node with T value to the linked list
	 * 
	 * @param data 	Value with T type of the new node
	 * @param list 	List to attached the new node to
	 * @return list	List that contains all the changes
	 * */ 
	@SuppressWarnings("unchecked")
	private LinkedList<T> insert(LinkedList<T> list, T data) {
		Node<T> newNode = new Node(data);
		newNode.next = null;
		
		if (list.head == null) 
			list.head= newNode;
		
		else {
			Node copy = list.head;
			while(copy.next != null) {
				copy = copy.next;
			}
			copy.next = newNode;
		}
		
		return list;
	}
	
	/**
	 * Inserts a new node with a data value
	 * 
	 * @param data Data of the new node of the list
	 * */
	public void insert(T data){
		this.insert(this, data);
	}
	
	/**
	 * Returns the next node
	 * @return next
	 * */
	public Node<T> next(){
		return this.head.next;
	}
	
	/**
	 * Sets the next node where the last node is pointing to
	 * @param n Next node
	 * */
	public void next(Node<T> n) {
		this.head.next = n;
	}
	
	/**
	 * Returns the value of the current node
	 * @return value
	 * */
	public T current() {
		return this.head.value;
	}
	
	public void current(T v) {
		this.head.value = v;
	}
	
	/**
	 * Returns if an element is repeated
	 * @return repeated
	 * */
	public boolean repeated() {
		return this.head.repeated;
	}
	
	/**
	 * Set the value of repeated to True in case there is an element that 
	 * is already in the list. False otherwise
	 * @param r 
	 * */
	public void repeated(boolean r) {
		this.head.repeated = r;
	}
	
	/**
	 * Print the linked list
	 * */
	public void print() {
		Node<T> current = this.head;
		
		while( current != null) {
			String str = current.value + " -> ";
			System.out.print(str);
			current = current.next;
		}
		
		System.out.print("\n");
	}
}


