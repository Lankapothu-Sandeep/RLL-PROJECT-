package com.simplilearn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplilearn.entity.UserDetails;
import com.simplilearn.repo.UserRepository;

@SpringBootTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)

public class UserTest {
	
	@Autowired
	UserRepository urepo;

	@Test
	@Order(1)
	public void saveUserTest(){

		UserDetails user=new UserDetails();
        user.setFirstname("supriya");
        user.setLastname("patil");
        user.setEmail("supriya@gmail.com");
        user.setAddress("solapur");
        user.setPassword("sa123");
        user.setId(2);
        user.setPhone(987665433);

        urepo.save(user);

        assertNotNull(urepo.findAll());
    }
	
	@Test
	@Order(2)
	 public void getUserTest(){

        UserDetails s = urepo.findById(2).get();

        assertThat(s.getId()).isEqualTo(2);

    }

	@Test
	@Order(3)
	public void UserUpdate() throws Exception {
	  
		UserDetails updateuser = urepo.findById(1).get();
		updateuser.setFirstname("supriya");
     
		urepo.save(updateuser);
     
		assertThat(updateuser.getFirstname().equals("supriya"));
	}
	
}
