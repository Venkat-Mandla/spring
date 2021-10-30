/**
 * 
 */
package com.venkat.practice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.practice.entity.Book;
import com.venkat.practice.service.BookStoreService;

/**
 * @author VenkaT
 *
 */

@RestController
@RequestMapping("/api")
public class BookStoreResource {
	
	@Autowired
	private BookStoreService service;

	@GetMapping("/book")
	public ResponseEntity<Book> getBook(@RequestParam(name = "id") int id){
		Book b=service.get(id);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> newBook(@RequestBody Book book){
		Book bookResult=service.newBook(book);
		return new ResponseEntity<>(bookResult,HttpStatus.OK);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Book> getPage(@RequestParam(name = "id") int id){
		Book b=service.get(id);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("/app-status")
	public ResponseEntity<String> getBook(){
		return new ResponseEntity<>("App up and running.",HttpStatus.OK);
	}
	
}
