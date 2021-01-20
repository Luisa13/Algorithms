package stacks.exercises;

import java.util.Date;

import Stack.Stack;
import stacks.exercises.ex4.MyQueue;

public class ex6 {
	public static class Shetter{
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
		MyQueue<Cat> cats = new MyQueue<Cat>();
		MyQueue<Dog> dogs = new MyQueue<Dog>(); 
		
		public <T> void enqueue(T animal) {
			if(animal instanceof Dog) {
				this.enqueueDog(((Dog) animal).arrivalDate, ((Dog) animal).name);
			}else if(animal instanceof Cat) {
				this.enqueueCat(((Cat) animal).arrivalDate, ((Cat) animal).name);
			}
		}
		
		public void enqueueDog(Date date, String name){
			Dog newDog = new Dog(date, name);
			dogs.push(newDog);
		}
		
		public void enqueueCat(Date date, String name) {
			Cat newCat = new Cat(date, name);
			cats.push(newCat);
		}
		
		public <T> T dequeueAny() {
			if(dogs.peek().arrivalDate.after(cats.peek().arrivalDate))
				return (T) dogs.top();
			else
				return (T) cats.top();
		}
		
		public Dog dequeueDog() {
			return dogs.top();
		}
		
		public Cat dequeueCat() {
			return cats.top();
		}
	}
}
