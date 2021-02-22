package trees.exercises;

import trees.exercises.ex8.BTree.Node;

public class ex8 {

	public static class BTree{
		private Node root;
		
		public static class Node{
			Integer value;
			Node left;
			Node right;
			Node parent;
			
			public Node(Integer v) {
				this.value = v;
				this.left = null;
				this.right = null; 
				this.parent = null;
			}
			
			public Node appendRight(Integer element) {
				Node n = new Node(element);
				
				n.parent = this;
				this.right = n;
				
				return n;
			}
			
			public Node appendLeft(Integer element) {
				Node n = new Node(element);
				n.parent = this;
				this.left = n;
				
				return n;
			}
			
			public Node right() {
				return this.right;
			}
			
			public Node left() {
				return this.left;
			}
			
			public Integer value() {
				return value;
			}
			
		}
		
		public  BTree(Integer v) {
			this.root = new Node(v);
		}
		
		public void appendRight(Integer element) {
			if(this.root.right != null)
				return;
			
			this.root.appendRight(element);
		}
		
		public void appendLeft(Integer element) {
			if(this.root.left != null)
				return;
			this.root.appendLeft(element);
			
		}
		
		public Node left() {
			return this.root.left;
		}
		
		public Node right() {
			return this.root.right;
		}
	}
	
	
	/**
	 * Returns the earliest common ancestor of two given nodes
	 * 
	 * @param node1 Node
	 * @param node2 Node
	 * */
	public static Node commonAncestor(Node node1, Node node2) {
		int size1  = getLength(node1);
		int size2  = getLength(node2);
		
		int diff = Math.abs( size1 - size2);
		
		if(size1 > size2)
			return commonAncestor(node1, node2, diff);
		else
			return commonAncestor(node2, node1, diff);
	}
	
	/**
	 * Get the length of the path from a given node till the root of the tree.
	 * */
	private static int getLength(Node node) {
		return getLength(node, 0);
	}
	
	/**
	 * Recursive function to get the length from the given node till 
	 * the root of the tree
	 * */
	private static int getLength(Node node, int count) {
		if(node == null)
			return count;
		
		return getLength(node.parent, count+1);
	}
	
	/**
	 * Returns recursively the earliest common ancestor between two 
	 * nodes taking into account they are a different length
	 * */
	private static Node commonAncestor(Node larger, Node shorter, int stepsAhead) {
		if(larger == null || shorter == null)
			return larger;
		
		if(larger == shorter)
			return larger;
		Node n;
		if(stepsAhead > 0)
			n =  commonAncestor(larger.parent, shorter, stepsAhead-1);
		else
			n  =  commonAncestor(larger.parent, shorter.parent, stepsAhead);
		
		return n;
	}
}
