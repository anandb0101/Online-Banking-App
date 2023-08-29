package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.onlinebanking.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerId(long customerId);
	Customer findByUsername(String username);
}
