package com.springboot.microservice.microservice_user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.microservice.microservice_user.repository.IUserRepository;
import com.springboot.microservice.servicec_commons.model.entities.User;

@Service
public class UserService {
	
	@Autowired
	IUserRepository iUserRepository;
	
	public List<User> findAllUsers(){
		return iUserRepository.findAll();
	}
	
	public User findUserByUserName(String userName) {
		return iUserRepository.findByUserName(userName);
	}
	
	@Transactional
	public User createNewUser(User user) {
		return iUserRepository.save(user);
	}

	@Transactional
	public void deleteUserByUserId(Long userId) {
		iUserRepository.deleteById(userId);
	}
}
