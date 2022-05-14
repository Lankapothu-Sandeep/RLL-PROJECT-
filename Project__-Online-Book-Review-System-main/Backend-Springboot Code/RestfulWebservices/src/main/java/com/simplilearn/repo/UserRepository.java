package com.simplilearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.entity.UserDetails;



public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	
	@Query("SELECT a FROM UserDetails a WHERE a.email = ?1")
	UserDetails findUserByEmail(String email);

}
