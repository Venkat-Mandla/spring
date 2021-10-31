/**
 * 
 */
package com.venkat.practice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author VenkaT
 *
 */
@Entity
@Table
@IdClass(ChapterId.class)
public class Chapter implements Serializable{
	

	@Autowired
	@Transient
	private ModelMapper modelMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3005913579269517524L;

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int chapterNumber;
	
	@MapsId("bookId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Book book;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "chapter",cascade = CascadeType.ALL,targetEntity = Content.class)
	private List<Content> contents=new ArrayList<>();
	
	@OneToMany(mappedBy = "chapter",cascade = CascadeType.ALL,targetEntity = ContentHistory.class)
	private List<ContentHistory> contentsHistory=new ArrayList<>();
	
	@Column(name="create_timestamp", updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTimestamp;
	
	@Column(name="update_timestamp", updatable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTimestamp;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
		for (Content content : contents) {
			content.setChapter(this);
		}
	}
	
	public List<ContentHistory> getContentsHistory() {
		return this.contentsHistory;
	}
	public void setContentsHistory(List<ContentHistory> contentsHistory) {
		this.contentsHistory = contentsHistory;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public int getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	@Override
	public String toString() {
		return "Chapter [chapterNumber=" + chapterNumber + ", book=" + book + ", name=" + name + ", contents="
				+ contents + ", createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp + "]";
	}
	
}
