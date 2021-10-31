/**
 * 
 */
package com.venkat.practice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.practice.domain.BookRequest;
import com.venkat.practice.domain.BookResponse;
import com.venkat.practice.domain.ChapterResponse;
import com.venkat.practice.domain.ContentResponse;
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
	public ResponseEntity<BookResponse> getBook(@RequestParam(name = "id") int id){
		BookResponse b=service.get(id);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<BookResponse> newBook1(@RequestBody BookRequest book){
		BookResponse bookResult=service.newBook(book);
		return new ResponseEntity<>(bookResult,HttpStatus.OK);
	}
	
	@GetMapping("/book/{bookId}/chapter/{chapterId}")
	public ResponseEntity<ChapterResponse> getChapter(@PathVariable("bookId") long bookId,@PathVariable("chapterId") long chapterId){
		ChapterResponse b=service.getChapter(bookId,chapterId);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("/book/{bookId}/chapter/{chapterId}/content/{contentId}")
	public ResponseEntity<ContentResponse> getContent(@PathVariable("bookId") long bookId,@PathVariable("chapterId") long chapterId,@PathVariable("contentId") long contentId){
		ContentResponse b=service.getContent(bookId,chapterId,contentId);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("/app-status")
	public ResponseEntity<String> getBook(){
		return new ResponseEntity<>("App up and running.",HttpStatus.OK);
	}
	
}
