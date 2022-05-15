package com.simplilearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Books;
import com.simplilearn.entity.Review;
import com.simplilearn.service.ReviewService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/review")
public class ReviewController {

	@Autowired
	ReviewService reviewservice;
	
	@PostMapping("/add")
	public Review findbyname(@RequestBody Review review)
	{
		return reviewservice.save(review);
		        	
	}
	
	@GetMapping("/list")
	public List<Review> getAll() 
	{
		return reviewservice.getAllreview();
	}
}
