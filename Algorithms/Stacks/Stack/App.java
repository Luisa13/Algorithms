package Stack;
import java.util.Date;

import stacks.exercises.ex6.Shetter;
import stacks.exercises.ex6.Shetter.Cat;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Stack<Integer> stack = new Stack<Integer>(7);
		stack.push(2);
		stack.push(4);
		stack.push(9);
		stack.print();*/
		
		Shetter shetter = new Shetter();
		Date date = new Date(20050516);
		Cat cat = new Cat(date, "pepe");
		shetter.enqueueCat(date, "pepe");
		date = new Date(20070516);
		cat = new Cat(date, "paco");
		shetter.enqueueCat(date, "paco");
		
		date = new Date(20060315);
		shetter.enqueueDog(date, "Marcelo");
		
		Cat c = shetter.dequeueCat();
		System.out.print(c.name());
		
		
	}

}

