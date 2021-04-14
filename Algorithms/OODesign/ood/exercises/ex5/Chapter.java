package ood.exercises.ex5;

import java.util.Vector;

/**
 * Represents the chapter of a book
 *
 * @author luisa
 **/
public class Chapter {
	
	private String name;
	private int id;
	private int startPage;
	private int lastPage;
	private int pageKeeper;
	private Vector<Page> pages;
	
	/**
	 * Create a chapter with all the pages in the given paramenter under a name.
	 * 
	 * */
	public Chapter(String name, int id, Vector<Page> pages) {
		if(pages == null)
			return;
		
		this.name = name;
		this.id = id;
		this.pages = new Vector<Page>();
		this.startPage = 0;
		this.lastPage = pages.size() - 1;
		for(Page pg: pages) {
			this.pages.add(pg);
		}
		
	}
	
	/**
	 * Display the next page in the chapter
	 * @throws Exception 
	 * 
	 * */
	public void turnPage() throws Exception {
		if(pageKeeper == lastPage)
			throw new Exception("End of chapter");
		
		Page page = this.pages.get(this.pageKeeper);
		pageKeeper ++;
		page.display();
	}
	
	/**
	 * Check if the chapter contains a given page.
	 * @param int
	 * */
	public boolean containsPage(int pageNum) {
		if(pageNum >= startPage && pageNum <= lastPage)
			return true;
		return false;
	}
	
	/**
	 * Returns the page at the given index
	 * @param int
	 * */
	public Page pageAt(int pageNum) {
		return this.pages.get(pageNum);
	}
	
	/**
	 * Returns the last page that was displayed before the book was closed
	 * @return Page
	 * */
	public Page getLastPageOpen() {
		return this.pages.get(this.pageKeeper);
	}
	
	public int numberOfPages() {
		return this.lastPage;
	}
	
	public int getId() {
		return this.id;
	}

}
