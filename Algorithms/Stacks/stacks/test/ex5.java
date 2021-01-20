package stacks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Stack.Stack;

class ex5 {

	@Test
	void sortunsortedStack1() {
		stacks.exercises.ex5 exercise = new stacks.exercises.ex5();
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(3);
		myStack.push(7);
		myStack.push(8);
		myStack.push(1);
		myStack.push(2);
		myStack.push(9);
		myStack = exercise.sortStack(myStack);
		myStack.print();
		
		assertTrue(myStack.peek().equals(1) );
	}
	
	@Test
	void sortunsortedStack2() {
		stacks.exercises.ex5 exercise = new stacks.exercises.ex5();
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(8);
		myStack.push(3);
		myStack.push(9);
		myStack.push(7);
		
		myStack = exercise.sortStack(myStack);
		myStack.print();
		
		assertTrue(myStack.peek().equals(1) );
	}
	
	@Test
	void sortunsortedStack3() {
		stacks.exercises.ex5 exercise = new stacks.exercises.ex5();
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		
		myStack = exercise.sortStack(myStack);
		myStack.print();
		
		assertTrue(myStack.peek().equals(1) );
	}
	
	@Test
	void sortASortedStack() {
		stacks.exercises.ex5 exercise = new stacks.exercises.ex5();
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(9);
		myStack.push(8);
		myStack.push(7);
		myStack.push(3);
		myStack.push(2);
		myStack.push(1);
		
		myStack = exercise.sortStack(myStack);
		myStack.print();
		
		assertTrue(myStack.peek().equals(1) );
	}

}
