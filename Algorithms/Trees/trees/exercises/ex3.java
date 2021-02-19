package trees.exercises;

import java.util.ArrayList;
import java.util.List;

import linkedlist.exercises.LinkedList.Node;
import tree.BinaryTree;
import trees.exercises.ex2.BST;

/**
 * Given a binary search tree, design an algorithm which creates a 
 * linked list of all nodes at each depth.
 * 
 * @author luisa
 * */
public class ex3 {
	
	public static List<List<Integer>> depthsList(BSTLevel tree){
		List<List<Integer>> depths = new ArrayList<List<Integer>>();
		int depth = tree.getHeight();
		for(int i= 0; i<=depth; i++) {
			List<Integer> level = tree.getNodesPerLevel(i);
			depths.add(level);
		}
		return depths;
	}
	
	public static class BSTLevel extends BinaryTree<Integer>{
		public BSTLevel() {
			super();
		}
		
		public BSTLevel(int v) {
			super(v);
		}
		
		public BSTLevel(BST bst) {
			this.root = bst.root();
		}
		
		public int getDepth() {
			return this.getHeight();
		}
		
		private  List<Integer> getNodesPerLevel(Node<Integer> node, int level, List<Integer> list){
			if(node == null)
				return list;
			
			if(level == 1)
				list.add(node.value);
			
			else if(level > 1) {
				list = getNodesPerLevel(node.left, level-1, list);
				list = getNodesPerLevel(node.right, level-1, list);
			}
			
			return list;
		}
		
		
		public List<Integer> getNodesPerLevel(int nLevels){
			return this.getNodesPerLevel(this.root, nLevels, new ArrayList<Integer>());
		}
	}
	
	

}
