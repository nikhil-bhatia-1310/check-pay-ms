package com.checkpay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkpay.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findById(Long id);

	void deleteById(Long id);

	List<Account> findAllByUserId(Long userId);
}
