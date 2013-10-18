package com.cdac.svarn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the THIRD_PARTY database table.
 * 
 */
@Entity
@Table(name="THIRD_PARTY")
public class ThirdParty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="THIRD_PARTY_ID")
	private int thirdPartyId;

	@Column(name="TP_ACCOUNT_NO")
	private int tpAccountNo;

	@Column(name="TP_NAME")
	private String tpName;

	@Column(name="TP_NICK_NAME")
	private String tpNickName;

	@Column(name="TRANSFER_LIMIT")
	private Double transferLimit;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;

    public ThirdParty() {
    }

	public int getThirdPartyId() {
		return this.thirdPartyId;
	}

	public void setThirdPartyId(int thirdPartyId) {
		this.thirdPartyId = thirdPartyId;
	}

	public int getTpAccountNo() {
		return this.tpAccountNo;
	}

	public void setTpAccountNo(int tpAccountNo) {
		this.tpAccountNo = tpAccountNo;
	}

	public String getTpName() {
		return this.tpName;
	}

	public void setTpName(String tpName) {
		this.tpName = tpName;
	}

	public String getTpNickName() {
		return this.tpNickName;
	}

	public void setTpNickName(String tpNickName) {
		this.tpNickName = tpNickName;
	}

	public Double getTransferLimit() {
		return this.transferLimit;
	}

	public void setTransferLimit(Double transferLimit) {
		this.transferLimit = transferLimit;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}