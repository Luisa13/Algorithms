package sortingSearching.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Got a 20GB file with one string per line. Explain how you would sort the file.
 * 
 * APPROACH
 * The idea is to split the file in chunks and sort them independently, then merge them 
 * into the file. In order to avoid unnecessary file operations I will dump the container 
 * into a string array, do all the sorting the afterwards turn into a file.
 * 
 * WARNING might be buggy as was not tested yet
 * 
 * @author luisa
 * 
 */

public class ex6 {

	/**
	 * Sorts the data contained in a a big file
	 * @param File
	 * */
	public File sortBigFile(File file) {
		int fileSize = (int)file.length();
		int size = 1;
		List<String[]> strList = new ArrayList<String[]>();
		for(int i = 0; i<fileSize; i++) {
			File fChunk = getChunk(file, size);
			String[] strChunk = FileToArrayString(fChunk);
			strList.add( sort(strChunk) );
			if(strList.size() > 1) 
				strList = mergeList(strList);
			
		}
		
		return listToFile(strList, file.getPath() );
	}
	
	/**
	 * Returns an array with the content of a given file
	 * @param File
	 * @return String []
	 * */
	private String[] FileToArrayString(File file) {
		List<String> list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) 
				list.add(sc.next());
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return (String[]) list.toArray();
		
	}
	
	/**
	 * Returns a chunk from the file defined by the given size
	 * @param File
	 * @param int
	 * @return File
	 * */
	private File getChunk(File file, int size) {
		return file;
	}
	
	/**
	 * Sorts an array of strings
	 * @param String[]
	 * @return String[]
	 * */
	private String[] sort(String[] strings) {
		return sort(strings, new String[strings.length], 0, strings.length);
	}
	
	/**
	 * Recursively sort an array string
	 * */
	private String[] sort(String[] strings, String[] helper, int low, int high) {

		if(high > low) {
			int mid = (high + low)/2;
			sort(strings, helper, low, mid);
			sort(strings, helper, mid+1, high);
			merge(strings, helper, low, mid, high);
		}
		return null;
		
	}
	
	/**
	 * Merges the different independent sorted sections in the array, 
	 * and returns the original array totally sorted
	 * 
	 * @param String[] 		Original string array where there are independent sorted sections
	 * @param String[] 		Empty string array to use as a buffer
	 * @param int Lower 	boundary in the array
	 * @param int Middle 	point between low and high
	 * @param int Higher 	boundary in the array
	 * @return String[]		Array totally sorted
	 * 
	 * */
	private String[] merge(String[] strings, String[] helper, int low, int mid, int high) {
		for(int i = 0; i <=strings.length; i++)
			helper[i] = strings[i];
		
		int right = mid+1;
		int left = low;
		int current = low;
		
		while(left <= mid && right <= high) {
			if( helper[left].compareTo(helper[right]) > 0 ) {
				strings[current] = helper[left];
				left ++;
			}else {
				strings[current] = helper[right];
				right ++;
			}
			
			current ++;
		}
		
		// Copy the the elements that remains in the first half of the helper array
		for(int i=0; i< (mid - left); i++) {
			strings[current + i] = helper[left + i];
		}
		
		return strings;
	}
	
	
	/**
	 * Given a list that contains two String's array, it merges them in a 
	 * sorted list.
	 * 
	 * @param List< String []>
	 * @return List< String []>
	 * */
	private List<String[]> mergeList(List<String[]> stringList){
		int size = stringList.get(0).length + stringList.get(1).length;
		String[] str = new String[size];
		
		for(String[] arr: stringList) {
			for(int i=0; i< arr.length; i++)
				str[i] = arr[i];
		}
		int mid = stringList.get(0).length;
		str = merge(str, new String[str.length], 0, mid, str.length);
		
		List<String[]> l = new ArrayList<String[]>();
		l.add(str);
		return l;
		
	}
	
	/**
	 * Dump the given list content into a File
	 * 
	 * @param List<String []> 	List with the data
	 * @param String			Pathname of the file to be returned
	 * @param File 				File with the content
	 * */
	private File listToFile(List<String[] >list, String pathname) {
		File file = new File(pathname);
		
		return file;
	}
	
}
