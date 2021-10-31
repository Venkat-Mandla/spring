package com.venkat.practice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.venkat.practice.domain.Result;
import com.venkat.practice.entity.ContentHistory;

@Repository
public interface HistoryRepository extends JpaRepository<ContentHistory, Long> {
	
	@Query("SELECT new com.venkat.practice.domain.Result(SUM(c.wordCount) /count(1) AS COUNT) FROM ContentHistory c WHERE c.chapter.book.bookId=?1")
	public Result findWordCountAvg(long bookId);
	
	@Query("SELECT new com.venkat.practice.domain.Result(MAX(wordCount)-MIN(wordCount) AS COUNT) "
			+ " FROM ContentHistory c WHERE c.chapter.book.bookId=?1 ")
	public Result findWordCountDiff(long bookId);
	
	  @Query("SELECT new com.venkat.practice.domain.Result(c.transactionId,c.updateTimestamp,SUM(c.wordCount) AS WORD_COUNT)"
	  		+ " FROM ContentHistory c WHERE c.chapter.book.bookId=?1 "
		  + " group by c.transactionId,c.updateTimestamp order by c.transactionId DESC"
		  )
	public List<Result> findStats(long bookId,Pageable pageable);
	  

	/*
	 * @Query("SELECT new com.venkat.practice.domain.Result(c.transactionId,cast(c.updateTimestamp as date),SUM(c.wordCount) AS WORD_COUNT)"
	 * + " FROM ContentHistory c WHERE c.chapter.book.bookId=?1 " +
	 * " group by c.transactionId,cast(c.updateTimestamp as date) order by c.transactionId DESC"
	 * ) public List<Result> findStats(long bookId,Pageable pageable);
	 */
	
	 

}
