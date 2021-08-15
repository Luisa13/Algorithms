package MultiThreading.coordination;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

/**
 * This class performs an operation which is computationally heavy and might take some time. Hence, 
 * in order to provide a result after (and only after) the threads that makes these calculations are
 * done, we need to coordinate them. To do so, we need to make sure the program that execute them will
 * wait for them.
 * 
 * This exercise has been extracted from the course Java Multithreading, Concurrency & Performance 
 * Optimization, instructed by Michael Progrebinsky through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class PowerBase {

	public static void main(String[] args) {
		BigInteger result = BigInteger.ZERO;
		PowerCalculatingThread thread1 = new PowerCalculatingThread(BigInteger.valueOf(3), BigInteger.valueOf(80));
		PowerCalculatingThread thread2 = new PowerCalculatingThread(BigInteger.valueOf(7), BigInteger.valueOf(9));
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("An error ocurred: " + e.getMessage());
		}
		
		if(thread1.isFinished() && thread2.isFinished())
			System.out.println("Both threads have finished!");
			
		result = thread1.getResult().add( thread2.getResult() );
		
		System.out.println("The result is: " + result.toString()); 
	}
	
	
	public static class PowerCalculatingThread extends Thread{
		
		private BigInteger result = BigInteger.ONE;
		private BigInteger power;
		private BigInteger base;
		
		public PowerCalculatingThread(BigInteger power, BigInteger base){
			this.base = base;
			this.power = power;
		}
		
		public boolean isFinished() {
			return result != BigInteger.ONE;
		}
		
		@Override
		public void run() {
			System.out.println("A new thread is starting...");
			
			while( !power.equals(BigInteger.ZERO) ) {
				this.result = this.result.multiply(this.base);
				power = power.subtract(BigInteger.ONE);
				
			}
		}
		
		public BigInteger getResult() {
			return this.result;
		}
	}
}
