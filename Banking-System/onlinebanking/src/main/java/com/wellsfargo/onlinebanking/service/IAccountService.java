package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Customer;


public interface IAccountService {

	Account createAccount(Account newAccount);

	List<Account> getAllAccounts();
	
	Account getAccountByUser(Customer customer);
	
	Account getAccountByAccountNumber(long accountNumber);
	
	Account updateAccount(Account updatedAccount);

}
