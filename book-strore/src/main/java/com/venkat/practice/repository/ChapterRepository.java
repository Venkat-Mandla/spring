/**
 * 
 */
package com.venkat.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.practice.entity.Chapter;
import com.venkat.practice.entity.ChapterId;

/**
 * @author VenkaT
 *
 */
@Repository
public interface ChapterRepository extends JpaRepository<Chapter,ChapterId>{

}
