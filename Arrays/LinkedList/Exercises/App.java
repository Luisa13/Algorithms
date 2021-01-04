package Exercises;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.insert(2);
		l.insert(3);
		l.insert(7);
		l.insert(5);
		while(l.next() != null) {
			System.out.println(l.value());
			l.head = l.next();
		}


	}

}
