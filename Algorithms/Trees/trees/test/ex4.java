package trees.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tree.BinaryTree;

class ex4 {

	@Test
	void testWhenItsBalanced() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(3);
		tree.appendLeft(2);
		tree.appendRight(7);
		boolean balanced = trees.exercises.ex4.checkBalanced(tree);
		
		assertTrue(balanced);
	}
	
	@Test
	void testWhenItsNotBalanced() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(3);
		tree.appendLeft(2);
		tree.appendRight(7);
		tree.left().appendLeft(9);
		tree.left().appendRight(3);
		tree.left().left.appendLeft(4);
		tree.left().left.left.appendLeft(5);
		boolean balanced = trees.exercises.ex4.checkBalanced(tree);
		
		assertFalse(balanced);
	}
	

}
