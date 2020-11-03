package com.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.omg.CORBA.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Response;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;
import com.ecom.services.FieldValidator;

@CrossOrigin(value = "*")
@RestController
public class UserController 
{
	@Autowired
	UserRepository userRepo;
	
	
	
	@PostMapping("/addUser")
	public Object addUser(@RequestBody User user) {
		if(userRepo.findById(user.getId()).isPresent()) {
			return new Response("User already present", "error");
		}
		else if(! new FieldValidator().isEmail(user.getEmail())) {
			return new Response("invalid email format", "error");
		}
		else if(!new FieldValidator().isStringEmpty(user.getName()) || !new FieldValidator().isPureString(user.getName())) {
			return new Response("invalid user name", "error");
		}
		else if(user.getPassword().trim().length()<6) {
			return new Response("password contain min  6 character", "error");
		}
		else {
			userRepo.save(user);
			return new Response("user added", "success");
		}
	}
	
	@GetMapping("/getUser/{userId}")
	public Object getUser(@PathVariable String userId) {
		Optional<User> user = userRepo.findById(userId);
		
		if(user.isPresent()) return user;	
		else return new Response("User Not Found", "error");
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	
	
	@PostMapping("/updateUser")
	public Object updateUser(@RequestBody User user)
	{
		if(! userRepo.findById(user.getId()).isPresent()) 
		{

			return new Response("No Such User", "error");
		}
		
	
		else if(! new FieldValidator().isEmail(user.getEmail())) {
			return new Response("invalid email format", "error");
		}
		else if(!new FieldValidator().isStringEmpty(user.getName()) || !new FieldValidator().isPureString(user.getName())) {
			return new Response("invalid user name", "error");
		}
		else if(user.getPassword().trim().length()<6) {
			return new Response("password contain min  6 character", "error");
		}
		else {
			userRepo.save(user);
			return new Response("user updated", "success");
		}
		
		
	}
	
	@PostMapping("/deleteUser")
	public Object deleteUser(@RequestBody User user) {
		if(userRepo.findById(user.getId()).isPresent()) 
		{
			userRepo.delete(user);
			return new Response("user deleted", "success");
			
		}
		else return new Response("no such user", "error");
		
	}



	
	
}
