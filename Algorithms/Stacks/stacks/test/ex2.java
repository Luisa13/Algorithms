package stacks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stacks.exercises.ex2.StackMin;

class ex2 {

	StackMin fillUpStack() {
		stacks.exercises.ex2.StackMin ints = new StackMin(3);
		ints.push(2);
		ints.push(8);
		ints.push(6);
		ints.push(1);
		
		return ints;
	}
	
	@Test
	void pushElementAndNewMinIsCorrect() {
		StackMin exercise = fillUpStack();
		exercise.push(0);
		int min = exercise.min();
		
		assertTrue(min == 0);
	}
	
	@Test
	void pushElementAndOldMinIsCorrect() {
		StackMin exercise = fillUpStack();
		exercise.push(9);
		int min = exercise.min();
		
		assertTrue(min == 1);
	}
	
	@Test
	void topElementAndMinIsCorrect() {
		StackMin exercise = fillUpStack();
		exercise.top();
		int min = exercise.min();
		
		assertTrue(min == 2);
	}
	
	@Test
	void topElementAndMinIsCorrect2() {
		StackMin exercise = fillUpStack();
		exercise.push(0);
		exercise.top();
		int min = exercise.min();
		
		assertTrue(min == 1);
	}

}
