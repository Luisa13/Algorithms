package ood.exercises.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import ood.exercises.ex2.Employee.Rank;

/**
 * Simulates a call center where there are three levels of employees. Each
 * employee takes the calls as they become free, otherwise hand the call over to
 * the next one in the hierarchy. This class should follow the singleton pattern
 * as there is only one call center.
 * 
 * @author luisa
 */
public class CallCenter {

	private  static CallCenter _instance;
	private List<Employee> employees;

	private CallCenter() {
		this.employees = new ArrayList<Employee>();
	}

	public static CallCenter getInstance() {
		if (_instance == null)
			_instance = new CallCenter();
		return _instance;
	}

	/**
	 * Add an employee to the call center
	 * 
	 * @param String
	 * @param String
	 * @param Rank
	 */
	public void addEmployee(String name, String surname, Rank rank) {
		Employee employee;

		switch (rank) {
		case RESPONDENT:
			employee = new Respondent(name, surname);
			break;
		case MANAGER:
			employee = new Manager(name, surname);
			break;
		case DIRECTOR:
			employee = new Director(name, surname);
		default:
			employee = new Respondent(name, surname);
		}
		_instance.employees.add(employee);
	}

	/**
	 * Removes an employee identified by the name and the surname
	 * 
	 * @param String
	 * @param String
	 */
	public void removeEmployee(String name, String surname) {
		// List<Employee> empToRemove = new ArrayList<>();

		_instance.employees.stream().filter((e) -> e.getName().equals(name) && e.getSurname().equals(surname))
				.forEach((e) -> _instance.employees.remove(e));
	}

	/**
	 * Levels the rank up of an employee
	 * 
	 * @param Employee
	 * @throws Exception
	 */
	public void promote(Employee employee) throws Exception {
		_instance.employees.remove(employee);
		if (employee.getType() == Rank.DIRECTOR)
			throw new Exception("This employee cannot be promoted");

		Rank r = employee.getPromoted();
		_instance.employees.remove(employee);
		this.addEmployee(employee.name, employee.surname, r);
	}

	/**
	 * Assigns a call to the first available employee (RESPONDENT)
	 * @throws Exception 
	 * 
	 */
	public void dispatchCall() throws Exception {
		List<Employee> employeesAvailable = new ArrayList<>();

		Collections.sort(_instance.employees);
		
		_instance.employees.stream()
		.filter((e) -> e.isAvailable() && e.getType().equals(Rank.RESPONDENT)).
		forEach((e) -> employeesAvailable.add(e));
		
		if(employeesAvailable.isEmpty())
			throw new Exception("No employee available");
		
		Employee e = employeesAvailable.get(0);
		_instance.employees.remove(e);
		e.takeCall();
		System.out.println(e.getName() + " got the call");
		_instance.employees.add(e);

	}
	
	public List<Employee> sortEmployees(){
		Collections.sort(_instance.employees);
		return _instance.employees;
	}

}
