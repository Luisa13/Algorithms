package ood.exercises.ex2;

public class Respondent extends Employee{

	public Respondent(String name, String surname) {
		super(name, surname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rank getType() {
		return Rank.RESPONDENT;
	}

	@Override
	public Rank getPromoted() {
		return Rank.MANAGER;
		
	}

	@Override
	public void handOver() {
		// TODO Auto-generated method stub
		
	}

}
