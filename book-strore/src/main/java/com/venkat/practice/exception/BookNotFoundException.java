/**
 * 
 */
package com.venkat.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author VenkaT
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book Not Found")
public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
