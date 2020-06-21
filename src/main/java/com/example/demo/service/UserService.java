package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void registerUser(User user)
	{
		userRepository.save(user);
	}
	
	public User findByEmail(String emailId)
	{
		return userRepository.findByEmail(emailId);
	}
}
