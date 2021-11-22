package javaCore.collections;

import java.util.Arrays;

import javaCore.collections.model.ComparableStudent;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Primitives
		System.out.println("-----Working with primitives----");
		int array[] = {1,6,5,7,9,20,-3};
		System.out.println("Before: " + Arrays.toString(array));
		array = arrayCollection.sortPrimitives(array);
		System.out.println("After: " + Arrays.toString(array));
		
		// Objects
		System.out.println("-----Working with objects----");
		System.out.println("Sorting by age (int)");
		ComparableStudent[] studentList = new ComparableStudent[5];
		studentList[0] = new ComparableStudent("Anna", 18, 7);
		studentList[1] = new ComparableStudent("Norman", 20, 3);
		studentList[2] = new ComparableStudent("Sean", 22, 10);
		studentList[3] = new ComparableStudent("Jolenne", 19, 5);
		studentList[4] = new ComparableStudent("Leela", 24, 7);
		System.out.println("Before: " + Arrays.toString(studentList));
		studentList = arrayCollection.sortObjects(studentList);
		System.out.println("After: " + Arrays.toString(studentList));
		
		System.out.println("\nSorting by name (String)");
		studentList = arrayCollection.sortByName(studentList);
		System.out.println("After: " + Arrays.toString(studentList));
		
		System.out.println("\nSorting by two fields (grade and name)");
		studentList =  arrayCollection.sortByTwoFields(studentList);
		System.out.println("After: " + Arrays.toString(studentList));
		

	}

}
