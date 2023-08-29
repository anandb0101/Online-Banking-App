package com.wellsfargo.onlinebanking.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.service.UserService;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Customer>> getAllUsers() {
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(userService.getAllUsers());
	}
	
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getUserByUserID(@PathVariable long customerId) {
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(userService.getUserByCustomerId(customerId));
		
	}
	
	
	
	@PostMapping("/createUser")
	public ResponseEntity<Customer> createUser(@Validated @RequestBody Customer newUser) {
		return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
		
	}
	
//	@DeleteMapping("delete/{userId}")
//	public ResponseEntity<String> deleteUser(@PathVariable long userId) {
//		userService.deleteUserByUserId(userId);
//		return new ResponseEntity<>("deleted", HttpStatus.OK);
//		
//	}

//	
//	@PutMapping("/updateUser/{id}")
//	public Customer updateUserById(@PathVariable Integer id, @Validated @RequestBody Customer updatedUser) {
//		return userService.updateUserById(id, updatedUser);
//	}
}