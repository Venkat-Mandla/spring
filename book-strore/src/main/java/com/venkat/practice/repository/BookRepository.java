/**
 * 
 */
package com.venkat.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venkat.practice.entity.Book;

/**
 * @author VenkaT
 *
 */
//@Repository
public interface BookRepository extends CrudRepository<Book,Long>{

}
