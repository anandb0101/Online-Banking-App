package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.Customer;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {

	PersonalDetails findByUser(Customer customer);

}