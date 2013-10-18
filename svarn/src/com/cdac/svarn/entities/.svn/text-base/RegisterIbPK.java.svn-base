package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REGISTER_IBS database table.
 * 
 */
@Embeddable
public class RegisterIbPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ACCOUNT_NO")
	private int accountNo;

	@Column(name="CUSTOMER_ID")
	private int customerId;

    public RegisterIbPK() {
    }
	public int getAccountNo() {
		return this.accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RegisterIbPK)) {
			return false;
		}
		RegisterIbPK castOther = (RegisterIbPK)other;
		return 
			(this.accountNo == castOther.accountNo)
			&& (this.customerId == castOther.customerId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.accountNo;
		hash = hash * prime + this.customerId;
		
		return hash;
    }
}