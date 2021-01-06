package Exercises;

/**
 * Implement an algorithm to delete a node in the middle of a singly lined list given only access to that node.
 * A node but the first and the last node, not necessarily the exact middle.
 * 
 * @author luisa
 * */
public class ex3 {

	public <T> LinkedList<T>.Node<T> deleteMiddleNode(LinkedList<T>.Node<T> node){
		node = node.next;
		
		return node;
	}
}
