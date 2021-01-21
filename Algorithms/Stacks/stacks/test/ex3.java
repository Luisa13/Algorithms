package stacks.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import stack.Stack;
import stacks.exercises.ex3.SetOfStacks;

class ex3 {
	final static int CAP = 7;
	Stack<Integer> fillStack(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(6);
		
		return stack;	
	}
	
	SetOfStacks<Integer> getStack(int numStack){
		SetOfStacks<Integer> myStack = new SetOfStacks<>(CAP);
		
		Random rand = new Random();
		for(int nstack = 0; nstack < numStack; nstack++) {
			for(int i = 0; i < CAP; i++) {
				int n = rand.nextInt(10);
				myStack.push(n);
			}
		}
		return myStack;
	}

	@Test
	void peekELementInSetOfStackWithTwoFullStacks() {
		Stack<Integer> standardStack = fillStack();
		SetOfStacks<Integer> myStack = getStack(2);
		myStack.push(3);
		myStack.push(6);

		assertTrue(standardStack.peek() == myStack.peek());

	}
	
	@Test
	void topElementWhenNoCurrentStack() {
		Stack<Integer> standardStack = fillStack();
		SetOfStacks<Integer> myStack = getStack(2);

		myStack.top();
		assertTrue(myStack.size() == CAP-1);

	}
	
	
	@Test
	void topElementWhenFullStack() {
		Stack<Integer> standardStack = fillStack();
		SetOfStacks<Integer> myStack = getStack(2);
		myStack.push(3); //1
		myStack.push(6); //2
		myStack.push(8); //3
		myStack.push(9); //4
		myStack.push(7); //5
		myStack.push(5); //6
		myStack.push(0); //7
		myStack.push(2);
		myStack.top(); //--> 2 (out)
		myStack.top(); //--> 0 (out)

		assertTrue(myStack.peek() == 5);
	}
	
	
	@Test
	void pushElementInSetOfStackForNewStack() {
		Stack<Integer> standardStack = fillStack();
		SetOfStacks<Integer> myStack = getStack(2);
		myStack.push(3);

		assertTrue(myStack.size() == 1);

	}
	


}
