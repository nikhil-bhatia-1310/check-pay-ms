package com.checkpay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkpay.entity.Account;
import com.checkpay.entity.User;
import com.checkpay.model.AccountVO;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findById(Long id);

	void deleteById(Long id);

	List<Account> findAllByUser(User user);

	void save(AccountVO account);
}
