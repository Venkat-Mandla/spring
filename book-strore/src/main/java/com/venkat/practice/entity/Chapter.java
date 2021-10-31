/**
 * 
 */
package com.venkat.practice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private int chapterNumber;
	
	@MapsId("bookId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Book book;
	
	@Column(name="transaction_timestamp", updatable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionTime;
	
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
	
	@Transient
	private String transactionId;
	
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
		for (Content content : contents) {
			content.setChapter(this);
		}
	}
	
	public List<ContentHistory> getContentsHistory() {
		return this.contentsHistory;
	}
	public void setContentsHistory() {
		List<ContentHistory> histories = new ArrayList<>();
		for (Content content : getContents()) {
			ContentHistory history = new ContentHistory();
			history.setContentId(content.getContentId());
			history.setWordCount(content.getWordCount());
			history.setData(content.getData());
			history.setChapter(this);
			history.setTransactionId(getTransactionId());
			histories.add(history);
		}
		this.contentsHistory = histories;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
		this.transactionId=book.getaTransactionId();
		this.transactionTime=book.getaTransactionTime();
		setContentsHistory();
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
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	@Override
	public String toString() {
		return "Chapter [chapterNumber=" + chapterNumber + ", book=" + book + ", name=" + name + ", contents="
				+ contents + ", createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp + "]";
	}
	
}
