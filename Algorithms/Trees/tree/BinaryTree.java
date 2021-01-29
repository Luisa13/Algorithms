package tree;

import java.sql.PreparedStatement;

/**
 * Represents a binary tree
 * 
 * @author luisa
 */
public class BinaryTree<T> {

	/**
	 * Node for a binary tree
	 */
	public static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;

		/**
		 * Node parameter constructor
		 */
		Node(T v) {
			this.value = v;
			this.left = null;
			this.right = null;
		}

		/**
		 * Given a value appends a new node to the left side
		 * 
		 * @param v <T> Value of the node to append
		 */
		public void appendLeft(T v) {
			if(this.left != null)
				return;
			Node<T> newNode = new Node<T>(v);
			this.left = newNode;
		}

		/**
		 * Given a value appends a new node to the right side
		 * 
		 * @param v <T> Value of the node to append
		 */
		public void appendRight(T v) {
			if(this.right != null)
				return;
			Node<T> newNode = new Node<T>(v);
			this.right = newNode;
		}
	}

	private Node<T> root;

	/**
	 * Binary tree constructor
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Binary tree parameter constructor
	 */
	public BinaryTree(T v) {
		this.root = new Node<T>(v);
	}

	/**
	 * Given a value appends a new node to the left side
	 * 
	 * @param v <T> Value of the node to append
	 */
	public void appendLeft(T v) {
		if(this.root.left != null)
			return;
		Node<T> newNode = new Node<T>(v);
		this.root.left = newNode;
	}

	/**
	 * Given a value appends a new node to the right side
	 * 
	 * @param v <T> Value of the node to append
	 */
	public void appendRight(T v) {
		if(this.root.right != null)
			return;
		Node<T> newNode = new Node<T>(v);
		this.root.right = newNode;
	}

	/**
	 * Returns the left node of the current node
	 * 
	 * @return Node
	 */
	public Node<T> left() {
		return this.root.left;
	}

	/**
	 * Returns the right node of the current node
	 * 
	 * @return Node
	 */
	public Node<T> right() {
		return this.root.right;
	}

	/**
	 * Prints the node of the tree in preOrder visiting the root in the first place, 
	 * then traversing the left subtree, and finally the right subtree
	 * 
	 * @param Node Current node to start to print
	 */
	private void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 * Prints the node of the tree in preOrder from the root
	 */
	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}

	/**
	 * Prints the node of the tree in inOrder
	 * 
	 * @param Node Current node to start to print
	 */
	private void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	/**
	 * Prints the node of the tree in PreOrder from the root
	 */
	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}

	/**
	 * Prints the node of the tree in PostOrder
	 * 
	 * @param Node Current node to start to print
	 */
	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	/**
	 * Prints the node of the tree in PostOrder from the root
	 */
	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}

}
