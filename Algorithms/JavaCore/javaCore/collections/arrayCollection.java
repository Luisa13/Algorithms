package javaCore.collections;
import java.util.*;

public class arrayCollection {
	
	public static int[] sortPrimitives(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
	
	public static Student[] sortObjects(Student[] students) {
		Arrays.sort(students);
		return students;
	}
	

	public static Student[] sortByName(Student[] array) {
		Arrays.sort(array, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				// TODO Auto-generated method stub
				return s1.getName().compareTo(s2.getName());
			}
			
		});
		return array;
	}
	
	public static Student[] sortByTwoFields(Student[] students) {
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				String names1 = s1.getName();
				String names2 = s2.getName();
				int strComp = names1.compareTo(names2);
			
				Float grades1 = s1.getGrade();
				Float grades2 = s2.getGrade();
				int floatComp = grades1.compareTo(grades2);
				
				if (floatComp != 0 ) {
					return floatComp;
				}else {
					return strComp;
				}
			}
			
		});
		return students;
	}

}
