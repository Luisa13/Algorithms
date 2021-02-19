package trees.exercises;

import tree.BinaryTree;
import tree.BinaryTree.Node;
import trees.exercises.ex2.BST;

/**
 * Check if a binary tree is a BST
 * */
public class ex5 {
	
	public static boolean isBST(BST tree) {
		return isBST(tree.root());
	}
	
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

}
