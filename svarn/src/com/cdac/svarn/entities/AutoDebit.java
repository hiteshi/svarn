package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AUTO_DEBIT database table.
 * 
 */
@Entity
@Table(name="AUTO_DEBIT")
public class AutoDebit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTO_DEBIT_ID")
	private int autoDebitId;

	@Column(name="AMOUNT")
	private Double amount;

	@Column(name="BENEFICIARY_ACCOUNT_NO")
	private int beneficiaryAccountNo;

	@Column(name="ON_DATE")
	private int onDate;

	public int getOnDate() {
		return onDate;
	}

	@Column(name="NICK_NAME")
	private String autoNickName;
	
	@Column(name="MINIMUM_BALANCE")
	private Double minBalance;
	
	public String getAutoNickName() {
		return autoNickName;
	}

	public void setAutoNickName(String autoNickName) {
		this.autoNickName = autoNickName;
	}

	public Double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(Double minBalance) {
		this.minBalance = minBalance;
	}

	public void setOnDate(int onDate) {
		this.onDate = onDate;
	}

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;

    public AutoDebit() {
    }

	public int getAutoDebitId() {
		return this.autoDebitId;
	}

	public void setAutoDebitId(int autoDebitId) {
		this.autoDebitId = autoDebitId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getBeneficiaryAccountNo() {
		return this.beneficiaryAccountNo;
	}

	public void setBeneficiaryAccountNo(int beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}

	

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}