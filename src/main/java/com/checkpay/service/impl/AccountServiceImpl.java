package com.checkpay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkpay.entity.Account;
import com.checkpay.mapper.AccountMapper;
import com.checkpay.repository.AccountRepository;
import com.checkpay.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountMapper accountMappr;

	@Override
	public List<Account> getAllAccounts(Long userId) {
		return accountRepository.findAllByUserId(userId);
	}
}
