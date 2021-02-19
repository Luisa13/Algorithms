package trees.exercises;

import tree.BinaryTree;
import tree.BinaryTree.Node;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this 
 * question, a balanced tree is defined to be a tree such that the heights of the two subtrees 
 * of any node never differ by more than one
 * 
 * @author luisa
 * */

public class ex4 {
	public static boolean checkBalanced(BinaryTree<Integer> tree) {
		int heighLeft = getHeigh(tree.left(), 0);
		int heighRight = getHeigh(tree.right(), 0);
		int hDiffer = Math.abs(heighRight - heighLeft);
		
		if(hDiffer > 1) {
			return false;
		}
		return true;
	}
	


	private static int getHeigh(BinaryTree<Integer>.Node<Integer> node, int count) {
		if(node == null)
			return count;
		
		return Math.max(getHeigh(node.left, count++), 
				getHeigh(node.right, count++));
	}
}
