/**
 * 
 */
package com.venkat.practice.domain;

import java.util.Date;

/**
 * @author VenkaT
 *
 */
public class BookResponse extends Book {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8626865507727952202L;
	
	private String message;
	
	private Date createTimestamp;
	private Date updateTimestamp;
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "BookResponse [createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getChapters()=" + getChapters() + "]";
	}
	
}
