package javaCore.collections;

import java.util.*;

import javaCore.collections.model.ComparableStudent;

/**
 * Test an array of objects that possible to compare one to another and sort them
 * with different strategies.
 * 
 * */
public class ArrayCollection {

	public static void main(String[] args) {
		System.out.println("-----Working with primitives----");
		int array[] = { 1, 6, 5, 7, 9, 20, -3 };
		System.out.println("Before: " + Arrays.toString(array));
		array = ArrayCollection.sortPrimitives(array);
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
		studentList = ArrayCollection.sortObjects(studentList);
		System.out.println("After: " + Arrays.toString(studentList));

		System.out.println("\nSorting by name (String)");
		studentList = ArrayCollection.sortByName(studentList);
		System.out.println("After: " + Arrays.toString(studentList));

		System.out.println("\nSorting by two fields (grade and name)");
		studentList = ArrayCollection.sortByTwoFields(studentList);
		System.out.println("After: " + Arrays.toString(studentList));
	}

	/**
	 * Sort an array of primitives
	 * @param int[]
	 * */
	public static int[] sortPrimitives(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}

	/**
	 * Sort ComaprableStudent by age
	 * @param ComparableStudent[] 
	 * @return ComparableStudent[] 
	 * */
	public static ComparableStudent[] sortObjects(ComparableStudent[] students) {
		Arrays.sort(students);
		return students;
	}

	/**
	 * Sort a list of students by name. Since ComparableStudent object is naturally comparable
	 * by age, it is needed to define another comparator to sort them by a different fields.
	 * 
	 * @param ComparableStudent[]
	 * @return ComparableStudent[]
	 * */
	public static ComparableStudent[] sortByName(ComparableStudent[] array) {
		Arrays.sort(array, new Comparator<ComparableStudent>() {
			@Override
			public int compare(ComparableStudent s1, ComparableStudent s2) {
				// TODO Auto-generated method stub
				return s1.getName().compareTo(s2.getName());
			}

		});
		return array;
	}

	/**
	 * Sort a list of student firstly by name and then by grade.
	 * 
	 * @param ComparableStudent[]
	 * @return ComparableStudent[]
	 * 
	 * */
	public static ComparableStudent[] sortByTwoFields(ComparableStudent[] students) {
		Arrays.sort(students, new StudentNameGradeComparator());
		return students;
	}
	
	/**
	 * This class implements the Comparator interface to be able to sort two objects by several 
	 * different fields.
	 * */
	public static class StudentNameGradeComparator implements Comparator<ComparableStudent>{

		@Override
		public int compare(ComparableStudent o1, ComparableStudent o2) {
			String names1 = o1.getName();
			String names2 = o2.getName();
			int strComp = names1.compareTo(names2);

			Float grades1 = o1.getGrade();
			Float grades2 = o2.getGrade();
			int floatComp = grades1.compareTo(grades2);

			if (floatComp != 0) {
				return floatComp;
			} else {
				return strComp;
			}
		}
		
	}

}
