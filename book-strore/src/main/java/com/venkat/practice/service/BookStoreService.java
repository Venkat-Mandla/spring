/**
 * 
 */
package com.venkat.practice.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venkat.practice.domain.BookRequest;
import com.venkat.practice.domain.BookResponse;
import com.venkat.practice.domain.ChapterResponse;
import com.venkat.practice.domain.ContentResponse;
import com.venkat.practice.entity.Book;
import com.venkat.practice.entity.Chapter;
import com.venkat.practice.entity.ChapterId;
import com.venkat.practice.entity.Content;
import com.venkat.practice.entity.ContentId;
import com.venkat.practice.exception.BookNotFoundException;
import com.venkat.practice.exception.ChapterNotFoundException;
import com.venkat.practice.exception.ContentNotFoundException;
import com.venkat.practice.repository.BookRepository;
import com.venkat.practice.repository.ChapterRepository;
import com.venkat.practice.repository.ContentRepository;

/**
 * @author VenkaT
 *
 */
@Component
public class BookStoreService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ChapterRepository chapterRepository;
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BookResponse newBook(BookRequest book) {
		Book bookEntity=modelMapper.map(book, Book.class);
		Book response= bookRepository.save(bookEntity);
		return modelMapper.map(response, BookResponse.class);
	}
	
	public BookResponse get(int bookId) {
		Optional<Book> book= bookRepository.findById((long)bookId);
		if(book.isEmpty()) {
			throw new BookNotFoundException();
		}
		return modelMapper.map(book.get(),BookResponse.class);
	}
	
	public ChapterResponse getChapter(long bookId, long chapterId) {
		ChapterId chapterIdObj = buildChapterId(bookId, chapterId);
		Optional<Chapter> chapters= chapterRepository.findById(chapterIdObj);
		if(chapters.isEmpty()) {
			throw new ChapterNotFoundException();
		}
		return modelMapper.map(chapters.get(),ChapterResponse.class);
	}

	private ChapterId buildChapterId(long bookId, long chapterId) {
		ChapterId chapterIdObj = new ChapterId();
		chapterIdObj.setChapterNumber((int)chapterId);
		Book book = buildBook(bookId);
		chapterIdObj.setBook(book);
		return chapterIdObj;
	}

	private Book buildBook(long bookId) {
		Book book = new Book();
		book.setBookId(bookId);
		return book;
	}

	public ContentResponse getContent(long bookId, long chapterId, long contentId) {
		ContentId contentIdObj = buildContentId(bookId, chapterId, contentId);
		Optional<Content> contents= contentRepository.findById(contentIdObj);
		if(contents.isEmpty()) {
			throw new ContentNotFoundException();
		}
		return modelMapper.map(contents.get(),ContentResponse.class);
	}

	private ContentId buildContentId(long bookId, long chapterId, long contentId) {
		ContentId contentIdObj = new ContentId();
		contentIdObj.setContentId(contentId);
		Chapter chapter = buildChapter(chapterId);
		Book book = buildBook(bookId);
		chapter.setBook(book);
		contentIdObj.setChapter(chapter);
		return contentIdObj;
	}

	private Chapter buildChapter(long chapterId) {
		Chapter chapter = new Chapter();
		chapter.setChapterNumber((int)chapterId);
		return chapter;
	}

}
