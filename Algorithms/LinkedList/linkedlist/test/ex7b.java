package linkedlist.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linkedlist.exercises.LinkedList;
import linkedlist.exercises.LinkedList.Node;

class ex7b {
	
	linkedlist.exercises.ex7 exercise = new linkedlist.exercises.ex7();

	@Test
	void comparingWithIntesectionDifferentSizes() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<>();
		LinkedList<Integer> common = new LinkedList<>();
		common.insert(3);
		common.insert(9);
		common.insert(2);
		
		l1.insert(7);
		l1.insert(1);
		l1.insert(0);
		l1.append(common);
		
		l2.insert(5);
		l2.append(common);
		
		Node<Integer> result = exercise.intersectionB(l1, l2);
		
		assertTrue(common.head == result);
	}
	
	@Test
	void comparingNoIntersectionDifferentSizes() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<>();

		l1.insert(7);
		l1.insert(1);
		l1.insert(0);
		
		l2.insert(5);
		
		Node<Integer> result = exercise.intersectionB(l1, l2);
		assertTrue(result == null);
		
	}
	
	@Test
	void comparingIntersectionSameSize() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<>();
		LinkedList<Integer> common = new LinkedList<>();
		common.insert(3);
		common.insert(9);
		common.insert(2);
		
		l1.insert(7);
		l1.insert(1);
		l1.insert(0);
		l1.append(common);
		
		l2.insert(5);
		l2.insert(9);
		l2.insert(2);
		l2.append(common);
		
		Node<Integer> result = exercise.intersectionB(l1, l2);
		
		assertTrue(common.head == result);
	}

}
