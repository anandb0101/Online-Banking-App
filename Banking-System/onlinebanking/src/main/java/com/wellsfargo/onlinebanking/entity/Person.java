package com.wellsfargo.onlinebanking.entity;

import javax.validation.constraints.*;

public class Person {
	
	private String name;
	
	private String email;
	
	private String mobile;
	private String address;
	private String gender;
	private String country;
	private long accountNumber;
	private String fatherName;
	private String aadhaarNumber;
	private String pan;
	private long balance;
	private String ifsc;
	private String branch;
	private AccountType accountType;
	
	
	
	public Person(String name, String email, String mobile, String address, String gender, String country,
			long accountNumber, String fatherName, String aadhaarNumber, String pan, long balance, String ifsc,
			String branch, AccountType accountType) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.gender = gender;
		this.country = country;
		this.accountNumber = accountNumber;
		this.fatherName = fatherName;
		this.aadhaarNumber = aadhaarNumber;
		this.pan = pan;
		this.balance = balance;
		this.ifsc = ifsc;
		this.branch = branch;
		this.accountType = accountType;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	
}