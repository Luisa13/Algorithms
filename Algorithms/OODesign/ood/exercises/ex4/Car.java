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
		return Long.compare(this.arrivalTime, o.arrivalTime);
	}
}
