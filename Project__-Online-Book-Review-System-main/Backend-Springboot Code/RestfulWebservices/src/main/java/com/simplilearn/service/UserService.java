package com.simplilearn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.UserDetails;
import com.simplilearn.repo.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired  
    JdbcTemplate jdbc; 
	
	public UserDetails getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public List<UserDetails> listAll()
	{
		return userRepository.findAll();
	}
	
	public UserDetails save(UserDetails user) {
		return userRepository.save(user);
		
	}
	public UserDetails FindByid(int id) {
		UserDetails user=userRepository.findById(id).get();
		return user;
	}
	
}
