package stacks.exercises;

import stack.Stack;
import stack.Stack.Node;
import stacks.exercises.ex4.MyQueue;

public class ex5 {

	/**
	 * Sorts a stack in descended order
	 * 
	 * @param stack Stack to be sorted
	 * */
	public Stack<Integer> sortStack(Stack<Integer> stack) {
		//Keep the elements in ascended order
		Stack<Integer> ascendStack = new Stack<Integer>();
		//Keep the elements in descended  order
		Stack<Integer> descStack = new Stack<Integer>();
		
		while(!stack.isEmpty()) {
			Integer current = stack.peek();
			// Empty all the content into descended stack
			while(!ascendStack.isEmpty()) {
				descStack.push(ascendStack.top().value);
			}
			
			// Collect elements from the stack until we find a smaller element
			while(!stack.isEmpty() && current < stack.peek()) {
				if(!descStack.isEmpty() && current < descStack.peek()) 
					break;
				descStack.push(current);
				current = stack.top().value;
			}
			
			// Put in order the elements from the stack and the descStack 
			// until we find a smaller element in the stack
			
			while((!stack.isEmpty() || !descStack.isEmpty())) {
				if( !stack.isEmpty() && current < stack.peek() )
					break;
				if(stack.isEmpty())
					current = descStack.top().value;
				else if(descStack.isEmpty()) 
					current = stack.top().value;
				
				else { // if no one of them are empty
					if(stack.peek() > descStack.peek()) 
						current = stack.top().value;
					else 
						current = descStack.top().value;
					
				}
				ascendStack.push(current);
			}
			
		}
		return ascendStack;
	}

}
