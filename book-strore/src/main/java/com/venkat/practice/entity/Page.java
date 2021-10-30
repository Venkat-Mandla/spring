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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author VenkaT
 *
 */
@Entity
@Table
public class Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3005913579269517524L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pageNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Book book;
	
	
	@Column
	private String data;
	
	@OneToMany(mappedBy = "page",cascade = CascadeType.ALL,targetEntity = Content.class)
	private List<Content> contents=new ArrayList<>();
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
		for (Content content : contents) {
			content.setPage(this);
		}
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Page [pageNumber=" + pageNumber + ", book=" + book + ", data=" + data + ", contents=" + contents + "]";
	}

}
