package trees.exercises;

import java.util.ArrayList;
import java.util.List;
import tree.BinaryTree;


/**
 * Your are given a binary tree in which each node contains n integer value(which 
 * might be positive or negative). Design an algorithm to count the number of paths, 
 * that sum to a given value. The path does not need to start or end at the root or 
 * a leaf, but must go downwards (traveling only from parents nodes to child nodes).
 * 
 * In this exercise you will learn how to traverse a tree giving all the possible 
 * paths from the root, and eventually, from any given node.
 * 
 * @author luisa
 * */

public class ex12 {
	
	/**
	 * Returns the number of paths in the tree such as adding the nodes 
	 * the sum is a given value.
	 * 
	 * 
	 * @param BinaryTree<Integer>
	 * @param int
	 * */
	public static int possiblePathsToSum(BinaryTree<Integer> tree, int sum) {
		
		List<Integer> l = possiblePathsToSum(tree.root(), sum, 0, new ArrayList<Integer>());
		int count = 0;
		for(int i: l)
			count+= i;
		
		return count;
	}
	
	/**
	 * Traverse a tree from a given node in postorder and and for each node, 
	 * stores in a list the number of possible paths such as adding the nodes 
	 * up, leads to a given value
	 * 
	 * @param BinaryTree<Integer>.Node<Integer>
	 * @param int
	 * @param int 
	 * @param List<Integer>
	 * */
	private static List<Integer> possiblePathsToSum(BinaryTree<Integer>.Node<Integer> node, int sum, 
			int count, List<Integer>counter){
		if(node == null)
			return counter;
		
		possiblePathsToSum(node.left, sum, count, counter);
		possiblePathsToSum(node.right, sum, count, counter);
		count = possiblePathsToSum(node, 0, sum, count);
		if(count > 0)
			counter.add(count);
		
		return counter;
	}
	
	/**
	 * Returns the number of paths in the tree such as adding the nodes from the root
	 * the sum is a given value.
	 * 
	 * @param BinaryTree<Integer>.Node<Integer> Root where all the paths start
	 * @param int 								Sum of the traversed nodes
	 * @param int 								finalSum Given value to achieve through the sum
	 * @param int 								Counter for the number of paths 
	 * */
	private static int possiblePathsToSum(BinaryTree<Integer>.Node<Integer> node, int sum, 
			final int finalSum, int count) {
		if(node == null) 
			return count;
		
		sum += node.value;
		
		if(sum == finalSum) {
			count ++;
			sum = 0;
		}
		if(node.left == null && node.right == null) {
			sum -= node.value;
			return count;
		}
		count = possiblePathsToSum(node.left, sum, finalSum, count);
		count = possiblePathsToSum(node.right, sum, finalSum, count);
		
		return count;
		

	}
}
