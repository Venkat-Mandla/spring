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
public class Chapter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5472241919700426287L;
	private int chapterNumber;
	private String name;
	private List<Content> contents;
	
	public Chapter() {
		contents=new ArrayList<>();
	}
	
	public int getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "Chapter [chapterNumber=" + chapterNumber + ", name=" + name + ", contents=" + contents + "]";
	}
	
}
