package com.checkpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkpay.entity.User;
import com.checkpay.model.Response;
import com.checkpay.model.UserVO;
import com.checkpay.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/api/hello")
	public String sayHello() {
		return "Hello from Spring Boot!";
	}

	//@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/api/user")
	public String saveUser(@RequestBody UserVO user) {
		userService.saveUser(user);
		return "Hello from Spring Boot!";
	}
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	@GetMapping("/api/user/{phoneNumber}")
	public ResponseEntity<User> getDetails(@PathVariable("phoneNumber")  Long phoneNumber) {
		User user = userService.getUserByPhoneNumber(phoneNumber);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, user!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@DeleteMapping("/api/user/{phoneNumber}")
	public ResponseEntity<Response> deleteUser(@PathVariable("phoneNumber")  Long phoneNumber) {
		Response response = new Response();
		try
		{
			userService.deleteUserByPhoneNumber(phoneNumber);
			response.setSuccess(true);
			response.setMessage("Successfully delete for Phone Number="+phoneNumber);
		}
		catch(Exception e)
		{
			response.setSuccess(false);
			response.setMessage("Could not delete for Phone Number="+phoneNumber);
		}
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, response.isSuccess()?HttpStatus.OK:HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}