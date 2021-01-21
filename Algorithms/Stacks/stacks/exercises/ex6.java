package stacks.exercises;

import java.util.Date;

import stack.Stack;
import stacks.exercises.ex4.MyQueue;

public class ex6 {
	
	/**
	 * Simulates a system that store dogs and cats in order to be adopted 
	 * strictly in time arrival order. That means only can be adopted the 
	 * oldest animal.
	 * 
	 * @author luisa
	 * */
	public static class Shetter{
		
		/**
		 * Cats that are stored in the system. They are defined by the 
		 * name and the arrival time
		 * 
		 * */
		public static class Cat{
			Date arrivalDate;
			String name;
			
			public Cat(Date date, String name) {
				this.arrivalDate = date;
				this.name = name;
			}
			
			public String name() {
				return this.name;
			}
		}
		
		/**
		 * Dogs that are stored in the system. They are defined by the 
		 * name and the arrival time
		 * 
		 * */
		public static class Dog{
			Date arrivalDate;
			String name;
			
			public Dog(Date date, String name) {
				this.arrivalDate = date;
				this.name = name;
			}
			
			public String name() {
				return this.name;
			}
			
		}
		// Store all the cats in time arrival order
		MyQueue<Cat> cats = new MyQueue<Cat>();
		// Store all the dogs in time arrival order
		MyQueue<Dog> dogs = new MyQueue<Dog>(); 
		
		/**
		 * Push an animal(either cat or dog) into the system
		 * 
		 * @param animal Object type Cat or Dog to be pushed into the system
		 * */
		public <T> void enqueue(T animal) {
			if(animal instanceof Dog) {
				this.enqueueDog( ((Dog) animal).name);
			}else if(animal instanceof Cat) {
				this.enqueueCat( ((Cat) animal).name);
			}
		}
		
		/**
		 * Push a dog into the system
		 * 
		 * @param name String making reference to the name of the dog
		 * */
		public void enqueueDog(String name){
			Date date = new Date();
			Dog newDog = new Dog(date, name);
			dogs.push(newDog);
		}
		
		/**
		 * Push a cat into the system
		 * 
		 * @param name String making reference to the name of the cat
		 * */
		public void enqueueCat(String name) {
			Date date = new Date();
			Cat newCat = new Cat(date, name);
			cats.push(newCat);
		}
		
		/**
		 * Pull out the oldest animal between the two queues
		 * */
		@SuppressWarnings("unchecked")
		public <T> T dequeueAny() {
			if(dogs.peek().arrivalDate.after(cats.peek().arrivalDate))
				return (T) dogs.top();
			else
				return (T) cats.top();
		}
		
		/**
		 * Pull out a dog from the queue
		 * */
		public Dog dequeueDog() {
			return dogs.top();
		}
		
		/**
		 * Pull out a cat from the queue
		 * */
		public Cat dequeueCat() {
			return cats.top();
		}
		
		/**
		 * Returns the number of cats left
		 * */
		public int howManyCats() {
			return this.cats.size();
		}
		
		/**
		 * Returns the number of dogs left
		 * */
		public int howManyDogs() {
			return this.dogs.size();
		}
		
	}
}
