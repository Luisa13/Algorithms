package odd.exercises.ex4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Section {
	
	private Set<Car> cars;
	private int MAXSIZE;
	private String sectionName;
	
	public Section(int nLots) {
		this.cars = new HashSet<Car>();
		this.MAXSIZE = nLots;
	}
	
	public Set<Car> getCars(){
		return this.cars;
	}
	
	public boolean isFull() {
		return this.cars.size() >= this.MAXSIZE;
	}
	
	public boolean contains(Car car) {
		return this.cars.contains(car);
	}
	
	public void addCar(Car car) throws Exception {
		if(! isFull()) 
			this.cars.add(car);
		else
			throw new Exception("The parking lot is full");
	}
	
	public void remove(Car car) {
		
	}
	
	public Car getCar() {
		
	}
	
	public List<Car> getSortedCar() {
		
	}
	
	

}
