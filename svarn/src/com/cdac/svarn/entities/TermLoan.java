package com.cdac.svarn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the TERM_LOAN database table.
 * 
 */
@Entity
@Table(name="TERM_LOAN")
public class TermLoan extends Loan implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="ACCOUNT_NO")
//	private int accountNo;

	@Column(name="PERIOD_OF_PREMIUM")
	private int periodOfPremium;

	@Column(name="PREMIUM")
	private Double premium;

    public TermLoan() {
    }

//	public int getAccountNo() {
//		return this.accountNo;
//	}
//
//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public int getPeriodOfPremium() {
		return this.periodOfPremium;
	}

	public void setPeriodOfPremium(int periodOfPremium) {
		this.periodOfPremium = periodOfPremium;
	}

	public Double getPremium() {
		return this.premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

}