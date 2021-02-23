package trees.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Implementing a binary tree class from scratch which, in addition to insert, 
 * find and delete, has a method getRandomNode() which returns a random node 
 * from  the tree. All nodes should be equally likely to be chosen. Design 
 * and implement an algorithm for the getRandomNode and explain how you would 
 * implement the rest of the methods
 * 
 * @author luisa
 * 
 * */
public class ex11 {
	public static class BinaryTree<T>{
		protected Node<T> root;
		private  Map<T, Node<T>> mapValues;
		
		class Node<T>{
			T value;
			Node<T> left, right= null;
			
			public Node(T element) {
				this.value = element;
			}
			
		}
		
		public BinaryTree(T element) {
			this.root = new Node(element);
			this.mapValues = new HashMap<T, Node<T>>();
		}
		
		public void insertRight() {
			
		}
		
		public void insertLeft() {
			
		}
		
		private void insert(T element, Node node) {
			this.mapValues.put(element, node);
		}
		
		public Node find(T element) {
			return this.mapValues.get(element);
		}
		
		public void remove(T element) {
			Node<T> n = this.mapValues.get(element);
			n = null;
		}
		
		public void remove(Node node) {
			Stack<Node<T>> stack = new Stack<Node<T>>();
			do {
				if(node.left != null) {
					this.mapValues.remove(node.value);
					if(node.right != null) {
						stack.push(node.right);
						node = node.left;
					}
				}else {
					if( !stack.isEmpty() )
						node = stack.pop();
				}
				
			}while(! stack.isEmpty());
		}
		
		
		
	}
}
