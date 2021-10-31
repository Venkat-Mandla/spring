/**
 * 
 */
package com.venkat.practice.domain;

import java.util.Date;

/**
 * @author VenkaT
 *
 */
public class Result {
	
	private Date updateTimestamp;
	private int count;
	
	public Result(int count) {
		super();
		this.count = count;
	}
	
	public Result(long count) {
		super();
		this.count =(int) count;
	}

	public Result(Date updateTimestamp, long count) {
		super();
		this.updateTimestamp = updateTimestamp;
		this.count = (int)count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@Override
	public String toString() {
		return "Result [updateTimestamp=" + updateTimestamp + ", count=" + count + "]";
	}

	
}
