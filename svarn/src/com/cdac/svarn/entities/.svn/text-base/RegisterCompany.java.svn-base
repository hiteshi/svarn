package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the REGISTER_COMPANY database table.
 * 
 */
@Entity
@Table(name="REGISTER_COMPANY")
public class RegisterCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGISTRATION_ID")
	private int registrationId;

	@Column(name="BRANCH_CITY")
	private String branchCity;

	@Column(name="BRANCH_NAME")
	private String branchName;

	@Column(name="BRANCH_STATE")
	private String branchState;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Column(name="CONTACT_PERSON_EMAIL")
	private String contactPersonEmail;

	@Column(name="CONTACT_PERSON_MOBILE")
	private BigInteger contactPersonMobile;

	@Column(name="CONTACT_PERSON_NAME")
	private String contactPersonName;

    public RegisterCompany() {
    }

	public int getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getBranchCity() {
		return this.branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchState() {
		return this.branchState;
	}

	public void setBranchState(String branchState) {
		this.branchState = branchState;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

}