/**
 * 
 */
package com.venkat.practice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author VenkaT
 *
 */
@Entity
@Table
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3925284078651361048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,targetEntity = Page.class)
	private List<Page> pages=new ArrayList<>();
	
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
		for (Page page : pages) {
			page.setBook(this);
		}
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", pages=" + pages + "]";
	}
	
}
