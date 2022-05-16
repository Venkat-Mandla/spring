/**
 * 
 */
package com.poc.venkat.springrestservices.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author VenkaT
 *
 */
public class Customer {
	
	@NotBlank(message = "Id can't be blank")
	private String id;
	@NotEmpty(message = "Name can't be empty")
	private String name;
	private Address address;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Address getAddress() {
		return address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
