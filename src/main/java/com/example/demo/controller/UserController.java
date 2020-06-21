package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users/sign-up",method = RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		try {
			User existingUser = userService.findByEmail(user.getEmail());
			if( existingUser != null ) {
				return "user already registered";
			}
			userService.registerUser(user);
			return "user registered successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "registration failed";
	}
	
	@RequestMapping(value = "/users/login",method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		try {
			User existingUser = userService.findByEmail(user.getEmail());
			if (existingUser == null) {
				return "login failed";
			} else {
				if (existingUser.getPassword().equals(user.getPassword())) {
					return "login Successful";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login failed.Please check your emailId and password";
	}
	
}
