package MultiThreading.concurrency;

/**
 * This class illustrates how a data race is produced when two threads get access to a shared resource.
 * Despite the threads access to different methods, the data might be modified in different order. In 
 * order to prevent that, these pieces of code must be protected by volatile keyword.
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class DataRace {
	
	public static void main(String[] args) {
		SharedResource object = new SharedResource();
		Thread thread1 = new Thread(() ->{
			for(int i = 0; i<Integer.MAX_VALUE; i++)
				object.increment();
		});
		
		Thread thread2 = new Thread(() ->{
			for(int i = 0; i<Integer.MAX_VALUE; i++)
				object.checkDataRace();
		});
		
		thread1.start();
		thread2.start();
	}

	public static class SharedResource {
		// Uncomment to protect the operations order and prevent from data race 
		
		private volatile long  x = 0;
		private volatile long y = 0;
		
		// Uncomment to get a data race
		
		// private long  x = 0;
		// private long y = 0;

		public void increment() {
			x++;
			y++;
		}

		public void checkDataRace() {
			if (y > x)
				System.out.println("Data Race detected: y (" + y + ") is larger than x (" + x + ")");
		}
	}
}
