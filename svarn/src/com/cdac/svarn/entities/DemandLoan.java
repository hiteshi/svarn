package com.cdac.svarn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the DEMAND_LOAN database table.
 * 
 */
@Entity
@Table(name="DEMAND_LOAN")
public class DemandLoan extends Loan implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="ACCOUNT_NO")
//	private int accountNo;

  
	@Column(name="TIME_LIMIT")
	private int timeLimit;

    public DemandLoan() {
    }

//	public int getAccountNo() {
//		return this.accountNo;
//	}
//
//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public int getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

}