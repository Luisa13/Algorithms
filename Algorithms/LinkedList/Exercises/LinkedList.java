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
	 private int length;
	
	 /**
	  * Defines a node of the linked list
	  * */
	 static class Node<T> {
		T value;
		Node<T> next;
		boolean visited;
		
		Node(T data){
			this.value = data;
			this.next = null;
			this.visited = false;
		}
	 }
	 
	 /**
	  * Class constructor
	  * 
	  * */
	 public LinkedList() {
		 this.length = 0;
		 this.head = null;
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
		this.length ++;
		
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
	 * Returns the number of elements in the list
	 * @return lenght (int) Number of elements
	 * */
	public int length() {
		return this.length;
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
	 * Returns if a node has been traversed
	 * @return repeated
	 * */
	public boolean visited() {
		return this.head.visited;
	}
	
	/**
	 * Set the value of visited to True in case that node was already traversed. False otherwise
	 * @param r 
	 * */
	public void visited(boolean r) {
		this.head.visited = r;
	}
	
	/**
	 * Print the linked list
	 * 
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


