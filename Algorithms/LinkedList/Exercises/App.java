package Exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Exercises.LinkedList.Node;

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
		//l.print();
		
		//ex2 x = new ex2();
		//int n = (int) x.KthElement(l, 4);
		//System.out.print(n);
		
		//ex3 x = new ex3();
		//LinkedList<Integer>.Node<Integer> n = x.deleteMiddleNode(l.next());
		
		//ex4 x = new ex4();
		//l = x.partition(l, 4);
		//l.print();
		
		/*ex5 x = new ex5();
		LinkedList<Integer> term1 = new LinkedList<Integer>();
		term1.insert(6);
		term1.insert(1);
		term1.insert(7);
		LinkedList<Integer> term2 = new LinkedList<Integer>();
		term2.insert(2);
		term2.insert(9);
		term2.insert(5);
		
		l = x.sumList(term1, term2);
		l.print();*/
		
		/*ex6 x = new ex6();
		LinkedList<Character> pal = new LinkedList<Character>();
		pal.insert('A');
		pal.insert('B');
		pal.insert('C');
		pal.insert('B');
		pal.insert('A');
		if(x.isPalindrome(pal))
			System.out.print("Is palindrome\n");
		else
			System.out.print("Is NOT a palindrome\n");*/
		
		
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.insert(3);
		l1.insert(5);
		l1.insert(7);
		l1.insert(0);
		l1.insert(6);
		ex8 exercise = new ex8();
		boolean result = exercise.loopDetection(l1);

	
		

		
		
		
		

		
		
		
		
		


	}

}
