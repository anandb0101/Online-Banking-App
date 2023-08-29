package com.wellsfargo.onlinebanking.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.PersonalDetailsService;
import com.wellsfargo.onlinebanking.service.UserService;
import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.AccountType;
import com.wellsfargo.onlinebanking.entity.Person;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
//	private int baseAccountNumber = 10000;
//	private int baseUserId = 4000;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonalDetailsService personalDetailsService;
	
	@Autowired	
	AccountService accountService;
	
	String generatePassword() {
		int len = 10;
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
		Random  rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; ++i) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		
		return sb.toString();
	}
	
	@PostMapping("/openAccount")
	public ResponseEntity<String> openAccount(@Validated @RequestBody Person newPerson) {
		//int accountNumber = ++baseAccountNumber;
		//int userId = ++baseUserId;
		
		String password = generatePassword();
		
		Customer customer = new Customer();
		customer.setPassword(password);
		customer.setUsername(newPerson.getName());
		
		Account account = new Account();
		account.setAccountType(AccountType.SAVINGS);
		account.setBalance(1000);
		account.setBranch("HYD");
		account.setIFSC("WFIS0000123");
		
		PersonalDetails personalDetails = new PersonalDetails();
		personalDetails.setName(newPerson.getName());
		personalDetails.setFatherName(newPerson.getFatherName());
		personalDetails.setEmail(newPerson.getEmail());
		personalDetails.setMobile(newPerson.getMobile());
		personalDetails.setAadhaarNumber(newPerson.getAadhaarNumber());
		personalDetails.setPan(newPerson.getPan());
		personalDetails.setCountry(newPerson.getCountry());
		personalDetails.setAddress(newPerson.getAddress());
		
		customer.setAccount(account);
		account.setUser(customer);
		
		
		customer.setPersonalDetails(personalDetails);
		personalDetails.setUser(customer);
		
		userService.createUser(customer);
		
		return new ResponseEntity<>("Account Opened", HttpStatus.OK);
		
		
//		//newPerson.setUserId(String.valueOf(userId));
//		newPerson.setPassword(password);
//		newPerson.setAccountNumber(String.valueOf(accountNumber));
		
		//Customer user = new Customer(newPerson.getUserId(), newPerson.getAccountNumber(), newPerson.getPassword());
//		
//		PersonalDetails personalDetails = new PersonalDetails(newPerson.getUserId(), newPerson.getName(),newPerson.getEmail(), newPerson.getMobile(), newPerson.getAddress(), newPerson.getGender(), newPerson.getCountry(), newPerson.getFatherName() 
//				,newPerson.getAadhaarNumber(), newPerson.getPan());
//		
//		Account account = new Account(newPerson.getUserId(), newPerson.getAccountNumber(), newPerson.getName(), newPerson.getBalance(), newPerson.getIfsc(), newPerson.getAccountType(), newPerson.getBranch());
		
		//userService.createUser(user);
//		personalDetailsService.createPersonalDetails(personalDetails);
//		accountService.createAccount(account);
//		
//		return newPerson;
	}
	

}
