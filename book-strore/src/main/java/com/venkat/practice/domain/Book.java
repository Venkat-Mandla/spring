/**
 * 
 */
package com.venkat.practice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VenkaT
 *
 */
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4875650997860853418L;
	private long aTransactionId;
	private long bookId;
	private String name;
	private List<Chapter> chapters;
	public Book(long transactionId) {
		chapters=new ArrayList<>();
		this.aTransactionId=transactionId;
	}
	
	public Book() {
		chapters=new ArrayList<>();
	}
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	public long getaTransactionId() {
		return aTransactionId;
	}

	public void setaTransactionId(long aTransactionId) {
		this.aTransactionId = aTransactionId;
	}

	@Override
	public String toString() {
		return "Book [id=" + bookId + ", name=" + name + ", chapters=" + chapters + "]";
	}
	
}
