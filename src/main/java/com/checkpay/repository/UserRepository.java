package com.checkpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkpay.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
