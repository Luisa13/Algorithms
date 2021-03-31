package sortingSearching.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be 
 * able to look up the rank of a number x (the number of values less than or equal 
 * to x). Implement the data, structures and algorithms to support these operations. 
 * That is, implement the method track (int x), which is called when each number is 
 * generated, and the method that returns the number of values less than or equal to 
 * x (but not including itself)
 * 
 * @author luisa
 * 
 * */
public class ex10 {
	
	/**
	 * Data structure that stores integers in increasing order allowing repeated values.
	 * 
	 * */
	public static class RankInteger{
		private List<Integer> list;
		
		/**
		 * Class constructor. Initialize the list where the 
		 * values are stored
		 * 
		 * */
		public RankInteger() {
			this.list = new ArrayList<>();
		}
		
		/**
		 * Stores each number which is generated
		 * @param int
		 * */
		public void track(int x) {
			if(this.list.size() <= 0) {
				this.list.add(x);
			}
			int pos = getSupPosition(x);
			
			if(pos < 0)
				this.list.add(pos+1, x);
			else
				this.list.add(pos, x);
		}
		
		/**
		 * Gets the index whose element is the next higher value to the given element
		 * @param int Reference element.
		 * */
		public int getSupPosition(int x) {
			return getSupPosition(0, this.list.size(), this.list.size(), x);
		}
		
		/**
		 * Gets the index whose element is the next higher value to the given element
		 * */
		private int getSupPosition(int left, int right, int previous, int element) {
			if(previous < right) {
				int mid = left + (right-left)/2;
				
				if(this.list.get(previous) < this.list.get(mid) && this.list.get(mid) > element)
					previous = mid;
				
				if(this.list.get(mid) > element)
					return getSupPosition(left, mid-1, previous, element);
				
				if(this.list.get(mid) < element)
					return getSupPosition(mid+1, right, previous, element);
			}
			return previous -1;
		}
		
		/**
		 * Returns the number of values less than or equal to x without including itself
		 * @param int
		 * */
		public int getRankOfNumber(int x) {
			return getSupPosition(x) -1;
		}
		
		
		
	}

}
