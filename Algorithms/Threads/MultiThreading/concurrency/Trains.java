package MultiThreading.concurrency;

import java.util.Random;

/**
 * Simulates a situation where two trains take two different roads belonging to the same 
 * intersection. Each train is running in a different thread and takes a different road
 * of the same intersection, however, in the first version of this exercise, the situation
 * leads to a circular wait. To untie such deadlock, the locks must be taken in the same 
 * order between the threads.
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class Trains {

	public static void main(String[] args) {
		Intersection intersectionRoad = new Intersection();

		Thread threadTrain1 = new Thread(new Train1(intersectionRoad));
		Thread threadTrain2 = new Thread(new Train2(intersectionRoad));
		threadTrain1.setName("Thread-Train1");
		threadTrain2.setName("Thread-Train2");

		threadTrain1.start();
		threadTrain2.start();
	}

	/**
	 * Train 2 that takes a road A in a specific intersection
	 */
	public static class Train2 implements Runnable {
		private Intersection intersection;
		Random random = new Random();

		public Train2(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				int sleepTime = random.nextInt(10);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				intersection.takeRoadB();
			}
		}

	}

	/**
	 * Train 1 that takes a road B in a specific intersection
	 */
	public static class Train1 implements Runnable {
		private Intersection intersection;
		Random random = new Random();

		public Train1(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				int sleepTime = random.nextInt(10);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				intersection.takeRoadA();
			}
		}

	}

	/**
	 * Simulates the intersection between two roads.
	 * 
	 */
	public static class Intersection {
		private Object roadA = new Object();
		private Object roadB = new Object();

		// Uncomment for circular wait deadlock display
		/* 
		 * 
		 * private void takeRoadA() { synchronized (roadA) {
		 * System.out.println("Road A is locked by thread: " +
		 * Thread.currentThread().getName());
		 * 
		 * synchronized (roadB) {
		 * System.out.println("This train is passing through Road A"); try {
		 * Thread.sleep(200); }catch(InterruptedException ex) {
		 * System.out.println("An error happened taking the road A"); } } } }
		 */

		// Uncomment for circular wait prevention
		
		private void takeRoadA() {
			synchronized (roadB) {
				System.out.println("Road B is locked by thread: " + Thread.currentThread().getName());

				synchronized (roadA) {
					System.out.println("This train is passing through Road A");
					try {
						Thread.sleep(200);
					} catch (InterruptedException ex) {
						System.out.println("An error happened taking the road A");
					}
				}
			}
		}

		private void takeRoadB() {
			synchronized (roadB) {
				System.out.println("Road B is locked by thread: " + Thread.currentThread().getName());

				synchronized (roadA) {
					System.out.println("this train is passing through Road B");
					try {
						Thread.sleep(200);
					} catch (InterruptedException ex) {
						System.out.println("An error happened taking the road B");
					}
				}
			}
		}
	}
}
