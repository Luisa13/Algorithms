package trees.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import trees.exercises.ex8.BTree;
import trees.exercises.ex8.BTree.Node;

class ex8 {

	/**
	 * Creates a random tree with hardcored values
	 * */
	private BTree createTree() {
		BTree tree = new BTree(6);
		tree.appendLeft(2);
		tree.appendRight(7);
		tree.left().appendLeft(1);
		tree.left().appendRight(4);
		tree.left().right().appendLeft(3);
		tree.left().right().appendRight(5);
		tree.left().right().left().appendLeft(65);
		tree.left().right().left().appendRight(27);
		tree.right().appendRight(8);
		
		return tree;
	}
	
	@Test
	void commonAncestorleftSubtree() {
		BTree tree = createTree();
		
		Node n1 = tree.left().right().left().left(); 	//65
		Node n2 = tree.left().right().right(); 			//5
		
		Node n = trees.exercises.ex8.commonAncestor(n1, n2);
		assertTrue(n.value() == 4);
	}
	
	@Test
	void commonAncestorRightSubtree() {
		BTree tree = createTree();
		Node n1 =  tree.left().right().right();	//5
		Node n2 =  tree.right().right(); 		//8
		
		Node n = trees.exercises.ex8.commonAncestor(n1, n2);
		assertTrue(n.value() == 6);
	}
	
	@Test
	void commonAncestorWholeTree() {
		BTree tree = createTree();
		Node n1 =  tree.left().left();			//1
		Node n2 =  tree.right().right(); 		//8
		
		Node n = trees.exercises.ex8.commonAncestor(n1, n2);
		assertTrue(n.value() == 6);
	}
	
	@Test
	void commonAncestorTopLeftSubtree() {
		BTree tree = createTree();
		Node n1 =  tree.left().left();			//1
		Node n2 =  tree.left().right().right();	//5
		
		Node n = trees.exercises.ex8.commonAncestor(n1, n2);
		assertTrue(n.value() == 2);
	}

}
