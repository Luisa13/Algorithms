package exercises.heaps;

/**
 * Basic implementation of a heap.
 * 
 * @author luisa
 */
public class HeapImplementation {

	public static class MaxHeap {
		// DS where the elements are stored
		private int[] heap;
		// Max capacity of the heap
		private static int MAXCAPACITY;
		// Current size of the heap
		private int size;

		public MaxHeap(int n) {
			MAXCAPACITY = n;
			this.heap = new int[MAXCAPACITY];
			this.size = 0;
		}

		/**
		 * Adds an element to the heap
		 * 
		 * @param int
		 * 
		 */
		public int add(int element) {
			if(size >= MAXCAPACITY)
				return -1;
			
			this.heap[size] = element;
			int current = this.size;
			this.size ++;
			
			// Climb the new element up until meet the condition of a MinHeap
			while (this.heap[current] > this.heap[getParent(current)]) {
				hepify(getParent(current));
				current = getParent(current);
			}
			
			return element;
		}

		/**
		 * Removes an element from the heap given the position
		 * 
		 * @param int
		 */
		public int remove(int k) {
			if(size <= 0 && k < size)
				return -1;
			
			int element = this.heap[k];
			swap(k, size-1);
			hepify(k);
			size --;
			
			return element;
			
		}
		
		
		public int remove() {
			if(size <= 0)
				return -1;
			
			int element = this.heap[0];
			swap(0, size-1);
			size --;
			hepify(0);
			
			
			return element;
		}

		/**
		 * Returns the minimun element of the heap without removing it.
		 * 
		 * @return int
		 */
		public int peek() {
			return heap[0];
		}

		
		private void hepify(int currentNode) {
			int largest = currentNode;
			int left = this.getLeftChild(currentNode);
			int right = this.getRightChild(currentNode);
			
			// 1. Get the largest out of the min tree
			if(left < size && heap[left] > heap[largest])
				largest = left;
			
			if(right < size && heap[right] > heap[largest])
				largest = right;
			
			// 2. Swap with the min leaf in the heap
			if(largest != currentNode) {
				swap(largest, currentNode);
				// 3. Repeat
				hepify(largest);
			}
		}
		
		public boolean hasNext() {
			return size > 0;
		}

		private int getParent(int node) {
			return (node-1)/2;
		}

		private int getLeftChild (int parentNode) {
			return 2*parentNode +1;
		}

		private int getRightChild (int parentNode) {
			return 2*parentNode +2;
		}
		
		private void swap (int posA, int posB) {
			int aux = this.heap[posA];
			this.heap[posA] = this.heap[posB];
			this.heap[posB] = aux; 
		}
	}

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(5);
		heap.add(8);
		heap.add(0);
		heap.add(1);
		heap.add(6);
		heap.add(11);
		
		while(heap.hasNext()) {
			int num = heap.remove();
			System.out.print(num + ", ");
		}
		System.out.println();

	}

}
