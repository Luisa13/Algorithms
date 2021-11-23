package javaCore.concurrency.synchronize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Implements the producer-consumer problem using the synchronize keyword. In
 * this problem two threads are trying to access to a shared resource (a queue)
 * where they add or pop elements respectively.
 * 
 * @author luisa
 */
public class ProducerConsumer {

	public static void main(String[] args) {
		final Queue<Integer> queue = new LinkedList<>();
		Thread producerThread = new Producer(queue);
		Thread consumerThread = new Consumer(queue);

		producerThread.start();
		consumerThread.start();
		try {
			producerThread.join();
			consumerThread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static class Producer extends Thread {
		Queue<Integer> queue;

		public Producer(Queue<Integer> queue) {
			this.queue = queue;
		}

		public void run() {
			Random random = new Random();
			while (true) {
				int value = random.nextInt(10);
				synchronized (queue) {
					this.queue.add(value);
					System.out.println("Producer add: " + value);
				}
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static class Consumer extends Thread {
		Queue<Integer> queue;

		public Consumer(Queue<Integer> queue) {
			this.queue = queue;
		}

		public void run() {
			while (true) {
				int value = -1;
				synchronized (queue) {
					if (!this.queue.isEmpty()) {
						value = this.queue.poll();
						System.out.println("Consumer consumed: " + value);
					}
				}
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
