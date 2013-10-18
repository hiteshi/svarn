package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IBS database table.
 * 
 */
@Entity
@Table(name="IBS")
public class Ib implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NAME")
	private String userName;

    @Temporal( TemporalType.DATE)
	@Column(name="CLOSING_DATE")
	private Date closingDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="LATEST_LOGIN_DATE")
	private Date latestLoginDate;

    @Temporal( TemporalType.DATE)
	@Column(name="OPENING_DATE")
	private Date openingDate;

	@Column(name="OTP")
	private String otp;

	@Column(name="TRANSACTION_PASSWORD")
	private String transactionPassword;

	@Column(name="USER_PASSWORD")
	private String userPassword;

	//bi-directional many-to-many association to Account
	@ManyToMany(mappedBy="ibs",fetch=FetchType.EAGER)
	private List<Account> accounts;

	//bi-directional many-to-one association to Customer
    @ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

    public Ib() {
    }

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getClosingDate() {
		return this.closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getLatestLoginDate() {
		return this.latestLoginDate;
	}

	public void setLatestLoginDate(Date latestLoginDate) {
		this.latestLoginDate = latestLoginDate;
	}

	public Date getOpeningDate() {
		return this.openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getTransactionPassword() {
		return this.transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}