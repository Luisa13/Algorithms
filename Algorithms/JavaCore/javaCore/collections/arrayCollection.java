package javaCore.collections;
import java.util.*;

import javaCore.collections.model.ComparableStudent;

public class arrayCollection {
	
	public static int[] sortPrimitives(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
	
	public static ComparableStudent[] sortObjects(ComparableStudent[] students) {
		Arrays.sort(students);
		return students;
	}
	

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
	
	public static ComparableStudent[] sortByTwoFields(ComparableStudent[] students) {
		Arrays.sort(students, new Comparator<ComparableStudent>() {
			@Override
			public int compare(ComparableStudent s1, ComparableStudent s2) {
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
