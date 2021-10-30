/**
 * 
 */
package com.venkat.practice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author VenkaT
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Page Not Found")
public class PageNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4093902712222670637L;

}
