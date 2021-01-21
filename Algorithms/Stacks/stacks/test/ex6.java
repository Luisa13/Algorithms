package stacks.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import stacks.exercises.ex6.Shetter;
import stacks.exercises.ex6.Shetter.Cat;
import stacks.exercises.ex6.Shetter.Dog;

class ex6 {

	@Test
	void pushACat() {
		Shetter shetter = new Shetter();

		shetter.enqueueCat("pepe");
		shetter.enqueueCat("paco");
		
		assertTrue(shetter.howManyCats() != 0);
	}
	
	@Test
	void pushADog() {
		Shetter shetter = new Shetter();

		shetter.enqueueCat("pepe");
		shetter.enqueueCat("paco");
		shetter.enqueueDog("Marcelo");
		
		assertTrue(shetter.howManyDogs() != 0);
	}
	
	@Test
	void removeACatWhenCatsIsNotEmpty() {
		Shetter shetter = new Shetter();
		shetter.enqueueCat("pepe");// 1st cat
		shetter.enqueueCat("paco");// 2nd cat
		shetter.enqueueDog("Marcelo"); //1st dog
		
		assertTrue(shetter.dequeueCat().name() == "pepe");
	}
	
	@Test
	void removeADogWhenDogsIsNotEmpty() {
		Shetter shetter = new Shetter();
		shetter.enqueueCat("pepe");		// 1st cat
		shetter.enqueueCat("paco");		// 2nd cat
		shetter.enqueueDog("Marcelo"); 	// 1st dog
		shetter.enqueueDog("Boby"); 	// 2nd dog
		
		assertTrue(shetter.dequeueDog().name() == "Marcelo");
	}
	
	@Test
	void pushAnAnimalWhichIsACat() {
		Shetter shetter = new Shetter();
		Cat cat = new Cat(new Date(), "Mustaches");
		shetter.enqueue(cat);			// 1st cat
		shetter.enqueueCat("pepe");		// 2nd cat
		shetter.enqueueCat("paco"); 	// 3rd cat
		shetter.enqueueDog("Marcelo"); 	// 1st dog
		shetter.enqueueDog("Boby"); 	// 2nd dog
		
		assertTrue(shetter.howManyCats() == 3 && shetter.howManyDogs() == 2);
	}
	
	@Test
	void pushAnAnimalWhichIsADog() {
		Shetter shetter = new Shetter();
		shetter.enqueueCat("pepe");		// 1st cat
		shetter.enqueueCat("paco"); 	// 2nd cat
		Dog dog = new Dog(new Date(), "Mr.Banana");
		shetter.enqueue(dog); 			// 1st dog
		shetter.enqueueDog("Boby"); 	// 2nd dog
		
		assertTrue(shetter.howManyCats() == 2 && shetter.howManyDogs() == 2);
	}
	
	@Test
	void removeAnAnimal() {
		Shetter shetter = new Shetter();
		shetter.enqueueCat("pepe");		// 1st cat
		shetter.enqueueCat("paco");		// 2nd cat
		shetter.enqueueDog("Marcelo"); 	// 1st dog
		shetter.enqueueDog("Boby"); 	// 2nd dog
		shetter.dequeueAny(); // should be a cat
		
		assertTrue(shetter.howManyCats() < 2 && shetter.howManyDogs() == 2 );
	}
	
	@Test
	void removeAnimalWhenDogsAreEmpty() {
		
	}
	
	@Test
	void removeAnimalWhenCatsAreEmpty() {
		
	}

}
