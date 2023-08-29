package com.wellsfargo.onlinebanking.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "refId", nullable=false, updatable=false)
	private long refId;
	
	@Pattern(regexp = "^[0-9]{5}$")
	@Column(name = "from_account")
	private long fromAccount;
	
	@Pattern(regexp = "^[0-9]{5}$")
	@Column(name = "to_account")
	private long toAccount;
	
	@Min(value=1, message="amount should be greater than 1 rupee")
	@Column(name = "amount", nullable = false, updatable = false)
	private long amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="mode")
	private TransactionMode mode;
	
	@Column(name = "timestamp")
	private LocalDate timestamp;
	
	@Column(name = "remark")
	private String remark;
	
	public Transaction() {
		super();
	}
	
	
	public Transaction(@Pattern(regexp = "^[0-9]{5}$") long fromAccount, @Pattern(regexp = "^[0-9]{5}$") long toAccount,
			@Min(value = 1, message = "amount should be greater than 1 rupee") long amount, TransactionMode mode,
			LocalDate timestamp, String remark) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.mode = mode;
		this.timestamp = timestamp;
		this.remark = remark;
	}


	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public TransactionMode getMode() {
		return mode;
	}

	public void setMode(TransactionMode mode) {
		this.mode = mode;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
