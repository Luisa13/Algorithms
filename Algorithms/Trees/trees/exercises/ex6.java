package trees.exercises;


/**
 * Write an algorithm to find the next node of a given node in a binary 
 * search tree. You may assume, that each node has a link to its parent.
 * 						
 * DISCLAIMER: This code has not been properly tested because it was not 
 * provided an easy way to build a tree with the new given node structure.
 * So is a bit tedious -.-
 * 						
 * 
 * @author luisa
 * */
public class ex6 {
	
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
	}
	
	/**
	 * Return the next node in inOrder order of a given node in a BST.
	 * 
	 * @param Node node to return the successor from
	 * */
	public static Node successor(Node node) {
		if(node == null)
			return null;
		
		if(node.right != null)
			return exploreLeftChildren(node.right);
		
		else {
			return exploreParent(node.parent, node);
		}
	}
	
	/**
	 * Returns the child more at the left side
	 * 
	 * @param Node
	 * */
	private static Node exploreLeftChildren(Node node) {
		if(node == null)
			return node;
		
		return exploreLeftChildren(node.left);
	}
	
	
	/**
	 * Returns the parent of the subtree' root given a node.
	 * 
	 * @param Node Current node where to start to traverse
	 * @param Node Previous node where I come from.
	 * */
	private static Node exploreParent(Node current, Node previous) {
		if(current == null || previous == null)
			return current;
		
		if(current.left == previous)
			return current;
		
		return exploreParent(current.parent, current);
		
	}

}
