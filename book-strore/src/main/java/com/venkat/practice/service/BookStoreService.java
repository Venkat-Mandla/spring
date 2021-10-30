/**
 * 
 */
package com.venkat.practice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venkat.practice.entity.Book;
import com.venkat.practice.entity.Page;
import com.venkat.practice.exception.BookNotFoundException;
import com.venkat.practice.repository.BookRepository;
import com.venkat.practice.repository.PageRepository;

/**
 * @author VenkaT
 *
 */
@Component
public class BookStoreService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PageRepository pageRepository;
	
	public Book newBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book get(int bookId) {
		Optional<Book> book= bookRepository.findById((long)bookId);
		if(book.isEmpty()) {
			throw new BookNotFoundException();
		}
		return book.get();
	}
	
	public Page getPage(int pageId) {
		Optional<Page> page= pageRepository.findById((long)pageId);
		if(page.isEmpty()) {
			throw new PageNotFoundException();
		}
		return page.get();
	}

}
