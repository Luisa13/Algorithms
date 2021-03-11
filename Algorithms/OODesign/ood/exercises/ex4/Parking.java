package ood.exercises.ex4;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Parking lot system. The parking is divided in different sections 
 * where each section has a certain number of available lots which a car could occupy.
 * The system manage how many places are available, if the parking is full, and finally
 * accounting the corresponding tax.
 * 
 * This class is a singleton, cause is meant to be just one.
 * 
 * @author luisa
 * */
public class Parking {

	protected static Parking instance;
	private List<Section> sections;
	private int lotsAvailable;
	private final int TAX =10;
	

	private Parking(int nSections, int nLots) {
		this.sections = new ArrayList<Section>();
		
		for(int i = 0; i<nSections; i++) {
			Section section = new Section(nLots);
			sections.add(section);
		}
		this.lotsAvailable = nSections * nLots;
	}
	
	/**
	 * Gets a new instance of the parking system
	 * @param int
	 * @param int
	 * */
	public static Parking getInstance(int nSections, int nLots) {
		if(instance == null)
			instance = new Parking(nSections, nLots);
		
		return instance;
	}
	
	/**
	 * Gets a car into the parking and park it taking an available place off
	 * 
	 * @param Car
	 * @throws Exception 
	 * */
	public Ticket enterACar(Car car) throws Exception {
		Section section = instance.sections.get(0);
		int i = 0;
		
		while(section.isFull()) {
			section = instance.sections.get(i);
			i++;
		}
		car.setArrivalTime();
		Ticket ticket = new Ticket(car.getPlate(), car.getArrivalTime());
		instance.lotsAvailable --;
		
		// Update the state of the list
		section.addCar(car);
		instance.sections.remove(i);
		instance.sections.add(section);
		
		return ticket;

	}
	
	/**
	 * Gets price according to the time spent in the parking
	 * @param Ticket
	 * */
	public float getPrice(Ticket ticket) {
		long arrivalTime = ticket.getArrivalTime();
		float price = (System.currentTimeMillis() - arrivalTime) * instance.TAX;
		
		return price;
	}
	
	
	/**
	 * Gets a car out of the system
	 * @throws Exception 
	 * 
	 * */
	public void exitACar(Car car, Ticket ticket) throws Exception {
		if(ticket.getCarPlate() != car.getPlate() || ticket.getArrivalTime() != car.getArrivalTime()) {
			throw new Exception ("This car does not correspond to the ticket");
		}
		
		// Removes it from the corresponding section
		Section section = getSectionOfCar(car);
		instance.sections.remove(section);
		section.remove(car);
		instance.sections.add(section);
		
		instance.lotsAvailable ++;
		
	}
	
	public boolean isSomePlaceAvailable() {
		return instance.lotsAvailable > 0;
	}
	
	/**
	 * Gets the section where a car is parked
	 * @param Car
	 * */
	public Section getSectionOfCar(Car car) {
		for(Section section: instance.sections) {
			if(section.contains(car))
				return section;
		}
		
		System.out.println("Car not found in this parking");
		return null;
	}
	
	
	
}
