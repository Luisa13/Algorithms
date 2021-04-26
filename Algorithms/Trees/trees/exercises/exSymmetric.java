package trees.exercises;

import tree.BinaryTree;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center)
 * @author luisa
 * */
public class exSymmetric {
	
	/**
	 * Checks if a tree is symmetric and returns true if so. False otherwise.
	 * @param BinaryTree<T>
	 * @return boolean
	 * */
	public static <T> boolean checkSymmetric(BinaryTree<T> tree) {
		return isSymmetric(tree.left(), tree.right());
	}
	
	
	/**
	 * Checks if a tree is symmetric and returns true if so. False otherwise.
	 * @param BinaryTree<T>.Node<T> Left node
	 * @param BinaryTree<T>.Node<T> Right node
	 * @return boolean
	 * */
	private static <T> boolean isSymmetric(BinaryTree<T>.Node<T> node1, BinaryTree<T>.Node<T> node2) {
		if(node1.left == null && node2.right == null)
			return true;
		
		if(node1.left == null|| node2.right == null)
			return false;
		
		return node1.left.value == node2.right.value &&
				isSymmetric(node1.left, node2.right) &&
				isSymmetric(node1.right, node2.left);
	}

}
