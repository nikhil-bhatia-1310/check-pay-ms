package com.checkpay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkpay.entity.Account;
import com.checkpay.entity.User;
import com.checkpay.mapper.AccountMapper;
import com.checkpay.model.AccountVO;
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
		User user = new User();
		user.setId(userId);
		List<Account> accounts = accountRepository.findAllByUser(user);
		return accounts;
	}

	@Override
	public void saveAccount(AccountVO accountVO) {
		
		Account account = new Account();
		account.setAccountNumber(accountVO.getAccountNumber());
		account.setBank(accountVO.getBank());
		account.setIfscCode(accountVO.getIfscCode());
		account.setStatus(accountVO.getStatus());
		account.setId(accountVO.getId()!=null?accountVO.getId():null);
		User user = new User();
		user.setId(accountVO.getUserId());
		account.setUser(user);
		accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}

	@Override
	public void deleteById(Long accountId) {
		accountRepository.deleteById(accountId);
	}
}
