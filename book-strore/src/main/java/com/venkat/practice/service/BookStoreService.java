/**
 * 
 */
package com.venkat.practice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Transient;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.venkat.practice.domain.BookRequest;
import com.venkat.practice.domain.BookResponse;
import com.venkat.practice.domain.ChapterResponse;
import com.venkat.practice.domain.ContentResponse;
import com.venkat.practice.domain.Result;
import com.venkat.practice.entity.Book;
import com.venkat.practice.entity.Chapter;
import com.venkat.practice.entity.ChapterId;
import com.venkat.practice.entity.Content;
import com.venkat.practice.entity.ContentHistory;
import com.venkat.practice.entity.ContentId;
import com.venkat.practice.exception.BookNotFoundException;
import com.venkat.practice.exception.ChapterNotFoundException;
import com.venkat.practice.exception.ContentNotFoundException;
import com.venkat.practice.repository.BookRepository;
import com.venkat.practice.repository.ChapterRepository;
import com.venkat.practice.repository.ContentRepository;
import com.venkat.practice.repository.HistoryRepository;

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
	private HistoryRepository historyRepository;

	@Autowired
	private ModelMapper modelMapper;

	public BookResponse newBook(BookRequest book) {
		book.setaTransactionId(builTransactionId());
		Book bookEntity = modelMapper.map(book, Book.class);
		Book response = bookRepository.save(bookEntity);
		// Result
		// wordCountDiff=historyRepository.findWordCountDiff(response.getBookId());
		// Result wordAvg=historyRepository.findWordCountAvg(response.getBookId());

		List<Result> wordStats = historyRepository.findStats(response.getBookId(), PageRequest.of(0, 2));
		System.out.println("Results - " + wordStats);

		String s = null;
		if (wordStats.size() == 1) {
			s = "Wow. You typed " + wordStats.get(0).getCount() + " words on your first submission";
		} else if (wordStats.size() >= 1) {

			int newCount = wordStats.get(0).getCount();
			int previousCount = wordStats.get(1).getCount();

			Date newTimestamp = wordStats.get(0).getUpdateTimestamp();
			Date previousTimestamp = wordStats.get(1).getUpdateTimestamp();
			int diffCount = newCount - previousCount;
			s = "Wow. You typed " + diffCount + " words b/w " + newTimestamp + " and " + previousTimestamp
					+ "	Average number of words between two timestamps? " + (diffCount / 2) + "(TBD -add ts) b/w "
					+ newTimestamp + " and " + previousTimestamp;
		}
		BookResponse a = modelMapper.map(response, BookResponse.class);
		a.setMessage(s);
		return a;
	}

	private synchronized long builTransactionId() {
		return System.currentTimeMillis();
	}

	public BookResponse get(int bookId) {
		Optional<Book> book = bookRepository.findById((long) bookId);
		if (book.isEmpty()) {
			throw new BookNotFoundException();
		}
		return modelMapper.map(book.get(), BookResponse.class);
	}

	public ChapterResponse getChapter(long bookId, long chapterId) {
		ChapterId chapterIdObj = buildChapterId(bookId, chapterId);
		Optional<Chapter> chapters = chapterRepository.findById(chapterIdObj);
		if (chapters.isEmpty()) {
			throw new ChapterNotFoundException();
		}
		return modelMapper.map(chapters.get(), ChapterResponse.class);
	}

	private ChapterId buildChapterId(long bookId, long chapterId) {
		ChapterId chapterIdObj = new ChapterId();
		chapterIdObj.setChapterNumber((int) chapterId);
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
		Optional<Content> contents = contentRepository.findById(contentIdObj);
		if (contents.isEmpty()) {
			throw new ContentNotFoundException();
		}
		return modelMapper.map(contents.get(), ContentResponse.class);
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
		chapter.setChapterNumber((int) chapterId);
		return chapter;
	}

}
