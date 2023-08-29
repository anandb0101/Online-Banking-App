package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.Customer;

public interface IUserService {

	
	

	List<Customer> getAllUsers();

	Customer createUser(Customer newUser);
  
	void deleteUser(Customer customer);
	
	void deleteAllUsers();
//	Customer updateUserByUserId(String userId, Customer updatedUser);
//
//	void deleteUserByUserId(String userId);

	Customer getUserByCustomerId(long customerId);
}