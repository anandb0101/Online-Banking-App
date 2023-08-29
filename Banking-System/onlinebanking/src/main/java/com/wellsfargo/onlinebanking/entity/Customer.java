package com.wellsfargo.onlinebanking.entity;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

//import org.hibernate.annotations.Parameter;
import javax.validation.constraints.Pattern;




@Entity
@Table(name = "customers")
public class Customer {
//	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(
//			name = "uuid",
//			strategy = "uuid2"
//			parameters = {
//					@Parameter(name="sequence_name", value = "user_sequence"),
//					@Parameter(name = "initial_value", value = "30000"),
//					@Parameter(name = "increment_size", value = "1")
//			}
//	)
//	@Column(name="cutomer_id", nullable=false)
//	private long customerId;
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
			name = "sequence-generator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name="sequence_name", value = "customer_sequence"),
					@Parameter(name = "initial_value", value = "20000"),
					@Parameter(name = "increment_size", value = "1")
			}
	)
	@Column(name = "customer_id", nullable = false)
	private long customerId;

	@Column(name = "password", nullable = false)
	private String password;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_fid")
	private Account account;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pd_fid")
	private PersonalDetails personalDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "trans_fid", referencedColumnName="customer_id")
	List<Transaction> transactions = new ArrayList<>();
	
	public Customer() {
		
		// TODO Auto-generated constructor stub
	}

	

	public Customer(String password) {
		super();
		this.password = password;

	}
	
	


	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
		
}