/**
 * 
 */
package com.venkat.practice.domain;

import java.util.Date;

/**
 * @author VenkaT
 *
 */
public class ContentResponse extends Content{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2373786456951199448L;
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
	@Override
	public String toString() {
		return "ContentResponse [createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp
				+ ", getContentId()=" + getContentId() + ", getWordCount()=" + getWordCount() + ", getData()="
				+ getData() + "]";
	}
	
}
