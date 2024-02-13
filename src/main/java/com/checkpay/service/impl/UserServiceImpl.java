package com.checkpay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkpay.entity.User;
import com.checkpay.mapper.UserMapper;
import com.checkpay.model.UserVO;
import com.checkpay.repository.UserRepository;
import com.checkpay.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMappr;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User saveUser(UserVO user) {
		return userRepository.save(userMappr.mapUserVoToEntity(user));
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
