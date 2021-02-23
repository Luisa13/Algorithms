package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import trees.exercises.ex1.DGraph;
import trees.exercises.ex2;
import trees.exercises.ex2.BST;
import trees.exercises.ex3.BSTLevel;
import trees.exercises.ex7.Pair;
import trees.exercises.ex8;
import trees.exercises.ex8.BTree;
import trees.exercises.ex8.BTree.Node;
import trees.exercises.ex7;
import trees.exercises.ex4;
import trees.exercises.ex3;

public class App {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		bt.appendLeft(8);
		bt.appendRight(2);
		//bt.left().appendLeft(4);
		//bt.left().appendRight(9);
		//bt.right().appendRight(6);
		
		//System.out.println(bt.getHeight());
		//bt.print();
		/*bt.inOrder(); 
		bt.preOrder(); 
		bt.postOrder();*/
		
	//  ================ EXERCISE 1 ================
		/*DGraph<Integer> graph = new DGraph<Integer>();
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(0, 3);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		graph.thereIsARoute(0, 2);*/
		
	//  ================ EXERCISE 2 ================
		/*int elements[] = {1,2,3,4,5,6,7};
		BST bst = ex2.minimalBST(elements);
		BSTLevel bstlevel = new BSTLevel(bst);
		
	//  ================ EXERCISE 3 ================
		List<List<Integer>> l = ex3.depthsList(bstlevel);
		System.out.print(l);*/
		
	//  ================ EXERCISE 4 ================
		/*BinaryTree<Integer> tree = new BinaryTree<Integer>(3);
		tree.appendLeft(2);
		tree.appendRight(7);
		tree.left().appendLeft(9);
		tree.left().appendRight(3);
		tree.left().left.appendLeft(4);
		tree.left().left.left.appendLeft(5);
		
		boolean balanced = ex4.checkBalanced(tree);
		System.out.print(balanced);*/
		//  ================ EXERCISE 7 ================
		/*ex7 x = new ex7();
		List<Character> projects = new ArrayList<>(Arrays.asList('a','b','c','d', 'e', 'f')) ;
		List<Pair<Character,Character>> dependencies = new ArrayList<>(
				Arrays.asList( 
						x.new Pair<Character, Character>('a', 'd'), 
						x.new Pair<Character, Character>('f', 'b'),
						x.new Pair<Character, Character>('b', 'd'),
						x.new Pair<Character, Character>('f', 'a'),
						x.new Pair<Character, Character>('d', 'c')
						));
		
		Set<Character> set = ex7.buildOrder(projects, dependencies);
		System.out.print(set);*/
		
	//  ================ EXERCISE 8 ================
		/*BTree tree = new BTree(6);
		tree.appendLeft(2);
		tree.appendRight(7);
		tree.left().appendLeft(1);
		tree.left().appendRight(4);
		tree.left().right().appendLeft(3);
		Node n2 = tree.left().right().appendRight(5);
		Node n1 = tree.left().right().left().appendLeft(65);
		tree.left().right().left().appendRight(27);
		tree.right().appendRight(8);
		

		Node n = ex8.commonAncestor(n1, n2);
		System.out.print(n.value());*/
	//================ EXERCISE 10 ================
		
		BinaryTree<Integer> bt1 = new BinaryTree<Integer>(1);
		bt.appendLeft(8);
		bt.appendRight(2);
		
		if(bt1.equals(bt)) {
			System.out.print("Son iguales");
		}else
			System.out.print("No lo son");
	
	}

}
