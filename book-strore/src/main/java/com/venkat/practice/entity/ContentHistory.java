/**
 * 
 */
package com.venkat.practice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author VenkaT
 *
 */
@Entity
@Table
public class ContentHistory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8115383511133810892L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long auditId;
	
	@Column
	private Long contentId;
	
	@Column
	private String data;
	
	@Column
	private int wordCount;
	
	@Column(name="create_timestamp", updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTimestamp;
	
	@Column(name="update_timestamp", updatable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTimestamp;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false,targetEntity = Chapter.class)
    @JoinColumns({@JoinColumn(name = "chapterNumber", nullable = false),@JoinColumn(name = "bookId", nullable = false)})
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Chapter chapter;
	
	@Column
	private String transactionId;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getAuditId() {
		return auditId;
	}

	public Long getContentId() {
		return contentId;
	}

	public String getData() {
		return data;
	}

	public int getWordCount() {
		return wordCount;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
		this.transactionId=chapter.getTransactionId();
	}
	

	public String getTransactionId() {
		return chapter.getTransactionId();
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "ContentHistory [auditId=" + auditId + ", contentId=" + contentId + ", data=" + data + ", wordCount="
				+ wordCount + ", createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp
				+ ", chapter=" + chapter + ", transactionId=" + transactionId + "]";
	}

}
