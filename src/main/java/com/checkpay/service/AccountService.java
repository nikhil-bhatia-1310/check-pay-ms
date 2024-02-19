package com.checkpay.service;

import java.util.List;

import com.checkpay.entity.Account;

public interface AccountService {

	public List<Account> getAllAccounts(Long userId);
}
