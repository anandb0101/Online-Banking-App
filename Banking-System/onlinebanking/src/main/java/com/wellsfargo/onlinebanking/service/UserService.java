package com.wellsfargo.onlinebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.repository.CustomerRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	CustomerRepository userRepo;

	@Override
	public Customer getUserByCustomerId(long customerId) {
		return userRepo.findByCustomerId(customerId);
	}

	@Override
	public List<Customer> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Customer createUser(Customer newUser) {
		return userRepo.save(newUser);
	}

	@Override
	public void deleteUser(Customer newUser) {
		userRepo.delete(newUser);
	}
	
//	@Override
//	public void deleteUserByUserId(String userId) {
//		userRepo.deleteById(userId);
//	}

	@Override
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}

//	@Override
//	public Customer updateUserByUserId(String userId, Customer updatedUser) {
//		Customer changedUser = userRepo.findByUserId(userId);
//		
//		changedUser.setPassword(updatedUser.getPassword());
//		
//		return userRepo.save(changedUser);
//	}
}