/**
 * 
 */
package com.poc.venkat.springrestservices.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.venkat.springrestservices.api.service.BusinessLogicService;
import com.poc.venkat.springrestservices.domain.Customer;

/**
 * @author VenkaT
 *
 */
@RestController
@RequestMapping("/api/")
public class ApiResource {
	
	@Autowired
	private BusinessLogicService service;
	
	@PostMapping("/register-customer")
	public ResponseEntity<String> validateRequestBody(@RequestBody @Validated Customer customer){
		 return ResponseEntity.ok("Cutomer registered, name : "+service.processTestLogic(customer));
	}
	
	
	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomer(@RequestParam(name = "name") String id){
		 return ResponseEntity.ok(service.processTestLogic(id));
	}

}
