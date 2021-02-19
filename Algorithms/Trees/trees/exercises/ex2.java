package trees.exercises;

import java.util.ArrayList;

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

		/*private NodeBST root;

		class NodeBST{
			private int value;
			private NodeBST left;
			private NodeBST right;

			public NodeBST(int value) {
				this.value = value;
				this.left = null;
				this.right = null;
			}
			
		}*/
		
		public BST(){
			super();
			//this.root = null;
			
		}
		
		public BST(Integer rootValue) {
			super(rootValue);
			//this.root = new NodeBST(rootValue);
		}
		
		/**
		 * Inserts a new element according to the BST restrictions, where a smaller node will be 
		 * appended to the left side and a  bigger element will be inserted at the right side.
		 * 
		 * @param NodeBST Reference node to start to traverse
		 * @param int Element value to be inserted
		 * 
		 * */
		private void insert(Node<Integer> node, int value){
			if(node == null)
				return;
			
			if(node.value > value) {
				if(node.left != null) {
					insert(node.left, value);
				}
				else {
					node.left = new Node<Integer>(value);
				}
			}else { // Node.value < element
				if(node.right != null) {
					insert(node.right, value);
				}
				else {
					node.right = new Node<Integer>(value);
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
		
		private ArrayList<Integer> pInOrder(Node<Integer> node, ArrayList<Integer>list) {
			if (node == null)
				return list;
			
			list = pInOrder(node.left, list);
			list.add(node.value);
			list = pInOrder(node.right, list);
			
			return list;
		}
		
		public Integer[] intoArray() {
			ArrayList<Integer> l = this.pInOrder(this.root, new ArrayList<Integer>());
			Integer[] array = l.toArray(new Integer[l.size()]);
			return array;
		}
		
	}
	
	/**
	 * Builds a Binary Search Tree from a sorted array, with minimal height
	 * 
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
