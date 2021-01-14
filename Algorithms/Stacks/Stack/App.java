package Stack;

import stacks.exercises.ex2.StackMin;
import stacks.exercises.ex2.StackMin;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Stack<Integer> stack = new Stack<Integer>(7);
		stack.push(2);
		stack.push(4);
		stack.push(9);
		stack.print();*/
		
		stacks.exercises.ex2.StackMin ints = new StackMin(3);
		
		ints.push(2);
		ints.push(8);
		ints.push(6);
		ints.push(1);
	
		ints.top();
		ints.print();
		ints.printMins();
		ints.top();
		ints.print();
		ints.printMins();
		
	}

}

