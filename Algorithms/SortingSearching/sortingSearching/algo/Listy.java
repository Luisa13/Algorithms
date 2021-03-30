package sortingSearching.algo;

import java.util.ArrayList;

public class Listy extends ArrayList<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Integer elementAt(int index) {
		try {
			return this.get(index); 
		}catch(IndexOutOfBoundsException ex) {
			return -1;
		}
	} 

}
