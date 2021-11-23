package javaCore.concurrency.semaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Given two threads performing a set of tasks, guarantees the order in those
 * tasks or makes sure all the threads finish the task or part 1 before starting
 * the part 2, creating a barrier.
 * 
 * @author luisa
 */
public class SimpleBarrier {
	private final static int NUM_THREAD = 10;

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		Barrier barrier = new Barrier(NUM_THREAD);
		for(int i=0; i< NUM_THREAD; i ++) {
			threads.add(new ThreadManager(barrier));
		}
		for(Thread thread: threads)
			thread.start();
	}

	public static class ThreadManager extends Thread {
		private Barrier barrier;

		public ThreadManager(Barrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			this.taskA();
			this.barrier.barrier();
			this.taskB();
		}

		private void taskA() {
			System.out.println(this.getName() + " finish Task A");
		}

		private void taskB() {
			System.out.println(this.getName() + " finish Task B");
		}

	}

	public static class Barrier {
		private final int workerThreads;
		private Semaphore semaphore;
		private int counter;
		private Lock lock;

		public Barrier(int nWorker) {
			this.workerThreads = nWorker;
			this.semaphore = new Semaphore(0);
			this.counter = 0;
			this.lock = new ReentrantLock();
		}

		public void barrier() {
			this.lock.lock();
			boolean lastThread = false;
			try {
				this.counter++;
				if (this.counter == this.workerThreads)
					lastThread = true;
			} finally {
				this.lock.unlock();
			}

			if (lastThread) {
				System.out.println("All the threads are in the barrier. Releasing...");
				this.semaphore.release(this.workerThreads -1);
				
			} else {
				try {
					this.semaphore.acquire();

				} catch (InterruptedException e) {
					System.out.print("Error acquiring the semaphore: " + e.getMessage());
				}
			}
		}

	}
}
