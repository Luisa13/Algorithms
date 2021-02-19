package trees.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import trees.exercises.ex2.BST;
import trees.exercises.ex3.BSTLevel;

class ex3 {

	@Test
	void testListBinaryTree() {
		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		List<Integer> listlevel = new ArrayList<Integer>();
		BST bst = new BST(4);
		listlevel.add(4);
		levels.add(listlevel);
		listlevel = new ArrayList<>();
		bst.appendLeft(2);
		bst.appendRight(9);
		listlevel.add(2);
		listlevel.add(9);
		levels.add(listlevel);
		listlevel = new ArrayList<Integer>();
		bst.insert(7);
		bst.insert(8);
		bst.insert(1);
		bst.insert(3);
		listlevel.add(1);
		listlevel.add(3);
		listlevel.add(7);
		levels.add(listlevel);
		listlevel = new ArrayList<Integer>();
		listlevel.add(8);
		levels.add(listlevel);
		
		
	
		BSTLevel bstlevel = new BSTLevel(bst);
		List<List<Integer>> l = trees.exercises.ex3.depthsList(bstlevel);
		System.out.print(l);
		System.out.print(levels);
		assertTrue(l.equals(levels));
		
	}

}
