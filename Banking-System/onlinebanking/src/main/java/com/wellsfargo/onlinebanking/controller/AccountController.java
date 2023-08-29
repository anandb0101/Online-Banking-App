package com.wellsfargo.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allAccounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Account> getAccountByCustomerId(@PathVariable long customerId) {
		Customer customer = userService.getUserByCustomerId(customerId);
		

		return ResponseEntity.ok(customer.getAccount());
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@Validated @RequestBody Account newAccount) {
		return new ResponseEntity<>(accountService.createAccount(newAccount), HttpStatus.CREATED);
	}
}

