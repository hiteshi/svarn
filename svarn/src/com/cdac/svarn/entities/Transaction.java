package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.math.BigDecimal;


/**
 * The persistent class for the TRANSACTION database table.
 * 
 */
@Entity
@Table(name="TRANSACTION")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private int transactionId;

	@Column(name="CREDIT_DEBIT")
	private String creditDebit;

	@Column(name="REMARKS")
	private String remarks;

	@Column(name="TRANSACTION_AMOUNT")
	private Double transactionAmount;

	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;

	@Column(name="TRANSACTION_REFERENCE")
	private int transactionReference;

	@Column(name="TRANSACTION_TYPE")
	private String transactionType;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;

    public Transaction() {
    }

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getCreditDebit() {
		return this.creditDebit;
	}

	public void setCreditDebit(String creditDebit) {
		this.creditDebit = creditDebit;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(Double amnt) {
		this.transactionAmount = amnt;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date date) {
		this.transactionDate = date;
	}

	public int getTransactionReference() {
		return this.transactionReference;
	}

	public void setTransactionReference(int transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}