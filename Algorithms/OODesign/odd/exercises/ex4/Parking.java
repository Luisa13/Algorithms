package odd.exercises.ex4;

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
	
	public Parking getInstance(int nSections, int nLots) {
		if(instance == null)
			instance = new Parking(nSections, nLots);
		
		return instance;
	}
	
	public Ticket enterACar(Car car) {
		
	}
	
	public void parkACar() {
		
	}
	
	public float getPrice() {
		
	}
	
	public void exitACar() {
		
	}
	
	public boolean isSomePlaceAvailable() {
		
	}
	
	public Section getSectionOfCar(Car car) {
		
	}
	
	
	
}
