package com.wellsfargo.onlinebanking.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.service.PersonalDetailsService;
import com.wellsfargo.onlinebanking.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/personalDetails")
public class PersonalDetailsController {	
	@Autowired
	PersonalDetailsService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<PersonalDetails> getByPersonalDetailsById(@PathVariable long customerId) {
		Customer customer = userService.getUserByCustomerId(customerId);
		return new ResponseEntity<>(customer.getPersonalDetails(), HttpStatus.OK);
	}
//	
//	@PostMapping("/createPersonalDetails")
//	public ResponseEntity<PersonalDetails> createPersonalDetails(@Validated @RequestBody PersonalDetails newPersonalDetails) {
//		return service.createPersonalDetails(newPersonalDetails);
//	}
//	
//	@DeleteMapping("/deletePersonalDetails")
//	public void deletePersonalDetails(@Validated @RequestBody PersonalDetails newPersonalDetails) {
//		service.deletePersonalDetails(newPersonalDetails);
//		return;
//	}
	
//	@DeleteMapping("/deleteAllPersonalDetails")
//	public void deleteAllPersonalDetails() {
//		service.deleteAllPersonalDetails();
//		return;
//	}
	
//	@DeleteMapping("/deletePersonalDetails/{userId}")
//	public void deletePersonalDetailsById(@PathVariable Integer userId) {
//		service.deletePersonalDetailsByID(userId);
//		return;
//	}
//	
//	@PutMapping("/updatePersonalDetails/{userId}")
//	public PersonalDetails updatePersonalDetailsById(@PathVariable Integer userId, @Validated @RequestBody PersonalDetails updatedPersonalDetails) {
//		return service.updatePersonalDetailsById(userId, updatedPersonalDetails);
//	}

}