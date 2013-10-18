package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the LOAN_INTEREST database table.
 * 
 */
@Entity
@Table(name="LOAN_INTEREST")
public class LoanInterest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_TYPE_CODE")
	private int loanTypeCode;

	@Column(name="LOAN_RATE")
	private Double loanRate;

	@Column(name="LOAN_TYPE_DESCRIPTION")
	private String loanTypeDescription;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="loanInterest")
	private List<Loan> loans;

    public LoanInterest() {
    }

	public int getLoanTypeCode() {
		return this.loanTypeCode;
	}

	public void setLoanTypeCode(int loanTypeCode) {
		this.loanTypeCode = loanTypeCode;
	}

	public Double getLoanRate() {
		return this.loanRate;
	}

	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
	}

	public String getLoanTypeDescription() {
		return this.loanTypeDescription;
	}

	public void setLoanTypeDescription(String loanTypeDescription) {
		this.loanTypeDescription = loanTypeDescription;
	}

	public List<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
}