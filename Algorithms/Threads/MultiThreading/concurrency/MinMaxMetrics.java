package MultiThreading.concurrency;

import java.util.Random;

import MultiThreading.concurrency.AtomicOperations.Metrics;

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
	
	public static class MinMax{
		private volatile long min = 0;
		private volatile long max = 0;
		
		public MinMax(){
			this.min = Long.MIN_VALUE;
			this.max = Long.MAX_VALUE;
		}
		
		public synchronized void addSample(long newSample) {
			this.min = Math.min(newSample, this.min);
			this.max = Math.max(newSample, this.max);
		}
		
		public long getMin() {
			return this.min;
		}
		
		public long getMax() {
			return this.max;
		}
	}
	

}
