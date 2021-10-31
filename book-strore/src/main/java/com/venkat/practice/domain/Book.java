/**
 * 
 */
package com.venkat.practice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
	private Date aTransactionTime;
	private long aTransactionId;
	private long bookId;
	private String name;
	private List<Chapter> chapters;
	
	public Book() {
		chapters=new ArrayList<>();
	}

	public Date getaTransactionTime() {
		return aTransactionTime;
	}

	public long getaTransactionId() {
		return aTransactionId;
	}

	public long getBookId() {
		return bookId;
	}

	public String getName() {
		return name;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setaTransactionTime(Date aTransactionTime) {
		this.aTransactionTime = aTransactionTime;
	}

	public void setaTransactionId(long aTransactionId) {
		this.aTransactionId = aTransactionId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Book [aTransactionTime=" + aTransactionTime + ", aTransactionId=" + aTransactionId + ", bookId="
				+ bookId + ", name=" + name + ", chapters=" + chapters + "]";
	}
	
}
