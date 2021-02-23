package trees.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.exercises.ex2.BST;

/**
 * A binary search tree was created by traversing through an array from 
 * left to right and inserting each element. Given de binary search tree 
 * with the distinct elements, print all the possible arrays that could 
 * have led to this tree.
 * 
 * @author luisa
 * 
 * */
public class ex9 {

	/**
	 * Given a BST, returns all the possible arrays that in case of 
	 * insert it in order, led to the tree.
	 * 
	 * @param BST Tree as the result of insert all the nodes in order.
	 * @return List<List<Integer>>
	 * */
	public static List<List<Integer>> allPossiblePaths(BST tree){
		List<List<Integer>> levelList = getListPerLevel(tree);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		
		
		do{
			List<Integer>option = new ArrayList<Integer>();
			for(List<Integer>level: levelList) {
				// If I got a list of element with more than one element
				if(level.size() > 0) {
					List<List<Integer>> permutations = getAllPermutations(level);
					for(List<Integer> permutation: permutations) {
						queue.add(permutation);
					}
				}else {
					option.add(level.get(0));
					if(! queue.isEmpty()) {
						for(Integer item: queue.poll())
							option.add(item);
					}
				}
			}
			
		}while(!queue.isEmpty());
		
		return result;
		
	}
	
	/**
	 * Returns a list of lists where each one contains all the 
	 * element of every level of a given tree.
	 * 
	 * @param BST
	 * @return List<List<Integer>>
	 * */
	private static List<List<Integer>> getListPerLevel(BST tree) {
		int nLevels = tree.getHeight();
		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		
		for(int i =1; i<nLevels; i++) {
			levels.add(getListPerLevel(tree.root(), i, new ArrayList<Integer>()));
		}
		
		return levels;
	}
	
	/**
	 * Returns in a list all the elements of a certain level of a given tree.
	 * 
	 * @param Node<Integer>
	 * @param int
	 * @param List<Integer>
	 * 
	 * @return List<Integer>
	 * */
	private static List<Integer> getListPerLevel(BST.Node<Integer> node, int level, List<Integer> list){
		if(node == null )
			return list;
		
		if(level == 1)
			list.add(node.value);
		
		else if(level > 1) {
			list = getListPerLevel(node.left, level-1, list);
			list = getListPerLevel(node.right, level-1, list);
		}
		
		return list;
	}
	
	/**
	 * Returns all the element permutations of a list
	 * 
	 * @param List<Integer>
	 * */
	private static List<List<Integer>> getAllPermutations(List<Integer> list) {
		List<List<Integer>> permutations = new ArrayList<>();
		if(list.isEmpty())
			return permutations;
		
		return permutations;
	}
}
