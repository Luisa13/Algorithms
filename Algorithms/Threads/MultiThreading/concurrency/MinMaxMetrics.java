package MultiThreading.concurrency;

import java.util.Random;

import MultiThreading.concurrency.AtomicOperations.Metrics;

/**
 * This exercise simulates an analytics which will be used to keep the track o the minimum and maximum of 
 * a business focused on stock prices.
 * 
 * </br></br>
 * This exercise has been extracted from the course Java Multithreading, Concurrency & Performance 
 * Optimization, instructed by Michael Progrebinsky through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class MinMaxMetrics {
	public static void main(String[] args) {
		MinMax metrics = new MinMax();
		TradingStock thread1 = new TradingStock(metrics);
		TradingStock thread2 = new TradingStock(metrics);
		PrintMetrics printer = new PrintMetrics(metrics);
		
		thread1.start();
		thread2.start();
		printer.start();
	}
	
	/**
	 * Prints the metrics in a single thread.
	 * */
	public static class PrintMetrics extends Thread{
		MinMax metrics = new MinMax();
		public PrintMetrics(MinMax metrics){
			this.metrics = metrics;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long min = this.metrics.getMin();
				long max = this.metrics.getMax();
				System.out.println("Min: " + min + " Max: " + max);
			}
			
		}
	}
	
	/**
	 * Keeps track of the maximum and minimum of the stock in a daily basis.
	 * */
	public static class TradingStock extends Thread{
		private Random random = new Random();
		private MinMax minMaxMetrics;
		
		public TradingStock(MinMax minMaxMetrics){
			this.minMaxMetrics = minMaxMetrics;
		}
		
		@Override
		public void run() {
			long start = System.currentTimeMillis();
			try {
				Thread.sleep(random.nextInt(20));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			this.minMaxMetrics.addSample(end-start);
		}
	}
	
	/**
	 * Get the performance (storing min and max values) of a particular business
	 * 
	 * */
	public static class MinMax{
		private volatile long min = 0;
		private volatile long max = 0;
		
		public MinMax(){
			this.min = Long.MIN_VALUE;
			this.max = Long.MAX_VALUE;
		}
		
		/**
		 * Adds a new sample to the metrics
		 * */
		public synchronized void addSample(long newSample) {
			this.min = Math.min(newSample, this.min);
			this.max = Math.max(newSample, this.max);
		}
		
		/**
		 * Gets the minimum stored value
		 * */
		public long getMin() {
			return this.min;
		}
		
		/**
		 * Gets the maximum stored value
		 * */
		public long getMax() {
			return this.max;
		}
	}
	

}
