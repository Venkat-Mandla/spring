/**
 * 
 */
package com.venkat.practice.domain;

import java.io.Serializable;

/**
 * @author VenkaT
 *
 */
public class Content implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5893113581635092794L;
	private int contentId;
	private int wordCount;
	private String data;
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getWordCount() {
		return wordCount;
	}
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", wordCount=" + wordCount + ", data=" + data + "]";
	}
	
	
}
