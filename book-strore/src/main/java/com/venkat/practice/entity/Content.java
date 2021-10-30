/**
 * 
 */
package com.venkat.practice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author VenkaT
 *
 */
@Entity
@Table
public class Content implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8115383511133810892L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long contentId;
	
	@Column
	private String data;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false,targetEntity = Page.class)
    @JoinColumn(name = "pageNumber", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Page page;
	
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", data=" + data + ", page=" + page + "]";
	}

}
