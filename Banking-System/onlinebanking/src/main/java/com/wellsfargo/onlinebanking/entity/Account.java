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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="accounts")
public class Account {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
			name = "sequence-generator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="sequence_name", value = "account_sequence"),
					@Parameter(name = "initial_value", value = "10000"),
					@Parameter(name = "increment_size", value = "1")
			}
	)
	@Column(name = "account_number", updatable=false, nullable=false)
    private long accountNumber;
    
	@Min(value = 10, message = "minimum balance should be 10 rupees")
	@Column(name = "balance", nullable = false)
    private long balance;
	
	@Column(name = "ifsc")
    private String IFSC;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "accountType")
    private AccountType accountType;
	
	@Column(name = "branch")
    private String branch;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
	private Customer customer;
	
    public Account() {	
		
	}
    
	public Account(@Min(value = 10, message = "minimum balance should be 10 rupees") long balance, String iFSC,
			AccountType accountType, String branch) {
		super();
		this.balance = balance;
		IFSC = iFSC;
		this.accountType = accountType;
		this.branch = branch;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
    
}
