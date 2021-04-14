package ood.exercises.ex5;

import java.util.Vector;

/**
 * Represents a book
 * 
 * @author luisa
 */
public class Book {
	private String title;
	private String author;
	private int MAXPAGES = 0;
	private Vector<Chapter> chapters;
	private int bookKeeper;
	/* Pointer to the current chapter */
	private Chapter currentChapter;

	/**
	 * Creates a new book with a tittle, author, and all the pages contained in the
	 * chapters.
	 * 
	 * @param String
	 * @param String
	 * @param Vector<Chapter>
	 */
	public Book(String title, String author, Vector<Chapter> chapters) {
		this.author = author;
		this.title = title;
		this.currentChapter = chapters.get(0);
		this.chapters = chapters;
		for (Chapter c : this.chapters)
			MAXPAGES += c.numberOfPages();
		this.bookKeeper = 0;
	}

	/**
	 * Open the book for the last page left
	 */
	public void openBook() {
		this.currentChapter = chapters.get(this.bookKeeper);
		Page currentPage = this.currentChapter.getLastPageOpen();
		currentPage.display();
	}

	/**
	 * Turns the page
	 * */
	public void turnPage() {
		try {
			this.currentChapter.turnPage();
		} catch (Exception ex) {
			this.bookKeeper ++;
			this.currentChapter = this.chapters.get(bookKeeper);
			// TODO:
			// what happens here
		}
	}
	
	/**
	 * Goes to the chapter specified in the given index and returns the firs page. 
	 * The current chapter will be marked down as the next time the book is opened, 
	 * will be displayed in that new chapter.
	 * 
	 * @param index
	 * */
	public Page goToChapter(int index) {
		this.currentChapter = this.chapters.get(index);
		Page page = this.currentChapter.pageAt(0);
		this.bookKeeper = this.currentChapter.getId();
		
		return page;
	}
	
	public void openAt(int numPage) {
		for(){
			
		}
	}

}
