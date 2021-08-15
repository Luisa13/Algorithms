package MultiThreading.fundamentals;
import java.util.Random;


/**
 * This class simulates a situation where several hackers try to attack a certain system guessing 
 * the corresponding password by brutal force. On the other hand, the figure of a policeman will get 
 * into action after counting up to 10, and if the hackers are still trying to crack the password, 
 * the policeman will arrest them and save the system. Otherwise the hackers will run away with no 
 * consequences.
 * 
 * This exercise has been extracted from the course Java Multithreading, Concurrency & Performance 
 * Optimization, instructed by Michael Progrebinsky through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class Hackers {
	private final static int MAXPASSWORD = 9999;

	public static void main(String[] args) {
		BlackBox vault = new BlackBox();
		AscendingHacker hacker1 = new AscendingHacker("Ascending Hacker", vault);
		DescendingHacker hacker2 = new DescendingHacker("Descending Hacker", vault);
		PoliceThread police = new PoliceThread();
		
		hacker1.start();
		hacker2.start();
		police.start();
		
	}
	
	/**
	 * This class represents the vault that remains locked under a password which has been set 
	 * randomly when the object is created.
	 * 
	 * */
	private static class BlackBox{
		
		private int password;
		
		public BlackBox() {
			Random random = new Random();
			this.password = random.nextInt(MAXPASSWORD + 1);
		}
		
		/**
		 * Opens the system if it is provided by the right password. It actually takes 
		 * 5 milliseconds to check if the given password is correct or not. 
		 * Returns true if it's correct, and false otherwise.
		 * 
		 * @param int
		 * @return boolean
		 * 
		 * */
		public boolean open(int password) {
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Something went wrong while trying to open the blackbox: " + e.getMessage());
			}
			return password == this.password;
		}
	}
	
	/**
	 * Generic class to describe the hacker's behavior. It sets the name and
	 * the priority of the thread.
	 * 
	 * */
	private static abstract class HackerThread extends Thread{
		protected BlackBox blackbox;
		public HackerThread(String name, BlackBox blackbox) {
			this.blackbox = blackbox;
			this.setName(name);
			this.setPriority(MAX_PRIORITY);
		}
		
		@Override
		public void start() {
			System.out.println(this.getName() + " into action.");
			super.start();
		}
	}
	
	/**
	 * A type of a hacker who will try to guess the password with an ascending approach.
	 * 
	 * */
	private static class AscendingHacker extends HackerThread{

		public AscendingHacker(String name, BlackBox blackbox) {
			super(name, blackbox);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			for(int pass =0; pass<MAXPASSWORD; pass++) {
				if (this.blackbox.open(pass)) {
					System.out.println(this.getName() + "guessed the password!");
					System.exit(0); 
				}
			}
		}
		
	}
	
	/**
	 * A type of a hacker who will try to guess the password with an descending approach.
	 * 
	 * */
	private static class DescendingHacker extends HackerThread{
		public DescendingHacker(String name, BlackBox blackbox) {
			super(name, blackbox);
		}
		
		@Override
		public void run() {
			for(int pass =MAXPASSWORD-1; pass>=0; pass--) {
				if (this.blackbox.open(pass)) {
					System.out.println(this.getName() + "guessed the password!");
					System.exit(0); 
				}
			}
		}
	}
	
	/**
	 * The police thread will count down from 10 and after and only after that, 
	 * will caught the hackers.
	 * 
	 * */
	private static class PoliceThread extends Thread {  
		
		@Override
		public void run() {
			for(int i= 10; i >=0; i--) {
				try {
					this.sleep(1000);
					
				}catch(InterruptedException ex) {
					System.out.println(ex.getMessage());
				}
				System.out.println(i);
			}
			
			System.out.println("Game over hackers! B-) ");
			System.exit(0); // Stops the program after catching the hackers.
		}
	}
}
	




