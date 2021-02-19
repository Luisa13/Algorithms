package trees.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import trees.exercises.ex2.BST;

class ex2 {

	@Test
	void InsertSortedArray() {
		int elements[] = {1,2,3,4,5,6,7};
		BST bst = trees.exercises.ex2.minimalBST(elements);
		
		assertTrue(elements.equals(bst.intoArray()));
	}

}
