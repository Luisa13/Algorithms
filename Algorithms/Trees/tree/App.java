package tree;

import java.util.ArrayList;
import java.util.List;

import trees.exercises.ex1.DGraph;
import trees.exercises.ex2;
import trees.exercises.ex2.BST;
import trees.exercises.ex3.BSTLevel;
import trees.exercises.ex4;
import trees.exercises.ex3;

public class App {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		bt.appendLeft(8);
		bt.appendRight(2);
		bt.left().appendLeft(4);
		bt.left().appendRight(9);
		bt.right().appendRight(6);
		
		//System.out.println(bt.getHeight());
		//bt.print();
		/*bt.inOrder(); 
		bt.preOrder(); 
		bt.postOrder();*/
		
		/*DGraph<Integer> graph = new DGraph<Integer>();
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(0, 3);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		graph.thereIsARoute(0, 2);*/
		
		/*int elements[] = {1,2,3,4,5,6,7};
		BST bst = ex2.minimalBST(elements);
		BSTLevel bstlevel = new BSTLevel(bst);
		List<List<Integer>> l = ex3.depthsList(bstlevel);
		System.out.print(l);*/
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>(3);
		tree.appendLeft(2);
		tree.appendRight(7);
		tree.left().appendLeft(9);
		tree.left().appendRight(3);
		tree.left().left.appendLeft(4);
		tree.left().left.left.appendLeft(5);
		
		boolean balanced = ex4.checkBalanced(tree);
		System.out.print(balanced);
		
	
		
	
	}

}
