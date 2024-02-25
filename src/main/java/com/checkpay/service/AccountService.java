package com.checkpay.service;

import java.util.List;

import com.checkpay.entity.Account;
import com.checkpay.model.AccountVO;

public interface AccountService {

	public List<Account> getAllAccounts(Long userId);

	public void saveAccount(AccountVO account);

	public List<Account> getAllAccounts();

	public void deleteById(Long accountId);
}
