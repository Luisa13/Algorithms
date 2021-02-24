package trees.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tree.BinaryTree;

class ex12 {

	@Test
	void testTwoPossibleResultsAtDifferentDepths() {
		// Creates the binary tree
		BinaryTree<Integer> bt = new BinaryTree<Integer>(4);
		bt.appendLeft(1);
		bt.appendRight(3);
		bt.right().appendLeft(9);
		bt.right().appendRight(4);
		bt.right().left.appendLeft(7);
		bt.right().left.appendRight(2);
		
		int v = trees.exercises.ex12.possiblePathsToSum(bt, 11);
		assertTrue(v == 2);
	}
	
	@Test
	void testOnePossibleResult() {
		// Creates the binary tree
		BinaryTree<Integer> bt = new BinaryTree<Integer>(4);
		bt.appendLeft(1);
		bt.appendRight(3);
		bt.right().appendLeft(9);
		bt.right().appendRight(5);
		bt.right().left.appendLeft(7);
		bt.right().left.appendRight(2);
		
		int v = trees.exercises.ex12.possiblePathsToSum(bt, 8);
		assertTrue(v == 1);
	}
	
	void testTwoPossibleResultsWithOneFakePath() {
		// Creates the binary tree
		BinaryTree<Integer> bt = new BinaryTree<Integer>(4);
		bt.appendLeft(1);
		bt.appendRight(3);
		bt.right().appendLeft(-2);
		bt.right().appendRight(5);
		bt.right().left.appendLeft(3);
		bt.right().left.appendRight(2);
		
		int v = trees.exercises.ex12.possiblePathsToSum(bt, 8);
		assertTrue(v == 2);
	}
	
	@Test
	void testTwoPossibleResultWhenOneIsLeaf() {
		// Creates the binary tree
		BinaryTree<Integer> bt = new BinaryTree<Integer>(4);
		bt.appendLeft(1);
		bt.appendRight(3);
		bt.right().appendLeft(9);
		bt.right().appendRight(5);
		bt.right().left.appendLeft(7);
		bt.right().left.appendRight(2);
		
		int v = trees.exercises.ex12.possiblePathsToSum(bt, 5);
		assertTrue(v == 2);
	}
	
	@Test
	void testNoPossibleResult() {
		// Creates the binary tree
		BinaryTree<Integer> bt = new BinaryTree<Integer>(4);
		bt.appendLeft(1);
		bt.appendRight(3);
		bt.right().appendLeft(9);
		bt.right().appendRight(5);
		bt.right().left.appendLeft(7);
		bt.right().left.appendRight(2);
		
		int v = trees.exercises.ex12.possiblePathsToSum(bt, 26);
		assertTrue(v == 0);
	}
	

}
