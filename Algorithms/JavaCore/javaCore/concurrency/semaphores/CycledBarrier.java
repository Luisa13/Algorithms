package javaCore.concurrency.semaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implements a cycled barrier where it guarantees the order of the task accomplishing
 * 
 * @author luisa
 * */
public class CycledBarrier {
	private final static int NUM_THREAD = 10;

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		Barrier barrier = new Barrier(NUM_THREAD);
		System.out.println("===== START =====");
		
		for(int i=0; i< NUM_THREAD; i ++) {
			threads.add(new ThreadManager(barrier));
		}
		for(Thread thread: threads)
			thread.start();

	}

	public static class ThreadManager extends Thread {
		private Barrier barrier;
		
		public ThreadManager(Barrier barrier){
			this.barrier = barrier;
		}
		
		public void run() {
			while(true) {
				try {
					taskA();
					this.barrier.barrier();
					
					this.sleep(1000);
					taskB();
					this.barrier.barrier();
					this.sleep(1000);
					
				} catch (InterruptedException e) {
					System.out.print("Could not sleep after finishing task B");
				}
			}
			
		}
		
		private void taskA() {
			System.out.println(this.getName() + " just finished task A");
		}
		
		private void taskB() {
			System.out.println(this.getName() + " just finished task B");
		}

	}
	
	public static class Barrier{
		private int numberWorkers;
		private Semaphore semaphore;
		private int counter;
		Lock lock;
		
		public Barrier(int numberWorkers) {
			this.numberWorkers = numberWorkers;
			init();
		}
		
		private void init() {
			this.semaphore = new Semaphore(0);
			this.lock = new ReentrantLock();
			this.counter = 0;
		}
		
		public void barrier() {
			this.lock.lock();
			boolean lastWorker = false;
			
			try {
				this.counter ++;
				if(counter == numberWorkers)
					lastWorker = true;
			}finally {
				this.lock.unlock();
			}
			if(lastWorker) {
				System.out.println("All the threads are in the barrier. Releasing...");
				this.semaphore.release(numberWorkers -1);
				init();
			}else {
				try {
					this.semaphore.acquire();
				} catch (InterruptedException e) {
					System.out.print("Error acquiring the semaphore: " + e.getMessage());
				}
				
			}
		}
	}

}
