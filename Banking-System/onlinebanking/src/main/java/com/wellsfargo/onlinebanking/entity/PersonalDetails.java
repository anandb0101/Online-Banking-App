package com.wellsfargo.onlinebanking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "personal_details")
public class PersonalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;
	
//	@Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")
	
	@Email
	@NotBlank
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotBlank
	@Column(name = "father_name", nullable = false)
	private String fatherName;
	
	
	@Pattern(regexp = "^$|^[0-9]{12}$")
	@Column(name = "aadhaar_number")
	private String aadhaarNumber;
	
	@Pattern(regexp = "^$|^[A-Z]{5}[0-9]{4}[A-Z]{1}$")
	@Column(name = "pan")
	private String pan;
	
	@NotBlank
	@Pattern(regexp = "^$|^[0-9]{10}$")
	@Column(name="mobile", nullable = false)
	private String mobile;
	
	@Column(name = "address")
	private String address;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "country")
	private String country;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="personalDetails")
	private Customer customer;
	
	public PersonalDetails() {
		
	}
	

	public PersonalDetails(@NotBlank String name, @Email @NotBlank String email, @NotBlank String fatherName,
			@Pattern(regexp = "^$|^[0-9]{12}$") String aadhaarNumber,
			@Pattern(regexp = "^$|^[A-Z]{5}[0-9]{4}[A-Z]{1}$") String pan,
			@NotBlank @Pattern(regexp = "^$|^[0-9]{10}$") String mobile, String address, Gender gender,
			String country) {
		super();
		this.name = name;
		this.email = email;
		this.fatherName = fatherName;
		this.aadhaarNumber = aadhaarNumber;
		this.pan = pan;
		this.mobile = mobile;
		this.address = address;
		this.gender = gender;
		this.country = country;
	}
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
