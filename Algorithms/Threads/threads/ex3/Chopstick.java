package threads.ex3;

public class Chopstick {

	public synchronized void take(String name) throws InterruptedException {
		try {
			System.out.println("Philosopher " + name + ": take the chopstick");
			Thread.sleep(1000);
			System.out.println(name + ":  I just left it");
			
		}catch(InterruptedException ex) {
			throw new InterruptedException(ex.getMessage());
		}
	}
}
