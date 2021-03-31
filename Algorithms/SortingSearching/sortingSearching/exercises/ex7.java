package sortingSearching.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an input file with four billion non negative integers, provide, an algorithm to generate an 
 * integer that is not contained in the file. Assume you have 1 GB of memory available for this task.
 * 
 * APPROACH
 * The key here, is to notice the number of elements you have in the file and the type of data is stored.
 * On the one hand we have 4 billions elements which means 2^32 and , on the other hand we are storing 
 * Integers which behold numbers from -2.147.483.648 to 2.147.483.648; Since there are only positive we 
 * supposed to have a variety of 2^31 elements. 2^32 > 2^31, so we can presume we have repeated values.
 * 
 * Another point is we have a storage capacity of 1GB which means, we can only save around 2^30 bytes.
 * 
 * @author luisa
 * */
public class ex7 {

	/**
	 * Generates a new positive integer that not exists in a given file
	 * 
	 * @param File File with unsorted values
	 * @return int
	 * */
	public int generateNewInteger(File file) {
		long maxInteger = (long)Integer.MAX_VALUE +1; //Math.pow(2, 32);
		int size = (int)maxInteger/8;
		boolean integers[] = new boolean[size/8];
		
		Integer data[] = getArratFromFile(file);
		
		for(int number: data) {
			integers[number] = true;
		}
		
		int i = 0;
		
		for(boolean taken: integers) {
			if( !taken )
				return i;
			i++;
		}
		
		return -1;
	}
	
	/**
	 * Returns an Integer array from a file
	 * 
	 * @param File File that contains the data
	 * @param Integer[]
	 * */
	private Integer[] getArratFromFile(File file) {
		List<Integer> list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				Integer val = Integer.parseInt(sc.next());
				list.add( val );
			}
			
			sc.close();
		}catch(FileNotFoundException ex) {
			ex.getMessage();
		}
		
		return (Integer[]) list.toArray();
	}
}
