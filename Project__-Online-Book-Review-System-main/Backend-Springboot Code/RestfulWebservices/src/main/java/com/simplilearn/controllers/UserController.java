package com.simplilearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Books;
import com.simplilearn.entity.UserDetails;
import com.simplilearn.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public UserDetails Login(@RequestBody UserDetails user)
	{
		String u=user.getEmail();
		UserDetails user1=userService.getUserByEmail(u);
     	if(user1!=null)
     	      return user1;
     	else
     		return null;
	}
	
	@GetMapping("/list")
	public List<UserDetails> Userdetails(){
		return userService.listAll();
		
	}
		
	@PostMapping("/update")
	public UserDetails findbyid(@RequestParam String email,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String address,@RequestParam String password,@RequestParam long phone,@RequestParam int id)
	{
	    UserDetails user =userService.FindByid(id);
		if(user!= null) {
		        user.setEmail(email);
		        user.setFirstname(firstname);
			    user.setLastname(lastname);
			    user.setAddress(address);
		        user.setPhone(phone);
		        user.setPassword(password);
		        return userService.save(user);
		}
		return user;	        	
	}
	
	@GetMapping("/get/{id}")
	public UserDetails getuserByid(@PathVariable int id)
	{
		return userService.FindByid(id);
	}

//	@PostMapping("/update")
//	public UserDetails findbyid(@RequestParam String email,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String address,@RequestParam String password,@RequestParam long phone,@RequestParam int id)
//	{
//	    UserDetails user =userService.FindByid(id);
//		if(user!= null) {
//		        user.setEmail(email);
//		        user.setFirstname(firstname);
//			    user.setLastname(lastname);
//			    user.setAddress(address);
//		        user.setPhone(phone);
//		        user.setPassword(password);
//		        return userService.save(user);
//		}
//		return user;	        	
//	}
	
	
	@PostMapping("/newregister")
	public UserDetails addUser(@RequestBody UserDetails user)
	{
		UserDetails userobj = userService.save(user);
		return userobj;
	}
	
	@PostMapping("/changepassword")
	public UserDetails ChangePassword(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		UserDetails user=userService.getUserByEmail(email);
     	if(email==user.getEmail())
			    user.setEmail(user.getEmail());
			    user.setPassword(password);
		        user.setFirstname(user.getFirstname());
		        user.setLastname(user.getLastname());
		        user.setAddress(user.getAddress());
		        user.setPhone(user.getPhone());
		        userService.save(user);
		return user;
     		
		       
	}
	
	@PostMapping("/userupdate/{id}")
	public UserDetails findbyuserid(@RequestBody UserDetails user1,@PathVariable int id)
	{
	    UserDetails user =userService.FindByid(id);
		if(user!= null) {
		        user.setEmail(user1.getEmail());
		        user.setFirstname(user1.getFirstname());
			    user.setLastname(user1.getLastname());
			    user.setAddress(user1.getAddress());
		        user.setPhone(user1.getPhone());
		        user.setPassword(user1.getPassword());
		        return userService.save(user);
		        
		}
		return user;
		
	}

}
