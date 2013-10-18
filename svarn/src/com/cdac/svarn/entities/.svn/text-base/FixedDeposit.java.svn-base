package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the FIXED_DEPOSIT database table.
 * 
 */
@Entity
@Table(name="FIXED_DEPOSIT")
public class FixedDeposit extends Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="ACCOUNT_NO")
//	private int accountNo;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_MATURITY")
	private Date dateOfMaturity;

    public FixedDeposit() {
    }

//	public int getAccountNo() {
//		return this.accountNo;
//	}
//
//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public Date getDateOfMaturity() {
		return this.dateOfMaturity;
	}

	public void setDateOfMaturity(Date dateOfMaturity) {
		this.dateOfMaturity = dateOfMaturity;
	}

}