package com.cdac.svarn.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the DEPOSIT_INTEREST database table.
 * 
 */
@Entity
@Table(name="DEPOSIT_INTEREST")
public class DepositInterest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPOSIT_TYPE_CODE")
	private int depositTypeCode;

	@Column(name="DEPOSIT_RATE")
	private Double depositRate;

	@Column(name="DEPOSIT_TYPE_DESCRIPTION")
	private String depositTypeDescription;

	//bi-directional many-to-one association to Deposit
	@OneToMany(mappedBy="depositInterest")
	private List<Deposit> deposits;

    public DepositInterest() {
    }

	public int getDepositTypeCode() {
		return this.depositTypeCode;
	}

	public void setDepositTypeCode(int depositTypeCode) {
		this.depositTypeCode = depositTypeCode;
	}

	public Double getDepositRate() {
		return this.depositRate;
	}

	public void setDepositRate(Double depositRate) {
		this.depositRate = depositRate;
	}

	public String getDepositTypeDescription() {
		return this.depositTypeDescription;
	}

	public void setDepositTypeDescription(String depositTypeDescription) {
		this.depositTypeDescription = depositTypeDescription;
	}

	public List<Deposit> getDeposits() {
		return this.deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}
	
}