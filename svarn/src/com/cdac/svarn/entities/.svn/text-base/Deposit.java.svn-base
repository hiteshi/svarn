package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEPOSIT database table.
 * 
 */
@Entity
@Table(name="DEPOSIT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Deposit extends Account implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//bi-directional many-to-one association to DepositInterest
    @ManyToOne
	@JoinColumn(name="DEPOSIT_TYPE_CODE")
	private DepositInterest depositInterest;

    public Deposit() {
    }

//	public int getAccountNo() {
//		return this.accountNo;
//	}

//	public void setAccountNo(int accountNo) {
//		this.accountNo = accountNo;
//	}

	public DepositInterest getDepositInterest() {
		return this.depositInterest;
	}

	public void setDepositInterest(DepositInterest depositInterest) {
		this.depositInterest = depositInterest;
	}
	
}