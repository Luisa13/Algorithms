package trees.exercises;

import tree.BinaryTree;

/**
 * Given a sorted (increased order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height.
 * 
 * @author luisa
 * */
public class ex2 {
	
	public static class BST extends BinaryTree<Integer>{
		//private Node<Integer> root;
		static class NodeBST extends Node<Integer>{
			private Integer value;
			private NodeBST left;
			private NodeBST right;
			
			public NodeBST(Integer v) {
				super(v);
				this.value = v;
				this.left = null;
				this.right = null;
			}	
			
			public Integer getValue() {
				return this.value;
			}
			
			public NodeBST left() {
				return this.left;
			}
			
			public NodeBST right() {
				return this.right;
			}
		}
		
		private NodeBST root;
		
		public BST(){
			this.root = null;
		}
		
		public BST(Integer rootValue) {
			this.root = new NodeBST(rootValue);
		}
		
		/**
		 * Inserts a new element according to the BST restrictions, where a smaller node will be 
		 * appended to the left side and a  bigger element will be inserted at the right side.
		 * 
		 * @param NodeBST Reference node to start to traverse
		 * @param int Element value to be inserted
		 * 
		 * */
		private void insert(NodeBST node, int value){
			if(node == null)
				return;
			
			if(node.getValue() < value) {
				if(node.left != null) {
					insert(node.left, value);
				}
				else {
					node.left = new NodeBST(value);
				}
			}else { // Node.value > element
				if(node.right != null) {
					insert(node.right, value);
				}
				else {
					node.right = new NodeBST(value);
				}
			}
		}
		
		/**
		 * Inserts a new element according to the BST restrictions
		 * 
		 * @param int Element value to be inserted
		 * 
		 * */
		public void insert(int element) {
			this.insert(this.root, element);
		}
		
		
	}
	
	/**
	 * Builds a Binary Search Tree from a sorted array, with minimal height
	 * */
	public static BST minimalBST(int [] array) {
		int midPoint = array.length/2;
		BST bst = new BST(array[midPoint]);
		
		int first = midPoint-1;
		int second = midPoint+1;
		
		while(first >= 0 && second < array.length) {
			if(first >= 0) {
				bst.insert(array[first]);
				first --;
			}
			if(second < array.length) {
				bst.insert(array[second]);
				second ++;
			}
		}
		
		return bst;
	}
		

}
