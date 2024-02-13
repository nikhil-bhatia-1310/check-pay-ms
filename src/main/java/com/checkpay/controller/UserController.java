package com.checkpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkpay.model.UserVO;
import com.checkpay.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/api/hello")
	public String sayHello() {
		return "Hello from Spring Boot!";
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/api/user")
	public String saveUser(@RequestBody UserVO user) {

		userService.saveUser(user);
		return "Hello from Spring Boot!";
	}

}