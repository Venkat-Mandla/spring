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
public class ContentId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6548818978118075528L;
	private Long contentId;
	private Chapter chapter;
	public Long getContentId() {
		return contentId;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	@Override
	public String toString() {
		return "ContentId [contentId=" + contentId + ", chapter=" + chapter + "]";
	}
	
}
