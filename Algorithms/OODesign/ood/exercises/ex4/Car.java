package ood.exercises.ex4;

import java.util.Date;

/**
 * Represents a car defined mainly by the plate as identity attribute and the brand. 
 * Once the car gets into the parking system, is assigned an arrival time automatically.
 * 
 * @author luisa
 * */
public class Car implements Comparable<Car> {

	private String plate;
	private String brand;
	private long arrivalTime;
	
	public Car(String plate, String brand) {
		this.plate = plate;
		this.brand = brand;
		this.arrivalTime = 0;
	}
	
	public String getPlate() {
		return this.plate;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public long getArrivalTime() {
		return this.arrivalTime;
	}
	
	public void setArrivalTime() {
		this.arrivalTime =System.currentTimeMillis();
	}
	
	@Override
	public int compareTo(Car o) {
		return Long.compare(arrivalTime, o.arrivalTime);
	}
	
	@Override
	public int hashCode() {
		return this.plate.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		
		Car car = (Car) obj;
		return this.brand.equals(car.brand) &&
				this.plate == car.plate &&
				this.arrivalTime == car.arrivalTime;
		
	}
	
	@Override
	public String toString() {
		return plate + "  " + brand;
	}
}
