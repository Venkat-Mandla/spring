/**
 * 
 */
package com.venkat.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.practice.entity.Content;
import com.venkat.practice.entity.ContentId;


/**
 * @author VenkaT
 *
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, ContentId> {
	
	

}
