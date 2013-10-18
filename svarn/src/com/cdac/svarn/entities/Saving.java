package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SAVING database table.
 * 
 */
@Entity
@Table(name="SAVING")
public class Saving extends Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="ACCOUNT_NO")
//	private int accountNo;

	@Column(name="INTEREST_AMOUNT")
	private Double interestAmount;

    @Temporal( TemporalType.DATE)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

    public Saving() {
    }
//
//	public int getAccountNo() {
//		return this.accountNo;
//	}
//
//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public Double getInterestAmount() {
		return this.interestAmount;
	}

	public void setInterestAmount(Double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}