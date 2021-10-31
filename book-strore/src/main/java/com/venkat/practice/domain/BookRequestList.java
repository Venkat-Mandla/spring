/**
 * 
 */
package com.venkat.practice.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author VenkaT
 *
 */
public class BookRequestList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2269977804871584095L;
	private String id;
	private List<Book> books;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "BookRequestList [id=" + id + ", books=" + books + "]";
	}
	
}
