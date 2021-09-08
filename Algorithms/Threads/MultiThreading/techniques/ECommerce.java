package MultiThreading.techniques;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Manages an inventory which is controlled by two threads will increment or decrement its corresponding storage.
 * This exercise exposes the use of AtomicInteger class to protect atomic operations.
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class ECommerce {
	
	public static final int N = 1000;
	public static void main(String[] args) throws InterruptedException {
		Inventory inventoryCounter = new Inventory();
		
		Decrement decrementer = new Decrement(inventoryCounter);
		Increment incrementer = new Increment(inventoryCounter);
		
		incrementer.start();
		decrementer.start();
		
		incrementer.join();
		decrementer.join();
		
		System.out.print("We currently have: " + inventoryCounter.getItems());
	}
	
	public static class Increment extends Thread{
		private Inventory inventory;
		
		public Increment(Inventory i ) {
			this.inventory = i;
		}
		
		@Override
		public void run() {
			for(int i = 0; i<N; i ++) {
				this.inventory.increment();
			}
		}
	}
	
	public static class Decrement extends Thread{
		private Inventory inventory;
		
		public Decrement(Inventory i ) {
			this.inventory = i;
		}
		
		@Override
		public void run() {
			for(int i = 0; i<N; i++) {
				this.inventory.decrement();
			}
		}
	}
	// TRADITIONAL VERSION - Uncomment to get back to the good old days
	//
	/*public static class Inventory{
		private int items = 0;
		
		public synchronized void increment() {
			this.items ++;
		}
		
		public synchronized void decrement() {
			this.items --;
		}
		
		public int getItems() {
			return this.items;
		}
	}*/
	
	// ATOMIC INTEGER VERSION
	public static class Inventory{
		private AtomicInteger items = new AtomicInteger(0);
		
		public void increment() {
			this.items.incrementAndGet();
		}
		
		public void decrement() {
			this.items.decrementAndGet();
		}
		
		public int getItems() {
			return this.items.get();
		}
	}
	
}
