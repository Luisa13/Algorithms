package MultiThreading.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;


/**
 * Implements a standard and thread safe stack with locks
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */

public class StandardStack {
	public static final int PUSH_THREADS = 2;
	public static final int POP_THREADS = 2;
	
	public static void main(String[] args) throws InterruptedException {
		// Stack<Integer> stack = new Stack<>();
		FreeLockStack<Integer> stack = new FreeLockStack<>();
		Random random = new Random();
		for(int i = 0; i<1000; i++) 
			stack.push(random.nextInt());
		
		List<Thread> threads = new ArrayList<>();
		System.out.println("2");
		for(int i = 0; i<PUSH_THREADS; i ++) {
			Thread thread = new Thread(()->{
				while(true) 
					stack.push(random.nextInt());
				
			});
			thread.setDaemon(true);
			threads.add(thread);
		}
		for(int i = 0; i<POP_THREADS; i ++) {
			Thread thread = new Thread(()->{
				while(true) 
					stack.pop();
				
			});
			thread.setDaemon(true);
			threads.add(thread);
		}
		for(Thread thread: threads)
			thread.start();
		
		Thread.sleep(1000);
		System.out.println("Operation performed in 10 seconds: " + stack.getNumOperations());
	}
	/**
	 * Implement a thread safe stack without using locks.
	 * 
	 * */
	public static class FreeLockStack<T>{
		private AtomicReference<StackNode<T>> head = new AtomicReference<>();
		private AtomicInteger counter = new AtomicInteger(0);
		
		public void push(T value) {
			StackNode<T> newNode = new StackNode<>(value);
			
			// Calculate the new value to replace the head and check if the head has been 
			// changed by another thread
			while(true) {
				StackNode<T> currentHead = this.head.get();
				newNode.next = currentHead;
				if(head.compareAndSet(currentHead, newNode))
					break;
				else{
					LockSupport.parkNanos(1);
				}
			}
			this.counter.incrementAndGet();
		}
		
		public T pop() {
			StackNode<T> currentHead = this.head.get();
			StackNode<T> auxNode;
			// Calculate the new value to replace the head and check if the head has been 
			// changed by another thread
			while(currentHead != null) {
				auxNode = currentHead.next;
				if(this.head.compareAndSet(currentHead, auxNode))
					break;
				else {
					LockSupport.parkNanos(1);
					currentHead = this.head.get();
				}	
			}
			this.counter.incrementAndGet();
			return currentHead != null? currentHead.value : null;
		}
		
		public int getNumOperations() {
			return this.counter.get();
		}
	}

	/**
	 * Implements a standard and thread safe stack with locks
	 * */
	public static class Stack<T>{
		private StackNode<T> head;
		private int counter = 0;
		
		public synchronized T pop() {
			if(this.head == null)
				return null;
			
			T value = this.head.value;
			this.head = this.head.next;
			this.counter ++;
			
			return value;
		}
		
		public synchronized void push(T item) {
			StackNode<T> newNode = new StackNode<T>(item);
			newNode.next = head;
			this.head = newNode;
			this.counter ++;
		}
		
		public int getNumOperations() {
			return this.counter;
		}
	}
	
	/**
	 * Represents the node for a Stack data structure
	 * */
	public static class StackNode<T>{
		public T value;
		public StackNode<T> next;
		
		public StackNode(T value){
			this.value = value;
			this.next = null;
		}
	}
}
