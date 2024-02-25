package com.checkpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.checkpay.entity.Account;
import com.checkpay.model.AccountVO;
import com.checkpay.model.Response;
import com.checkpay.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/api/account")
	public String saveAccount(@RequestBody AccountVO account) {
		accountService.saveAccount(account);
		System.out.println("Account Created - saveAccount called");
		return "Account Created - saveAccount called";
	}
	
	@GetMapping("/api/account")
	public List<Account> getAccounts(@RequestHeader HttpHeaders headers) {
		String userId = headers.getFirst("user-id");
		Long userIdLongValue = Long.valueOf(userId);
		List<Account> accounts = accountService.getAllAccounts(userIdLongValue);
		System.out.println("Accounts Get for User Id - "+userIdLongValue+" getAccounts called");
		return accounts;
	}

	@GetMapping("/api/accounts")
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountService.getAllAccounts();
		System.out.println("Accounts Get getAllAccounts called");
		return accounts;
	}

	@PutMapping("/api/account")
	public String updateAccount(@RequestBody AccountVO account) {
		accountService.saveAccount(account);
		System.out.println("Accounts Updated -  updateAccount called");
		return "Accounts Updated -  updateAccount called";
	}
	
	@DeleteMapping("/api/account/{accountId}")
	public ResponseEntity<Response> deleteUser(@PathVariable("accountId")  Long accountId) {
		Response response = new Response();
		try
		{
			accountService.deleteById(accountId);
			response.setSuccess(true);
			response.setMessage("Successfully delete for Account Id="+accountId);
		}
		catch(Exception e)
		{
			response.setSuccess(false);
			response.setMessage("Could not delete for Account Id="+accountId);
		}
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, response.isSuccess()?HttpStatus.OK:HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}