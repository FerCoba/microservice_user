package com.springboot.microservice.microservice_user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.microservice.microservice_user.model.entities.User;
import com.springboot.microservice.microservice_user.repository.UserInterface;

public class UserService {
	
	@Autowired
	UserInterface userInterface;
	
	public List<User> findAllUsers(){
		return null;
	}
	
	public User findUserById(Long userId) {
		return null;
	}
	
	public User createNewUser(User user) {
		return null;
	}

	public void deleteUser(Long userId) {
		
	}
}
