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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
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

	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
		for (Chapter chapter : chapters) {
			chapter.setBook(this);
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
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", createTimestamp=" + createTimestamp
				+ ", updateTimestamp=" + updateTimestamp + ", pages=" + chapters + "]";
	}
	
}
