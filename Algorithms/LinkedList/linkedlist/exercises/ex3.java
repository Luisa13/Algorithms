package linkedlist.exercises;

import linkedlist.exercises.LinkedList.Node;

/**
 * Implement an algorithm to delete a node in the middle of a singly lined list given only access to that node.
 * A node but the first and the last node, not necessarily the exact middle.
 * 
 * @author luisa
 * */
public class ex3 {

	public <T> Node<T> deleteMiddleNode(Node<T> node){
		node = node.next;
		
		return node;
	}
}
