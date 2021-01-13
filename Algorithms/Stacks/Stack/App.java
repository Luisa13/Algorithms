package Stack;

import stacks.exercises.ex1.ThreeStacks;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Stack<Integer> stack = new Stack<Integer>(7);
		stack.push(2);
		stack.push(4);
		stack.push(9);
		stack.print();*/
		
		stacks.exercises.ex1.ThreeStacks<Integer> ints = new ThreeStacks<Integer>(Integer.class, 10);
		
		ints.push(0, 8);
		ints.push(0, 3);
		ints.push(0, 6);
		ints.push(0, 1);
		
		ints.push(1, 7);
		ints.push(1, 5);
		ints.push(1, 4);
		ints.push(1, 3);
		
		ints.push(2, 6);
		ints.push(2, 0);
		
		ints.print();
		
	}

}

