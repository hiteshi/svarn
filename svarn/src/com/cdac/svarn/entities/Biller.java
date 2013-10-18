package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BILLER database table.
 * 
 */
@Entity
@Table(name="BILLER")
public class Biller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILLER_ID")
	private int billerId;

	@Column(name="BILLER_ACCOUNT_NO")
	private int billerAccountNo;

	@Column(name="BILLER_NAME")
	private String billerName;

	@Column(name="BILLER_NICK_NAME")
	private String billerNickName;

	@Column(name="TRANSFER_LIMIT")
	private Double transferLimit;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;

    public Biller() {
    }

	public int getBillerId() {
		return this.billerId;
	}

	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}

	public int getBillerAccountNo() {
		return this.billerAccountNo;
	}

	public void setBillerAccountNo(int billerAccountNo) {
		this.billerAccountNo = billerAccountNo;
	}

	public String getBillerName() {
		return this.billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public String getBillerNickName() {
		return this.billerNickName;
	}

	public void setBillerNickName(String billerNickName) {
		this.billerNickName = billerNickName;
	}

	public Double getTransferLimit() {
		return this.transferLimit;
	}

	public void setTransferLimit(Double xferlimit) {
		this.transferLimit = xferlimit;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}