/**
 * 
 */
package com.venkat.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.practice.entity.Book;

/**
 * @author VenkaT
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
