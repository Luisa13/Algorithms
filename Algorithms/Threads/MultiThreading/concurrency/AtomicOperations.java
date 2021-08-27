package MultiThreading.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Capture metrics of an operation without interfering in such operations on the background. This is a 
 * sample where it can be observed how to synchronize blocks of code when you have an operation which 
 * should be atomized. Such operation will be performed by the class Metrics and run by the thread of 
 * BusinessLogic class. Regarding the methods in Metrics, many threads could potentially access to them 
 * adding more samples and therefore get nonsense results. That's why we need to secure those operations to 
 * be thread safe.
 * The expected behavior is an average of ~5 ms plus a few ms of thread waking up, add the sample...
 * 
 * </br></br>
 * This exercise has been extracted from the course Java Multithreading, Concurrency & Performance 
 * Optimization, instructed by Michael Progrebinsky through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class AtomicOperations {

	public static void main(String[] args) {
		Metrics metrics = new Metrics();
		BusinessLogic thread1 = new BusinessLogic(metrics);
		BusinessLogic thread2 = new BusinessLogic(metrics);
		MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
		
		thread1.start();
		thread2.start();
		metricsPrinter.start();
	}
	
	/**
	 * Will print the average on the screen
	 * */
	public static class MetricsPrinter extends Thread{
		
		private Metrics metrics;
		
		public MetricsPrinter( Metrics metrics) {
			this.metrics = metrics;
		}
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				double currentAvg = metrics.getAverage();
				System.out.println(this.getName() + ". Current AVG: " + currentAvg);
			}
		}
	}
	
	/**
	 * Run the metrics in an isolated thread.
	 * 
	 * */
	public static class BusinessLogic extends Thread{
		private Random random = new Random();
		private Metrics metrics;
		
		public BusinessLogic(Metrics metrics) {
			this.metrics = metrics;
		}
		
		@Override
		public void run() {
			long start = System.currentTimeMillis();
			try {
				Thread.sleep(random.nextInt(10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long end  = System.currentTimeMillis();
			this.metrics.addSample(end - start);
		}
	}
	
	/**
	 * Simulates an operation which takes from 0 to 10 ms to get done
	 * 
	 * */
	public static class Metrics{
		private long count = 0;
		private volatile double average  = 0.0;
		
		/**
		 * Add a sample. 
		 * Is a synchronized methods since different threads might access to it
		 * and modify the result.
		 * @param long
		 * */
		public synchronized void addSample(long sample) {
			double currentSum = this.average * this.count;
			this.count ++;
			this.average = (currentSum + sample)/count;
		}
		
		/**
		 * Gets the average.
		 * There is no need to synchronize this method because it's an assigment
		 * but since the data is a long type, we should mark it as volatile to be 
		 * thread safe
		 * */
		public double getAverage() {
			return this.average;
		}
	}
}
