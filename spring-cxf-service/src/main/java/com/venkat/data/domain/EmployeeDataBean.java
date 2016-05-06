/**
 * 
 */
package com.venkat.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Venkat
 *
 */
@Entity  
@Table(name="Employee") 
public class EmployeeDataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7956908466043793529L;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "empid") 
	private int id;
	@Column(name="empName")
	private String name;
	@Column(name="empPhoneNumber")
	private String phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
