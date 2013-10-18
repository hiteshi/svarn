package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the OVER_DRAFT database table.
 * 
 */
@Entity
@Table(name="OVER_DRAFT")
public class OverDraft extends Loan implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="ACCOUNT_NO")
//	private int accountNo;

	@Column(name="LOAN_LIMIT")
	private BigDecimal loanLimit;

    public OverDraft() {
    }

//	public int getAccountNo() {
//		return this.accountNo;
//	}
//
//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public BigDecimal getLoanLimit() {
		return this.loanLimit;
	}

	public void setLoanLimit(BigDecimal loanLimit) {
		this.loanLimit = loanLimit;
	}

}