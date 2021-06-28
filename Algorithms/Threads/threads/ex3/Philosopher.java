package threads.ex3;

public class Philosopher implements Runnable{
	private String name;
	private Chopstick chopstick;
	
	public Philosopher(Chopstick chopstick, String name) {
		this.chopstick = chopstick;
		this.name = name;
	}
	
	public void run() {
		try {
			this.chopstick.take(name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
