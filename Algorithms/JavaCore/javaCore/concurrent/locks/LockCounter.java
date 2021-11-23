package javaCore.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement a counter which is accessed by different threads. The atomicy of
 * the operation is achieved by locks
 * 
 * @author luisa
 */
public class LockCounter {

	public static void main(String[] args) {
		Thread threads[] = new Thread[3];
		Lock lock = new ReentrantLock();
		Counter counter = new Counter(lock, 1, 10);
		
		for (int i = 0; i < threads.length; i++) {
			final ThreadManager threadManager = new ThreadManager(counter, "Thread_" + i);
			System.out.println("Thread " + threadManager.getName() + " into game");
			threads[i] = threadManager;
			threads[i].start();

		}

	}

	public static class ThreadManager extends Thread {
		private Counter counter;
		private final int max, min;
		private String name;

		public ThreadManager(Counter counter, String name) {
			this.counter = counter;
			this.name = name;
			this.max = this.counter.getMax();
			this.min = this.counter.getMin();
		}

		@Override
		public void run() {
			while (counter.getCount() <= this.max) {
				this.counter.increment();
				System.out.println("Counter increased: " + this.counter.getCount());
			}

			while (counter.getCount() >= this.min) {
				this.counter.decrement();
				System.out.println("Counter decreased: " + this.counter.getCount());
			}
		}

	}

	public static class Counter {
		private int count = 0;
		private final int min, max;
		private final Lock lock;

		public Counter(Lock lock, int min, int max) {
			this.lock = lock;
			this.max = max;
			this.min = min;
		}

		public void increment() {
			this.lock.lock();
			try {
				if (this.count <= this.max)
					this.count++;
			} finally {
				this.lock.unlock();
			}
		}

		public void decrement() {
			this.lock.lock();
			try {
				if (this.count >= this.min)
					this.count--;
			} finally {
				this.lock.unlock();
			}
		}

		public int getMax() {
			return this.max;
		}

		public int getMin() {
			return this.min;
		}

		public int getCount() {
			return this.count;
		}
	}
}
