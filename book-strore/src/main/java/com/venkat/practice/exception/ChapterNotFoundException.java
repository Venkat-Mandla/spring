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
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Chapter Not Found")
public class ChapterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4093902712222670637L;

}
