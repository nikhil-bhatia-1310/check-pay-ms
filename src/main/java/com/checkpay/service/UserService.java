package com.checkpay.service;

import java.util.List;

import com.checkpay.entity.User;
import com.checkpay.model.UserVO;

public interface UserService {

	public List<User> getAllUsers();

	public User getUserById(Long id);
	
	public User getUserByPhoneNumber(Long phoneNumber);

	public User saveUser(UserVO user);

	public void deleteUser(Long id);

	public void deleteUserByPhoneNumber(Long phoneNumber);
}
