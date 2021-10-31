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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author VenkaT
 *
 */
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
	private Long bookId;
	@Transient
	private Date aTransactionTime;
	
	@Transient
	private String aTransactionId;
	
	@Column
	private String name;
	
	@Column(name="create_timestamp", updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTimestamp;
	
	@Column(name="update_timestamp", updatable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTimestamp;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,targetEntity = Chapter.class)
	private List<Chapter> chapters=new ArrayList<>();
	
	
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
	
	public String getaTransactionId() {
		return aTransactionId;
	}
	public void setaTransactionId(String aTransactionId) {
		this.aTransactionId = aTransactionId;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
		for (Chapter chapter : chapters) {
			chapter.setBook(this);
			chapter.setTransactionId(this.aTransactionId);
			chapter.setTransactionTime(this.aTransactionTime);
		}
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
	
	public Date getaTransactionTime() {
		return aTransactionTime;
	}
	public void setaTransactionTime(Date aTransactionTime) {
		this.aTransactionTime = aTransactionTime;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", createTimestamp=" + createTimestamp
				+ ", updateTimestamp=" + updateTimestamp + ", pages=" + chapters + "]";
	}
	
}
