package com.checkpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.checkpay.entity.Account;
import com.checkpay.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("/api/accounts")
	public List<Account> getAccounts(@RequestHeader HttpHeaders headers) {
		Long userId = Long.valueOf(headers.get("user-id").toString());
		List<Account> accounts = accountService.getAllAccounts(userId);
		return accounts;
	}
}