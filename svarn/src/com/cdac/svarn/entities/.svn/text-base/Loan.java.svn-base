package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the LOAN database table.
 * 
 */
@Entity
@Table(name="LOAN")
@Inheritance(strategy=InheritanceType.JOINED)
public class Loan extends Account implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="ACCOUNT_NO")
//	private int accountNo;

	@Column(name="AMOUNT_REMAINING")
	private Double amountRemaining;

	@Column(name="AMOUNT_SANCTIONED")
	private Double amountSanctioned;

	//bi-directional many-to-one association to LoanInterest
    @ManyToOne
	@JoinColumn(name="LOAN_TYPE_CODE")
	private LoanInterest loanInterest;

    public Loan() {
    }
//
//	public int getAccountNo() {
//		return this.accountNo;
//	}
//
//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public Double getAmountRemaining() {
		return this.amountRemaining;
	}

	public void setAmountRemaining(Double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public Double getAmountSanctioned() {
		return this.amountSanctioned;
	}

	public void setAmountSanctioned(Double amountSanctioned) {
		this.amountSanctioned = amountSanctioned;
	}

	public LoanInterest getLoanInterest() {
		return this.loanInterest;
	}

	public void setLoanInterest(LoanInterest loanInterest) {
		this.loanInterest = loanInterest;
	}
	
}