/**
 * 
 */
package com.venkat.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venkat.practice.entity.Page;

/**
 * @author VenkaT
 *
 */
//@Repository
public interface PageRepository extends CrudRepository<Page,Long>{

}
