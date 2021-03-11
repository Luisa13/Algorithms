package ood.exercises.ex4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicListUI;

/**
 * Represents a section  parking lots available to park.
 * @author luisa
 * */
public class Section {
	
	private Set<Car> cars;
	private int MAXSIZE;
	private String sectionName;
	
	public Section(int nLots) {
		this.cars = new HashSet<Car>();
		this.MAXSIZE = nLots;
	}
	
	/**
	 * Gets all the cars of the section
	 * 
	 * */
	public Set<Car> getCars(){
		return this.cars;
	}
	
	/**
	 * Returns true if the section is full and therefore there 
	 * is no more run for any other car. False otherwise
	 * 
	 * */
	public boolean isFull() {
		return this.cars.size() >= this.MAXSIZE;
	}
	
	/**
	 * Returns true if the section contains the car specified in the 
	 * parameter. False otherwise.
	 * 
	 * @param Car
	 * */
	public boolean contains(Car car) {
		return this.cars.contains(car);
	}
	
	/**
	 * Add a car to the section
	 * @param Car
	 * */
	public void  addCar(Car car) throws Exception {
		if(! isFull()) 
			this.cars.add(car);
		else
			throw new Exception("The parking lot is full");
	}
	
	/**
	 * Removes a car from the set
	 * @param Car
	 * */
	public void remove(Car car) {
		this.cars.remove(car);
	}
	
	/**
	 * Gets a car by the plate
	 * @param String
	 * */
	public Car getCar(String plate) {
		List<Car> list = new ArrayList<>();
		cars.stream()
		.filter((c) -> plate.equals(c.getPlate()) )
		.forEach((c) -> list.add(c) );
		
		if(list.isEmpty())
			return null;
		
		return list.get(0);
	}
	
	/**
	 * Gets a sorted list fo cars
	 * 
	 * */
	public List<Car> getSortedCar() {
		return this.cars.stream().collect(Collectors.toList());
	}
	
	

}
