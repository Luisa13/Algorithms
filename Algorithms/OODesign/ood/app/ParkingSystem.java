package ood.app;

import java.util.HashSet;
import java.util.Set;

import ood.exercises.ex4.Car;
import ood.exercises.ex4.Parking;
import ood.exercises.ex4.Ticket;

public class ParkingSystem {
	
	
	public static void main(String[] args) throws Exception {
		Parking parking = Parking.getInstance(3, 6);
		Car car1 = new Car("1234", "BMW");
		Car car2 = new Car("98654", "Mercedes");
		
		Ticket t = parking.enterACar(car2);
		parking.exitACar(car2, t);
		
	}

	
	
	


}
