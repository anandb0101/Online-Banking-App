package com.wellsfargo.onlinebanking.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.Customer;
import com.wellsfargo.onlinebanking.repository.PersonalDetailsRepository;


@Service
public class PersonalDetailsService implements IPersonalDetailsService {

	@Autowired
	PersonalDetailsRepository detailsRepo;

	@Override
	public PersonalDetails createPersonalDetails(PersonalDetails newPersonalDetails) {
		return detailsRepo.save(newPersonalDetails);
	}

	@Override
	public void deletePersonalDetails(PersonalDetails newPersonalDetails) {
		detailsRepo.delete(newPersonalDetails);
	}
	
//	@Override
//	public void deletePersonalDetailsById(long id) {
//		detailsRepo.deleteById(id);
//	}
////	
	@Override
	public PersonalDetails getPersonalDetailsByUser(Customer customer) {
		return detailsRepo.findByUser(customer);
	}

//	@Override
//	public PersonalDetails updatePersonalDetailsById(Integer id, PersonalDetails updatedPersonalDetails) {
//		PersonalDetails changedPersonalDetails = userRepo.findById(id).get();
//		
//		changedPersonalDetails.setPersonalDetailsId(updatedPersonalDetails.getPersonalDetails());
//		changedPersonalDetails.setAccountNumber(updatedPersonalDetails.getAccountNumber());
//		changedPersonalDetails.setPasscode(updatedPersonalDetails.getPasscode());
//		
//		return userRepo.save(changedPersonalDetails);
//	}
}