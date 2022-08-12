/**
 * 
 */
package com.poc.venkat.springrestservices.api.service;

import org.springframework.stereotype.Service;

import com.poc.venkat.springrestservices.domain.Customer;

/**
 * @author VenkaT
 *
 */
@Service
public class BusinessLogicService {
	
	public String processTestLogic(Customer customer) {
		return customer.getName();
	}
	
	public Customer processTestLogic(String id) {
		return new Customer();
	}

}
