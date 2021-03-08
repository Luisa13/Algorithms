package ood.exercises.ex2;

public abstract class Employee implements Comparable<Employee> {
	public enum Rank{
		RESPONDENT(0),
		MANAGER(1),
		DIRECTOR(2);
		
		private final int id;
		
		Rank(int id){
			this.id = id;
		}
		public int getValue() {
			return this.id;
		}
	}
	
	protected String name;
	protected String surname;
	protected boolean isAvailable;
	
	public Employee(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.isAvailable = true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	public void takeCall() {
		this.isAvailable = false;
		//TODO
		// check if cannot handle the call
		//change to boolean
	}
	
	@Override
	public int compareTo(Employee employee){
		return employee.getType().compareTo(this.getType());
				//Integer.compare(this.getType().getValue(), employee.getType().getValue());
	}
	
	@Override
	public String toString() {
		return new String(this.name + " " + this.surname);
	}
	
	public abstract Rank getType();
	public abstract Rank getPromoted();
	public abstract void handOver();
	
}
