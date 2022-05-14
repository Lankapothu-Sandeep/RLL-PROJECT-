package com.simplilearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Books;



@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
 
	@Query("SELECT u FROM Books u WHERE u.name = ?1")
	Books Findbyname(String name);
	
	@Query("SELECT u FROM Books u WHERE u.category = ?1")
	Books findbycategory(String category);
	
}
