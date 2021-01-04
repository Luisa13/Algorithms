package Exercises;


/**
 * Basic implementation of a singly linked list
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
		
		Node(T data){
			this.value = data;
			this.next = null;
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
	 * Returns the value of the current node
	 * @return value
	 * */
	public T value() {
		return this.head.value;
	}
	
}


