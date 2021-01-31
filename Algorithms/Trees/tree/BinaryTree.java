package tree;

import java.awt.print.Printable;
import java.sql.PreparedStatement;
import java.lang.Math;

/**
 * Represents a binary tree including the basic ways of traversing it (inorder,
 * preorder and postorder)
 * 
 * @param T
 * @author luisa
 */
public class BinaryTree<T> {

	/**
	 * Node for a binary tree
	 * 
	 * @param T
	 */
	public static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;

		/**
		 * Node parameter constructor
		 * 
		 * @param T value of the node
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
			if (this.left != null)
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
			if (this.right != null)
				return;
			Node<T> newNode = new Node<T>(v);
			this.right = newNode;
		}
	}

	private Node<T> root;
	private int size;
	private int height;

	/**
	 * Binary tree constructor
	 */
	public BinaryTree() {
		this.root = null;
		this.size = 0;
		this.height = 0;
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
		if (this.root.left != null)
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
		if (this.root.right != null)
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
	 * Returns the maximum height of a tree (number of levels)
	 * 
	 * @param Node Current node where starts the count
	 * @param int Counter of the levels
	 * @return int
	 * */
	private int getHeight(Node node, int count) {
		if (node == null)
			return count;

		return Math.max(getHeight(node.left, count + 1), getHeight(node.right, count + 1));
	}
	
	/**
	 * Returns the maximum height of a tree
	 * 
	 * @return int
	 * */
	public int getHeight() {
		if(height == 0)
			this.height = this.getHeight(this.root, 0);
		
		return height;
	}

	/**
	 * Prints the nodes of the tree in preOrder visiting the root in the first
	 * place, then traversing the left subtree, and finally the right subtree
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
	 * Prints the nodes of the tree in inOrder traversing the left subtree in the
	 * first place, then the root and finally the right subtree.
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
	 * Prints the nodes of the tree in PostOrder, traversing in the first place the
	 * left subtree and the right subtree and at the end, visiting root
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

	/**
	 * Print all the nodes of a certain level.
	 * 
	 * @param Node Current node to start to descend
	 * @param int  Level which belongs all the nodes to print
	 */
	private void print(Node node, int level) {
		if (node == null)
			return;

		if (level == 1)
			System.out.print(node.value + " ");

		else if (level > 1) {
			print(node.left, level - 1);
			print(node.right, level - 1);
		}
	}

	/**
	 * Print level by level the nodes of a tree
	 */
	public void print() {
		if(this.height == 0)
			this.height = this.getHeight(this.root, 0);
		
		// Print the nodes for each level
		for(int level = 0; level<=this.height; level++)
			this.print(this.root, level);
	}

}
