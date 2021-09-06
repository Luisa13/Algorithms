package MultiThreading.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * When running tasks by multiple threads concurrently, sometimes we would like to coordinate 
 * the work to guarantee that some portion of the work is done by all threads before the rest 
 * of the work is performed. The order of the execution of each part is not important. But we 
 * want to make sure that all threads finish part1 before any thread can go ahead and perform 
 * part2 (see the task method).
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class BarrierSemaphore {
	private static final int NUMBER_THREADS = 200; 
	
	public static void main(String[] args) {
		 
	    List<Thread> threads = new ArrayList<>();
	    Barrier barrier = new Barrier(NUMBER_THREADS);
	    for(int i = 0; i< NUMBER_THREADS; i++) {
	    	threads.add(new Thread(new CoordinatedWorkRunner(barrier)));
	    }
	    
	    for(Thread thread: threads)
	    	thread.start();
	}

	/**
	 * Guarantees the order of operation when acquiring a resource. To do so, semaphore is initialized
	 * with 0 value to make sure every thread that tries to acquire the resource gets blocked. It keeps
	 * all the thread that access it, and release them all at once when the last one arrives.
	 * 
	 * */
	 private static class Barrier {
		private final int numberOfWorker;
		Semaphore semaphore = new Semaphore(0);
		private int counter = 0;
		private Lock lock = new ReentrantLock();

		public Barrier(int numberOfWorker) {
			this.numberOfWorker = numberOfWorker;
		}

		public void barrier() {
			lock.lock();
			boolean lastWorker = false;
			try {
				this.counter ++;
				if(this.counter == this.numberOfWorker)
					lastWorker = true;

			} finally {
				lock.unlock();
			}
			
			if(lastWorker) {
				this.semaphore.release(this.numberOfWorker -1 );
			}else {
				try {
					this.semaphore.acquire();
				}catch(InterruptedException ex) {
					System.out.println("Error acquiring a semaphore");
				}
			}
		}

	}

	 /**
	  * Coordinates all the threads that performs a task with the help of a barrier 
	  * class
	  * */
	public static class CoordinatedWorkRunner implements Runnable {

		private Barrier barrier;

		public CoordinatedWorkRunner(Barrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			this.task();
		}

		private void task() {
			// Performing part 1
			System.out.println( Thread.currentThread().getName() + " has finished part 1");
			this.barrier.barrier();
			// Performing part 2
			System.out.println( Thread.currentThread().getName() + " has finished part 2");
		}

	}
}
