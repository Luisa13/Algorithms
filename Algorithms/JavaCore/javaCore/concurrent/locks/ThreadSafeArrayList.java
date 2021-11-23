package javaCore.concurrent.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Implements a thread safe array list that is accessed by 6 threads to read and
 * write on it simultaneously. The threads will perform operations into the data
 * structure until no end, and when a Reader Thread tries to access the array
 * when it's empty, will just print the error and keep going as usual.
 * 
 * @author luisa
 * 
 */
public class ThreadSafeArrayList {
	private final static int TIME_TO_SLEEP = 1000;
	private final static int NUMBER_THREADS = 6;

	public static void main(String[] args) {

		if (NUMBER_THREADS < 2) {
			System.out.println("Error: Number of threads should be above 2");
			return;
		}

		Thread[] threads = new Thread[NUMBER_THREADS];
		final ConcurrentArrayList<Integer> arr = new ConcurrentArrayList<Integer>();

		for (int i = 0; i < threads.length; i += 2) {
			threads[i] = new Writter(arr);
			threads[i + 1] = new Reader(arr);
			System.out.println("Thread Writer " + threads[i].getName() + " just started");
			threads[i].start();
			System.out.println("Thread Reader " + threads[i + 1].getName() + " just started");
			threads[i + 1].start();
		}
	}

	/**
	 * Thread that write on a thread safe array
	 */
	public static class Writter extends Thread {
		private final ConcurrentArrayList<Integer> array;

		public Writter(ConcurrentArrayList<Integer> array) {
			this.array = array;
			this.setName("Writter" + this.getName());
		}

		@Override
		public void run() {
			Random r = new Random();
			String name = this.currentThread().getName();

			while (true) {
				int value = r.nextInt(100);
				System.out.println(name + ": Writting ...");
				System.out.println("\t" + name + ": Size of the array: " + this.array.size());
				try {
					r = new Random();
					this.array.add(value);
					System.out.println("\t" + name + "-> Write the value: " + value);
					Thread.sleep(TIME_TO_SLEEP);

				} catch (InterruptedException e) {
					System.out.println("Error at writing: " + e.getMessage());
				}
			}

		}
	}

	/**
	 * Thread that read from a thread safe array
	 * 
	 */
	public static class Reader extends Thread {

		private final ConcurrentArrayList<Integer> array;

		public Reader(ConcurrentArrayList<Integer> array) {
			this.array = array;
			this.setName("Reader" + this.getName());
		}

		@Override
		public void run() {
			String name = this.currentThread().getName();

			while (true) {
				try {
					System.out.println(name + ": Reading ...");
					System.out.println("\t" + name + ": Size of the array: " + this.array.size());
					Integer value = this.array.peek();
					System.out.println("\t" + name + "-> Read the value: " + value);
					Thread.sleep(TIME_TO_SLEEP);

				} catch (InterruptedException e) {
					System.out.println("Error at reading: " + e.getMessage());

				}
			}
		}
	}

	/**
	 * Thread safe version of ArrayList
	 * 
	 */
	public static class ConcurrentArrayList<T> {
		private List<T> data;
		private Lock writeLock;
		private Lock readLock;

		public ConcurrentArrayList() {
			this.data = new ArrayList<T>();
			ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
			this.writeLock = rrwl.writeLock();
			this.readLock = rrwl.readLock();
		}

		/**
		 * Read the last element of the list
		 * 
		 */
		public T peek() {
			this.readLock.lock();
			try {
				return this.data.get(this.data.size() - 1);
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("Error reading empty array: " + ex.getMessage());
				return null;
			} finally {
				this.readLock.unlock();
			}
		}

		/**
		 * Add a value to the list
		 * 
		 */
		public void add(T value) {
			this.writeLock.lock();
			try {
				this.data.add(value);

			} finally {
				this.writeLock.unlock();
			}
		}

		public int size() {
			return this.data.size();
		}
	}
}
