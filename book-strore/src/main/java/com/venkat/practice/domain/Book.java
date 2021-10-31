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
	private int id;
	private String name;
	private List<Chapter> chapters;
	public Book() {
		chapters=new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", chapters=" + chapters + "]";
	}
	
}
