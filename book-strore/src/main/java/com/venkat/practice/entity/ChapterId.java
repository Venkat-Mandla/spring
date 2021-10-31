/**
 * 
 */
package com.venkat.practice.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author VenkaT
 *
 */
@Embeddable
public class ChapterId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8502356508227285576L;
	private int chapterNumber;
	private Book book;
	public int getChapterNumber() {
		return chapterNumber;
	}
	public Book getBook() {
		return book;
	}
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
