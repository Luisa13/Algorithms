package MultiThreading.fundamentals;

import java.util.List;
import java.util.ArrayList;


/**
 * The client for this class will create a list of Runnable tasks and provide such list to the 
 * Multiexecutor's constructor. When the client runs the runnAll method, the Multiexecutor will 
 * execute all the given tasks.
 * 
 * 
 * This exercise has been extracted from the course Java Multithreading, Concurrency & Performance 
 * Optimization, instructed by Michael Progrebinsky through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class MultiExecutor {

	private final List<Task> tasks;
	
	public static void main(String[] args) {
		
		List<Task> localTasks = new ArrayList<>();
		localTasks.add(new Task());
		localTasks.add(new Task());
		localTasks.add(new Task());
		localTasks.add(new Task());
		localTasks.add(new Task());
		localTasks.add(new Task());
		
		MultiExecutor executor = new MultiExecutor(localTasks);
		executor.executeAll();
	}
	
	public MultiExecutor(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	private void executeAll() {
		List<Thread> threads = new ArrayList<Thread>(tasks.size());
		
		for(Task task: tasks) {
			Thread newThread = new Thread(task);
			threads.add(newThread);
		}
		
		for(Thread thread: threads) {
			thread.start();
		}
	}
	
	private static class Task implements Runnable{

		@Override
		public void run() {
			System.out.println("Task done");
			
		}
		
	}
}
