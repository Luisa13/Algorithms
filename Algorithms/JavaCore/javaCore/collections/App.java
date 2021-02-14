package javaCore.collections;

import java.util.Arrays;

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
		Student[] studentList = new Student[5];
		studentList[0] = new Student("Anna", 18, 7);
		studentList[1] = new Student("Norman", 20, 3);
		studentList[2] = new Student("Sean", 22, 10);
		studentList[3] = new Student("Jolenne", 19, 5);
		studentList[4] = new Student("Leela", 24, 7);
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
