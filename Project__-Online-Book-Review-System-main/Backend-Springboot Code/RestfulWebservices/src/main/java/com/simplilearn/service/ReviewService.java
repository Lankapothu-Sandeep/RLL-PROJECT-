package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Books;
import com.simplilearn.entity.Review;
import com.simplilearn.repo.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewrepo;
	
	public Review save(Review review){
		return reviewrepo.save(review);
		
	}
	public List<Review> getAllreview() {
		return reviewrepo.findAll();
	}

	
}
