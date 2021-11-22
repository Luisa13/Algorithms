package javaCore.collections.model;


public class ComparableStudent implements Comparable<ComparableStudent>{
	private String name;
	private int age;
	private float grade;
	
	public ComparableStudent() {
		this.name = null;
		this.age = 0;
		this.grade = 0;
	}
	
	public ComparableStudent(String name, int age, float grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getGrade() {
		return this.grade;
	}
	
	@Override
	public String toString() {
		return String.format(("%s, %d, %.2f "), this.name, this.age, this.grade);
	}
	

	@Override
	public int compareTo(ComparableStudent s) {
		// TODO Auto-generated method stub
		return this.age - s.age;
	}	
	
	
	/*public static class StudentComparator implements Comparator<Student>{

		@Override
		public String compare(Student s1, Student s2) {
			// TODO Auto-generated method stub
			return s1.getName().compareTo(s2.getName());
		}

	}*/
}


