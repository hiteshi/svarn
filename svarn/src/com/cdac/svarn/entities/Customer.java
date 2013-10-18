package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private int customerId;

    @Temporal( TemporalType.DATE)
	@Column(name="CUST_DOB")
	private Date custDob;

	@Column(name="CUST_EMAIL")
	private String custEmail;

	@Column(name="CUST_FATHER_NAME")
	private String custFatherName;

	@Column(name="CUST_FIRST_NAME")
	private String custFirstName;

	@Column(name="CUST_GENDER")
	private String custGender;

	@Column(name="CUST_LAST_NAME")
	private String custLastName;

	@Column(name="CUST_MOBILE")
	private BigInteger custMobile;

	@Column(name="CUST_MOTHER_NAME")
	private String custMotherName;

	@Column(name="CUST_PHONE")
	private BigInteger custPhone;

	//bi-directional many-to-many association to Account
	@ManyToMany(mappedBy="customers", cascade={CascadeType.ALL})
	private List<Account> accounts;

	//bi-directional many-to-many association to Address
    @ManyToMany
	@JoinTable(
		name="ADDRESS_CUSTOMER"
		, joinColumns={
			@JoinColumn(name="CUSTOMER_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ADDRESS_ID")
			}
		)
	private List<Address> addresses;

	//bi-directional many-to-one association to Ib
	@OneToMany(mappedBy="customer")
	private List<Ib> ibs;

    public Customer() {
    }

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getCustDob() {
		return this.custDob;
	}

	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustFatherName() {
		return this.custFatherName;
	}

	public void setCustFatherName(String custFatherName) {
		this.custFatherName = custFatherName;
	}

	public String getCustFirstName() {
		return this.custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustGender() {
		return this.custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public String getCustLastName() {
		return this.custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public BigInteger getCustMobile() {
		return this.custMobile;
	}

	public void setCustMobile(BigInteger custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustMotherName() {
		return this.custMotherName;
	}

	public void setCustMotherName(String custMotherName) {
		this.custMotherName = custMotherName;
	}

	public BigInteger getCustPhone() {
		return this.custPhone;
	}

	public void setCustPhone(BigInteger custPhone) {
		this.custPhone = custPhone;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Ib> getIbs() {
		return this.ibs;
	}

	public void setIbs(List<Ib> ibs) {
		this.ibs = ibs;
	}
	
}