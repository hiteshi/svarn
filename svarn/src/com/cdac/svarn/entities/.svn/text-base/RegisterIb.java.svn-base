package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the REGISTER_IBS database table.
 * 
 */
@Entity
@Table(name="REGISTER_IBS")
public class RegisterIb implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegisterIbPK id;

    @Temporal( TemporalType.DATE)
	@Column(name="APPLIED_ON")
	private Date appliedOn;

/*	@Column(name="CUSTOMER_ID")
	private int customerId;*/

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="MOBILE_NO")
	private BigInteger mobileNo;

    public RegisterIb() {
    }

	public RegisterIbPK getId() {
		return this.id;
	}

	public void setId(RegisterIbPK id) {
		this.id = id;
	}
	
	public Date getAppliedOn() {
		return this.appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}
/*
	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}*/

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public BigInteger getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}

}