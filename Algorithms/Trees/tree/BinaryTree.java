package tree;

/**
 * 
 * */
public class BinaryTree<T> {
	
	/**
	 * 
	 * */
	public static class Node<T>{
		T value;
		Node<T> left;
		Node<T> right;
		/**
		 * Node parameter constructor
		 * */
		Node(T v){
			this.value = v;
			this.left = null;
			this.right = null;
		}
	}
	
	
	private Node<T> root;
	
	/**
	 * Binary tree constructor
	 * */
	public BinaryTree(){
		this.root = null;
	}
	
	/**
	 * Binary tree parameter constructor
	 * */
	public BinaryTree(T v) {
		this.root = new Node<T>(v);
	}
	
	/**
	 * Given a value appends a new node to the left side
	 * 
	 * @param v <T> Value of the node to append
	 * */
	public void appendLeft(T v) {
		Node<T> newNode = new Node<T>(v);
		this.root.left = newNode;
	}
	
	/**
	 * Given a value appends a new node to the right side
	 * 
	 * @param v <T> Value of the node to append
	 * */
	public void appendRight(T v) {
		Node<T> newNode = new Node<T>(v);
		this.root.right = newNode;
	}
	
	/**
	 * Returns the left node of the current node
	 * 
	 * @return Node
	 * */
	public Node<T> left(){
		return this.root.left;
	}
	
	
	/**
	 * Returns the right node of the current node
	 * 
	 * @return Node
	 * */
	public Node<T> right(){
		return this.root.right;
	}

}
