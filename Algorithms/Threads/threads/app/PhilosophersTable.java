package threads.app;
import threads.ex3.*;

public class PhilosophersTable {

	public static void main(String[] args) {
		Chopstick[] chopstick = new Chopstick[7];
		
		for(int i = 0; i<chopstick.length; i++){
			chopstick[i] = new Chopstick();
		}
		int c = 0;
		
		for(int i =0; i<=chopstick.length; i++) {
			Philosopher philosopher = new Philosopher(chopstick[c], Integer.toString(i));
			Thread thread = new Thread(philosopher);
			thread.start();
			c = (c+1)%4;
		}
		

	}

}
