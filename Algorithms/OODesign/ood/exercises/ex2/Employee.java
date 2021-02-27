package ood.exercises.ex2;

public abstract class Employee {
	public enum Rank{
		RESPONDENT,
		MANAGER,
		DIRECTOR
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
	
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	public void takeCall() {
		
	}
	
	public abstract Rank getType();
	public abstract void getPromoted();
	public abstract void handOver();
	
}
