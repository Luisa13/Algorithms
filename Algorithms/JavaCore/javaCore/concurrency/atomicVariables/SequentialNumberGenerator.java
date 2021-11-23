package javaCore.concurrency.atomicVariables;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The aim of this exercise is being able to perform an atomic operation using
 * an atomic reference. The class SequenceGenerator will increment by 1 the
 * current value giving as a result a natural sequence of integer numbers. This
 * also display the usefulness of the atomic variables which guarantees the 
 * atomicy of the operation.
 * 
 * @author luisa
 */
public class SequentialNumberGenerator {

	public static class SequentialGenerator{
		private AtomicLong cachedValue = new AtomicLong(0);
		
		public boolean increment() {
			long currentValue = this.cachedValue.get();
			long newValue = this.cachedValue.get() + 1;
			
			return this.cachedValue.compareAndSet(currentValue, newValue);
		}
		
		public long updatedValue() {
			return this.cachedValue.get();
		}
	}
	
	
	
	public static void main(String[] args) {
		final SequentialGenerator sequenceGenerator = new SequentialGenerator();
		long value = sequenceGenerator.updatedValue();
		
		while(value < 10){
			sequenceGenerator.increment();
			value = sequenceGenerator.updatedValue();
			System.out.println("Value: " + value);
		}
	}
}
