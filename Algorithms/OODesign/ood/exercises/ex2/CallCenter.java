package ood.exercises.ex2;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {
	
	private static CallCenter _instance = null;
	List<Employee> employees;
	
	private CallCenter() {
		this.employees = new ArrayList<Employee>();
	}
	
	public CallCenter getInstance() {
		if(this._instance == null)
			this._instance = new CallCenter();
		return this._instance;
	}
	
	public void addEmployee() {
		
	}
	
	public void removeEmployee() {
		
	}
	
	public void promote(Employee employee) {
		
	}
	
	public void dispatchCall() {
		
	}

}
