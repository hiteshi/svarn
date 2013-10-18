package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the REGISTER_LOAN database table.
 * 
 */
@Entity
@Table(name="REGISTER_LOAN")
public class RegisterLoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGISTRATION_ID")
	private int registrationId;

	@Column(name="SPECIFIC_TYPE")
	private String specificType;
	
	public String getSpecificType() {
		return specificType;
	}

	public void setSpecificType(String specificType) {
		this.specificType = specificType;
	}

	@Column(name="ADDRESS_LINE1")
	private String addressLine1;

	@Column(name="ADDRESS_LINE2")
	private String addressLine2;

	@Column(name="AMOUNT_REQUIRED")
	private double amountRequired;

	@Column(name="BRANCH_NAME")
	private String branchName;

	@Column(name="CITY")
	private String city;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="FATHER_NAME")
	private String fatherName;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="FORM")
	private String form;

	@Column(name="GENDER")
	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LOAN_TYPE")
	private String loanType;

	@Column(name="MOBILE_NO")
	private BigInteger mobileNo;

	@Column(name="MOTHER_NAME")
	private String motherName;

	@Column(name="PAN_CARD")
	private String panCard;

	@Column(name="PERIOD_OF_PREMIMUM")
	private int periodOfPremimum;

	@Column(name="PIN_CODE")
	private int pinCode;

	@Column(name="PREMIUM")
	private double premium;

	@Column(name="STATE")
	private String state;

	@Column(name="TIME_LIMIT")
	private int timeLimit;

    public RegisterLoan() {
    }

	public int getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public double getAmountRequired() {
		return this.amountRequired;
	}

	public void setAmountRequired(double amountRequired) {
		this.amountRequired = amountRequired;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoanType() {
		return this.loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public BigInteger getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPanCard() {
		return this.panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public int getPeriodOfPremimum() {
		return this.periodOfPremimum;
	}

	public void setPeriodOfPremimum(int periodOfPremimum) {
		this.periodOfPremimum = periodOfPremimum;
	}

	public int getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public double getPremium() {
		return this.premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

}