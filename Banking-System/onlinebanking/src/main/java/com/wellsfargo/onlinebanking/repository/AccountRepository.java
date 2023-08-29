package com.wellsfargo.onlinebanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Customer;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByAccountNumber(Long accountNumber);
	Account findByUser(Customer customer);
}
