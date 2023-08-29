package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.repository.AccountRepository;

@Service
public class AccountService implements IAccountService{

	
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public Account getAccountByAccountNumber(long accountNumber) {
		return accountRepo.findByAccountNumber(accountNumber);
	}
	
	@Override
	public Account getAccountByUser(Customer customer) {
		return accountRepo.findByUser(customer);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	
	@Override
	public Account createAccount(Account newAccount) {
	
		return accountRepo.save(newAccount);
	}
	
	@Override
	public Account updateAccount(Account updatedAccount) {
		return accountRepo.save(updatedAccount);
	}

}
