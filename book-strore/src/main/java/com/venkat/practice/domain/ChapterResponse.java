/**
 * 
 */
package com.venkat.practice.domain;

import java.util.Date;

/**
 * @author VenkaT
 *
 */
public class ChapterResponse extends Chapter{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7290321963890294380L;
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
		return "PageResponse [createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp
				+ ", getChapterNumber()=" + getChapterNumber() + ", getName()=" + getName() + ", getContents()="
				+ getContents() + "]";
	}

}
