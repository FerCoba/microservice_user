package com.springboot.microservice.microservice_user.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.microservice_user.model.entities.User;
import com.springboot.microservice.microservice_user.response.Response;
import com.springboot.microservice.microservice_user.services.UserService;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {

	@Autowired
	UserService userService;

	private static final String ENTRY_METHOD_MESSAGE = "entry in method {}.";
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private static final String EXCEPTION_MESSAGE = "in the method {} occurred the next exception : {}";

	@GetMapping(path = "/obtainInformationAllUsers")
	public ResponseEntity<Response> obtainInformationAllUsers() {

		List<User> users = new ArrayList<>();

		try {
			users = userService.findAllUsers();

		} catch (Exception e) {
			LOGGER.error(EXCEPTION_MESSAGE, ENTRY_METHOD_MESSAGE, e.getMessage());
		}

		return users.isEmpty()
				? new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK), "No data found", null),
						HttpStatus.OK)
				: new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK), null, users), HttpStatus.OK);
	}

	@GetMapping(path = "/userName/{userName}/userInformation")
	public ResponseEntity<Response> findUserById(@PathVariable("userName") String userName) {
		User user = new User();

		try {
			user = userService.findUserByUserName(userName);
		} catch (Exception e) {
			LOGGER.error(EXCEPTION_MESSAGE, ENTRY_METHOD_MESSAGE, e.getMessage());
		}

		return user == null
				? new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK), "No data found", null),
						HttpStatus.OK)
				: new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK), null, user), HttpStatus.OK);
	}

	@PostMapping(path = "/createNewUser")
	public ResponseEntity<Response> createNewUser(@RequestBody User userParameters) {
		User user = new User();
		try {
			user = userService.createNewUser(userParameters);
		} catch (Exception e) {
			LOGGER.error(EXCEPTION_MESSAGE, e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}
		return user == null
				? new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK), "No data found", null),
						HttpStatus.OK)
				: new ResponseEntity<>(new Response(String.valueOf(HttpStatus.OK), null, user), HttpStatus.OK);
	}

	@DeleteMapping(path = "userId/{userId}/deleteUser")
	public ResponseEntity<Response> deleteUser(@PathVariable("userId") Long userId) {

		try {
				userService.deleteUserByUserId(userId);
		} catch (Exception e) {
			LOGGER.error(EXCEPTION_MESSAGE, e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}
		return new ResponseEntity<>(
				new Response(String.valueOf(HttpStatus.NO_CONTENT), "product deleted successfully.", null),
				HttpStatus.NO_CONTENT);
	}
}
