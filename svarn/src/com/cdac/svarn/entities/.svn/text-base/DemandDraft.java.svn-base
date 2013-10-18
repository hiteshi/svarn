package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the DEMAND_DRAFT database table.
 * 
 */
@Entity
@Table(name="DEMAND_DRAFT")
public class DemandDraft implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DD_NUMBER")
	private int ddNumber;

	@Column(name="AMOUNT")
	private Double amount;

	@Column(name="FAVOUR_OF")
	private String favourOf;

	@Column(name="ISSUE_DATE")
	private Date issueDate;

	@Column(name="PAYABLE_AT")
	private String payableAt;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;

    public DemandDraft() {
    }

	public int getDdNumber() {
		return this.ddNumber;
	}

	public void setDdNumber(int ddNumber) {
		this.ddNumber = ddNumber;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getFavourOf() {
		return this.favourOf;
	}

	public void setFavourOf(String favourOf) {
		this.favourOf = favourOf;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date date) {
		this.issueDate = date;
	}

	public String getPayableAt() {
		return this.payableAt;
	}

	public void setPayableAt(String payableAt) {
		this.payableAt = payableAt;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}