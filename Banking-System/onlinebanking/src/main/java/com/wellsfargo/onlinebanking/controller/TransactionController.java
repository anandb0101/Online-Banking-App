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
import com.wellsfargo.onlinebanking.entity.Transaction;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.TransactionService;
import com.wellsfargo.onlinebanking.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transService;

	@Autowired
	AccountService accountService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("{accountNumber}/transactions")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountNumber) {
		return new ResponseEntity<>(transService.getTransactions(accountNumber, accountNumber), HttpStatus.OK); 
	}
	
	@GetMapping("/{refId}")
	public ResponseEntity<Optional<Transaction>> getTransaction(@PathVariable long refId) {
		return new ResponseEntity<>(transService.getTransaction(refId), HttpStatus.OK);
	}
	
	@PostMapping("/executeTransaction")
	public ResponseEntity<String> executeTransaction(@Validated @RequestBody Transaction transaction) {


		Account sender = accountService.getAccountByAccountNumber(transaction.getFromAccount());
		Account receiver = accountService.getAccountByAccountNumber(transaction.getToAccount());
		
    	
		if(receiver==null || sender == null)
			throw new Error("Incorrect receiver/sender account number");
		if(accountService.getAccountByAccountNumber(transaction.getFromAccount()).getBalance() < transaction.getAmount()) {

			throw new Error("Insufficient Balance");
		}

		
		sender.setBalance(sender.getBalance()-transaction.getAmount());
		receiver.setBalance(receiver.getBalance()+transaction.getAmount());
		
		accountService.updateAccount(receiver);
		accountService.updateAccount(sender);
		transService.createTransaction(transaction);
		
		return new ResponseEntity<>("Successfully transfered", HttpStatus.OK);
	}

	
	
}
