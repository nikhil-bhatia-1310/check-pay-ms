package com.checkpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkpay.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByPhoneNumber(Long phoneNumber);

	void deleteByPhoneNumber(Long phoneNumber);

	
}
