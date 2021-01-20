package Stack;
import stacks.exercises.ex5;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Stack<Integer> stack = new Stack<Integer>(7);
		stack.push(2);
		stack.push(4);
		stack.push(9);
		stack.print();*/
		
		ex5 exercise = new ex5();
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(9);
		myStack.push(8);
		myStack.push(7);
		myStack.push(3);
		myStack.push(2);
		myStack.push(1);
		
		myStack = exercise.sortStack(myStack);
		myStack.print();
		
		
	}

}

