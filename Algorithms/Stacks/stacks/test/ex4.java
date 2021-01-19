package stacks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stacks.exercises.ex4.MyQueue;

class ex4 {

	MyQueue<Integer> fillQueue(){
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.push(2);
		myQueue.push(4);
		myQueue.push(5);
		myQueue.push(8);
		myQueue.push(3);
		
		return myQueue;
	}
	
	@Test
	void pushElementIntoTheQueue() {
		MyQueue<Integer> myQueue = fillQueue();
		myQueue.push(1);
		
		assertTrue( myQueue.peek().equals(1) );
	}
	
	@Test
	void topElementFirstTime() {
		MyQueue<Integer> myQueue = fillQueue();
		myQueue.top();
		
		assertTrue( myQueue.peek().equals(2) );
	}
	
	@Test
	void topElementTwice() {
		MyQueue<Integer> myQueue = fillQueue();
		myQueue.top();
		myQueue.top();
		
		assertTrue( myQueue.peek().equals(4) );
	}
	
	void pushElementAfterTop() {
		MyQueue<Integer> myQueue = fillQueue();
		myQueue.top();
		myQueue.push(7);
		
		assertTrue( myQueue.peek().equals(2) );
	}

}
