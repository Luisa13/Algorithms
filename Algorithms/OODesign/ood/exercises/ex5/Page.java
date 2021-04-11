package ood.exercises.ex5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents a page of the book
 * @author luisa
 * */
public class Page {

	private int pageNum;
	private String strPage;
	private File pageFile;
	
	/**
	 * 
	 * */
	public Page(String filename) {
		this.strPage = "";
		this.pageFile = new File(filename);
		try {
			this.strPage = new String (Files.readAllBytes(Paths.get(filename)));
			this.pageNum ++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * */
	public void display() {
		System.out.print(strPage);
	}
}
		
	
