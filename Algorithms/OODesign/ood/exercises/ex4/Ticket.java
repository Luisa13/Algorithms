package ood.exercises.ex4;

public class Ticket {
	
	private String carPlate;
	private Long arrivalTime;

	public Ticket(String carPlate, Long arrivalTime) {
		this.carPlate = carPlate;
		this.arrivalTime = arrivalTime;
	}
	
	public String getCarPlate() {
		return this.carPlate;
	}
	
	public Long getArrivalTime() {
		return this.arrivalTime;
	}
}
