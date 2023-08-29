package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.Customer;

public interface IPersonalDetailsService {

	PersonalDetails createPersonalDetails(PersonalDetails newPersonalDetails);

	void deletePersonalDetails(PersonalDetails personalDetails);

//	void deletePersonalDetailsById(long id);

	

//	PersonalDetails updatePersonalDetailsById(long id, PersonalDetails updatedPersonalDetails);

	PersonalDetails getPersonalDetailsByUser(Customer customer);

}
