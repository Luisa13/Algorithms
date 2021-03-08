package ood.exercises.ex2;

public class Manager extends Employee{

	public Manager(String name, String surname) {
		super(name, surname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rank getType() {
		return Rank.MANAGER;
	}

	@Override
	public Rank getPromoted() {
		return Rank.DIRECTOR;
		
	}

	@Override
	public void handOver() {
		// TODO Auto-generated method stub
		
	}

}
