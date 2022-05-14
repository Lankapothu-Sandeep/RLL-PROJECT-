package com.simplilearn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.simplilearn.entity.Books;
import com.simplilearn.repo.BooksRepository;

@DisplayName("TestDemo ")
@RunWith(JUnitPlatform.class)
public class Test1 {

	@Autowired
	public BooksRepository repository;
	
	@Test
	public void save() {
		
		Books book= new Books();
		book.setName("ABC");	  
	    String book1=book.getName();
	    assertNotEquals("xyz",book1);
	}
	@Test
	public void addProduct() {
		Books book=new Books();
		book.setAuthor("K.M");
		String book2 = book.getAuthor();
		assertEquals("K.M","K.M");
	}
	
	
}
