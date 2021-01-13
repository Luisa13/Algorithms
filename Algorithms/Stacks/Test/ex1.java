package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import stacks.exercises.ex1.ThreeStacks;
import Stack.Stack;


class ex1 {
	//static final ThreeStacks<Integer> exercise =  new ThreeStacks<Integer>(Integer.class, 5);
	
	private ThreeStacks<Integer> fillStack(){
		ThreeStacks<Integer> exercise =  new ThreeStacks<Integer>(Integer.class, 5);
		// First
		exercise.push(0, 8);
		exercise.push(0, 3);
		exercise.push(0, 6);
		// Second
		exercise.push(1, 7);
		exercise.push(1, 5);
		// Third
		exercise.push(2, 6);
		
		return exercise;
	}
	

	@Test
	void threeStacks_PushNewElement() {
		ThreeStacks<Integer> exercise =  fillStack();
		ThreeStacks<Integer> test =  exercise;
		
		exercise.push(2, 0);
		test.push(2, 0);
		assertTrue(test.equals(exercise));

	}
	
	@Test
	void threeStacks_RemoveOneElement() {
		
		ThreeStacks<Integer> exercise =  fillStack();
		ThreeStacks<Integer> test =  exercise;
		exercise.push(2, 0);	
		
		exercise.top(2);

		assertTrue(test.equals(exercise));
	}
	
	
	void threeStacks_PushElementIntoFullStack() {
		ThreeStacks<Integer> exercise =  fillStack();
		exercise.push(0, 7);
		exercise.push(0, 3);
		exercise.push(0, 1);
	}
	
	
	void threeStacks_TopatEmptyStack() {
		ThreeStacks<Integer> exercise =  new ThreeStacks<Integer>(Integer.class, 5);
		exercise.top(0);
	}

}
