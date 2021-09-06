package MultiThreading.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Represents a database to store some sort of items with the associated price and simulates a situation 
 * where a thread is writing on it (by adding item prices) and several readers are accessing to the same 
 * resource concurrently performing 1000 operations each one. The exercise uses both, the Reentrant lock
 * and the ReentrantReadWrite lock to protect the data and prevent race conditions, and shows how the second
 * one overperforms the first one by getting 3 times faster.
 * Both versions are actually implemented, just comment or uncomment those that one to try.
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class ItemInventory {

	private static final int HIGHTES_PRICE = 100;
	private static final int NUMBER_READER = 7;
	private static final int NUMBER_OPERATIONS = 10000;
	
	public static void main(String[] args) throws InterruptedException {
		InventoryDatabase inventory = new InventoryDatabase();
		Random random = new Random();
		
		// Populates the tree with random objects with a limit for the price
		for(int i = 0; i< NUMBER_OPERATIONS; i++) {
			inventory.addItem(random.nextInt(HIGHTES_PRICE));
		}
		
		// Thread to write in the inventory
		Thread writer = new Thread(() ->{
			while(true) {
				inventory.addItem(random.nextInt(HIGHTES_PRICE));
				inventory.removeItem(random.nextInt(HIGHTES_PRICE));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		writer.setDaemon(true);
		writer.start();
		
		// Threads that will read from the resource
		List<Thread> readers = new ArrayList<>();
		
		for(int readerIndex = 0; readerIndex < NUMBER_READER; readerIndex ++) {
			Thread reader = new Thread(()->{
				for(int i = 0; i< NUMBER_OPERATIONS; i++) {
					int upperBound = random.nextInt(HIGHTES_PRICE);
					int lowerBound = upperBound > 0 ? random.nextInt(upperBound) : 0;
					int countPrice = inventory.getNumItemsInPriceRange(lowerBound, upperBound);
				}
			});
			
			reader.setDaemon(true);
			readers.add(reader);
		}
		
		// Metrics
		long startTime = System.currentTimeMillis();
		
		for(Thread reader: readers) 
			reader.start();
		
		for(Thread reader: readers) 
			reader.join();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total time: " + (endTime - startTime) + " ms");
	}

	/**
	 * Simulates a database that store items with their corresponding price. A TreeMap is 
	 * used as a data structure to keep the items and the count for each one.
	 * 
	 * */
	public static class InventoryDatabase {
		private TreeMap<Integer, Integer> priceCount = new TreeMap<>();
		// Uncomment to see the performance of standard lock
		// private ReentrantLock lock = new ReentrantLock(); 							// Standard lock
		
		// Uncomment this section to see the performance of readWriteLock
		private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();   //Read Write lock
		private Lock write = this.readWriteLock.writeLock();
		private Lock read = this.readWriteLock.readLock();

		/**
		 * Returns the number of items that belongs to a specific price range given in
		 * the parameters.
		 * 
		 * @param int Lower bound.
		 * @param int Upper bound.
		 * @return int Total sum of items
		 */
		public int getNumItemsInPriceRange(int lowerBound, int upperBound) {
			// lock.lock();
			this.read.lock();
			try {

				Integer fromKey = this.priceCount.ceilingKey(lowerBound);
				Integer toKey = this.priceCount.floorKey(upperBound);
				if (fromKey == null || toKey == null)
					return 0;

				NavigableMap<Integer, Integer> rangePrices = this.priceCount.subMap(fromKey, true, toKey, true);

				int sum = 0;
				for (int numItemsForPrice : rangePrices.values()) {
					sum += numItemsForPrice;
				}

				return sum;
			} finally {
				// lock.unlock();
				this.read.unlock();
			}
		}

		/**
		 * Adds an item.
		 * @param int Price item to add
		 */
		public void addItem(int price) {
			// lock.lock();
			this.write.lock();
			try {

				Integer numOfItems = this.priceCount.get(price);

				if (numOfItems == null)
					this.priceCount.put(price, 1);
				else
					this.priceCount.put(price, numOfItems + 1);
			} finally {
				// lock.unlock();
				this.write.unlock();
			}
		}

		/**
		 * Removes an item.
		 * @param int Price item to remove
		 */
		public void removeItem(int price) {
			// lock.lock();
			this.write.lock();
			try {
				Integer numOfItems = this.priceCount.get(price);

				if (numOfItems == null || numOfItems == 1)
					this.priceCount.remove(price);
				else
					this.priceCount.put(price, numOfItems - 1);
			} finally {
				// lock.unlock();
				this.write.unlock();
			}
		}
	}
}
