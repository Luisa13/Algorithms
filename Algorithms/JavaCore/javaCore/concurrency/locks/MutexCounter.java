package javaCore.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A counter is accessed by different threads and guarantees the result. It is
 * implemented using mutexes to avoid race condition.
 * 
 * With a mutex, only one thread is allowed to enter in the critical section.
 */
public class MutexCounter {
	private static final int NUMBER_THREADS = 6;
	
	public static void main(String arg[]) {
		final Counter counter = new Counter();
		List<ThreadManager> threads = new ArrayList<>();
		
		for(int i =0; i<NUMBER_THREADS; i++) {
			threads.add(new ThreadManager(counter));
		}
		
		for(Thread thread: threads)
			thread.start();
		
	}

	public static class Counter {
		private int value;
		private Lock mutex;

		public Counter() {
			this.value = 0;
			this.mutex = new ReentrantLock();
		}

		public void increment() {
			try {
				this.mutex.lock();
				this.value++;
				System.out.println("The value increased to " + this.value);
			} finally {
				this.mutex.unlock();
			}
		}

		public int getValue() {
			return this.value;
		}
	}

	public static class ThreadManager extends Thread {
		private Counter counter;

		public ThreadManager(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			while (true) {
				try {
					this.counter.increment();
					this.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
