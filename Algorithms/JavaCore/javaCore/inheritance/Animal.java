package javaCore.inheritance;

public class Animal {
	private int weight;
	private int strenght;
	
	private String makeASound() {
		return "Hi, Im a animal and of course I can talk";
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void foo() {
		System.out.print("Im an Animal!!\n");
	}
}

