package linkedlist.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linkedlist.exercises.LinkedList;
import linkedlist.exercises.LinkedList.Node;

class ex8 {
	
	static final linkedlist.exercises.ex8 exercise = new linkedlist.exercises.ex8();

	@Test
	void thereIsALoop() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		Node<Integer> nodeLoop = new Node<Integer>(3);
		Node<Integer> lastNode = new Node<Integer>(1);
		lastNode.next = nodeLoop;
		
		l1.insert(3);
		l1.insert(5);
		l1.insert(7);
		l1.insert(nodeLoop);
		l1.insert(0);
		l1.insert(6);
		l1.insert(lastNode);

		boolean result = exercise.loopDetection(l1);
		assertTrue(result == true);
		
	}
	
	@Test
	void thereIsNoLoop() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.insert(3);
		l1.insert(5);
		l1.insert(7);
		l1.insert(0);
		l1.insert(6);
		
		boolean result = exercise.loopDetection(l1);
		assertTrue(result == false);
	}

}
