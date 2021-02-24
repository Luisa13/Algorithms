package trees.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;


/**
 * Implementing a binary tree class from scratch which, in addition to insert, 
 * find and delete, has a method getRandomNode() which returns a random node 
 * from  the tree. All nodes should be equally likely to be chosen. Design 
 * and implement an algorithm for the getRandomNode and explain how you would 
 * implement the rest of the methods
 * 
 * <DEPRECATED>
 * Need to be fixed
 * 
 * @author luisa
 * 
 * */
public class ex11 {
	/**
	 * Binary tree
	 * @param <T>
	 * @author luisa
	 * */
	public static class BinaryTree<T>{
		protected Node<T> root;
		private  Map<T, Node<T>> mapValues;
		
		/**
		 * Tree node of the binary tree
		 * @param <T>
		 * @author luisa
		 * */
		public static class Node<T>{
			T value;
			Node<T> left, right, parent= null;
			
			public Node(T element) {
				this.value = element;
			}
			
		}
		
		public BinaryTree() {
			this.root = null;
			this.mapValues = new HashMap<T, Node<T>>();
		}
		
		/**
		 * Parameter constructor
		 * 
		 * @param T
		 * */
		public BinaryTree(T element) {
			this.root = new Node(element);
			this.mapValues = new HashMap<T, Node<T>>();
			mapValues.put(element, this.root);
		}
		
		/**
		 * Inserts an element in the right branch
		 * 
		 * @param T
		 * */
		public void insertRight(T element) {
			if(this.root.right == null) {
				Node<T> newNode = new Node<T>(element);
				this.root.right = newNode;
				this.insert(element, newNode);
			}
		}
		
		/**
		 * Inserts an element in the left branch
		 * 
		 * @param element
		 * */
		public void insertLeft(T element) {
			if(this.root.left == null) {
				Node<T> newNode = new Node<T>(element);
				this.root.left = newNode;
				this.insert(element, newNode);
			}
		}
		/**
		 * Stores an element value in the map associating it with the corresponding node
		 * 
		 * @param T
		 * @param Node
		 * */
		private void insert(T element, Node<T> node) {
			this.mapValues.put(element, node);
		}
		
		/**
		 * Finds an element in the tree and returns it
		 * 
		 * @param T
		 * */
		public Node find(T element) {
			return this.mapValues.get(element);
		}
		
		/**
		 * Removes an element from the tree
		 * 
		 * @param T Element to be inserted
		 * */
		public void remove(T element) {
			Node<T> n = this.mapValues.get(element);
			this.mapValues.put(element, null);
			this.remove(n);

		}
		
		/**
		 * Removes an element from the tree
		 * 
		 * @param Node
		 * */
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
		
		/**
		 * Gets a random node of the tree without removing it from the structure
		 * 
		 * */
		public Node<T> getRandomNode() {
			Random random = new Random();
			Node<T> randomValue = null;
			Object[] objs = this.mapValues.values().toArray();
			try {
				Node<T>[] nodes = (Node<T>[]) objs;
				 randomValue= nodes[random.nextInt(nodes.length)];
				
			}catch(Exception ex) {
				System.out.print("ERROR: " + ex.getMessage());
			}
			
			return randomValue;
		}
		
		
		
	}
}
