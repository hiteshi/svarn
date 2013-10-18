package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the COMPANY database table.
 * 
 */
@Entity
@Table(name="COMPANY")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMPANY_ID")
	private int companyId;

	@Column(name="CONTACT_PERSON_EMAIL")
	private String contactPersonEmail;

	@Column(name="CONTACT_PERSON_MOBILE")
	private BigInteger contactPersonMobile;

	@Column(name="CONTACT_PERSON_NAME")
	private String contactPersonName;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-many association to Account
	@ManyToMany(mappedBy="companies")
	private List<Account> accounts;

    public Company() {
    }

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getContactPersonEmail() {
		return this.contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public BigInteger getContactPersonMobile() {
		return this.contactPersonMobile;
	}

	public void setContactPersonMobile(BigInteger contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	public String getContactPersonName() {
		return this.contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}