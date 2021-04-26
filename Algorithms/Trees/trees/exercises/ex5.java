package trees.exercises;

import tree.BinaryTree;
import tree.BinaryTree.Node;
import trees.exercises.ex2.BST;

/**
 * Check if a binary tree is a BST
 * */
public class ex5 {
	
	/**
	 * Returns true if a given tree is a valid Binary Search Tree. False otherwise
	 * 
	 * @param BST
	 * @return boolean
	 * */
	public static boolean isBST(BST tree) {
		//return isBST(tree.root());
		return checkValidBST( tree.root(), tree.left(), tree.right() );
	}
	
	@Deprecated
	private static boolean isBST(BinaryTree<Integer>.Node<Integer> node) {
		if(node == null)
			return true;
		
		if(node.left != null && node.left.value > node.value){
			return false;
		}else if(node.right != null && node.right.value < node.value) {
			return false;
		}else {
			isBST(node.left);
			isBST(node.right);	
		}
		
		return true;
	}
	
	// ==================== IMPROVED VERSION ====================
	/**
	 * Check if a tree is a valid Binary Search Tree given the root, the left node and the right.
	 * It must check all the nodes below.
	 * 
	 * @param BinaryTree<Integer>.Node<Integer> Root
	 * @param BinaryTree<Integer>.Node<Integer> Left node
	 * @param BinaryTree<Integer>.Node<Integer> Right node
	 * @return boolean
	 * */
	private static boolean checkValidBST(BinaryTree<Integer>.Node<Integer> root, 
			BinaryTree<Integer>.Node<Integer> left, 
			BinaryTree<Integer>.Node<Integer> right) {
		
		if(root == null)
			return true;
		
		if(left != null && left.value > root.value)
			return false;
		
		if(right != null && right.value < root.value) 
			return false;
		
		return checkValidBST(root.left, left, root) && 
				checkValidBST(root.right, root, right);
		
	}
	

}
