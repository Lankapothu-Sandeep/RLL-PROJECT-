package com.simplilearn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplilearn.entity.Books;
import com.simplilearn.repo.BooksRepository;


@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class BookTest {
	
	@Autowired
	BooksRepository brepo;
	
	@Test
	@Order(1)
	public void addBooks() {
		Books book=new Books();
		book.setId(2);
		book.setName("JAVA");
		book.setPrice(200);
		book.setAuthor("K.M");
		book.setCategory("marathi");
		book.setSeller("Amazon");
		
		brepo.save(book);
		assertNotNull(brepo.findAll());
		
	}
	
	@Test
	@Order(2)
	public void getBookTest(){

	   Books book = brepo.findById(2).get();

	   brepo.save(book);
	   assertThat(book.getId()).isEqualTo(2);

	}
	
}

