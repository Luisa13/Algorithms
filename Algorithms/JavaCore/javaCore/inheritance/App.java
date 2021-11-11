package javaCore.inheritance;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		animal.foo();
		Dog dog = new Dog();
		dog.foo();
		
		animal = dog;
		animal.foo();
		//a.foo();

	}

}
