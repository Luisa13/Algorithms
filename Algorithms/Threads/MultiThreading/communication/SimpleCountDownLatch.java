package MultiThreading.communication;

/**
 * Implements a simple version of CountDownLatch which manages a count down. Allows 
 * one or more thread to wait until a set of operations performing in other threads 
 * are done. 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class SimpleCountDownLatch {

	private static final int LIMIT = 10;
	public static void main(String[] args) {
		CountDownLatch countDown = new CountDownLatch(LIMIT);
		Thread thread1 = new Thread(new CountDownRunner(countDown));
		Thread thread2 = new Thread(new CountDownRunner(countDown));
	}
	
	public static class CountDownRunner implements Runnable {
		private CountDownLatch countDown;
		
		public CountDownRunner(CountDownLatch countDown) {
			this.countDown = countDown;
		}
		
		@Override
		public void run() {
			while(true) {
				this.countDown.countDown();
				int count = this.countDown.getCount();
				System.out.println("Current count: " + count);
			}
		}
	}
	
	public static class CountDownLatch{
	
		private int count;
		public CountDownLatch(int count) {
			this.count = count;
			if(this.count < 0)
				System.out.println("The value of the counter must be a positive integer");
		}
		
		/**
		 * Makes the current threads wait until the latch has counted down to zero.
		 * */
		public void await() throws InterruptedException {
			while(this.count > 0) {
				this.wait();
			}
		}
		
		/**
		 * Decrements the count of the latch.
		 * */
		public void countDown() {
			if(this.count > 0) {
				this.count --;
				if(this.count == 0)
					this.notify();
			}
		}
		
		public int getCount() {
			return this.count;
		}
	}

}
