package com.checkpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkpay.model.User;
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
    public String saveUser(@RequestBody User user) {
		com.checkpay.entity.User userEntity = new com.checkpay.entity.User(user.getPhoneNumber());
		
		userService.saveUser(userEntity);
		return "Hello from Spring Boot!";
    }
	
}