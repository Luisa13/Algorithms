package Exercises;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.insert(2);
		l.insert(7);
		l.insert(3);
		l.insert(7);
		l.insert(5);
		
		l.print();
		
		//ex1 x = new ex1();
		//l = x.removesDuplicated(l);
		
		ex2 x = new ex2();
		int n = (int) x.KthElement(l, 4);
		System.out.print(n);
		

		
		
		
		
		


	}

}
