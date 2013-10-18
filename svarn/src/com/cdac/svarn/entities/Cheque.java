package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CHEQUE database table.
 * 
 */
@Entity
@Table(name="CHEQUE")
public class Cheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CHEQUE_NO")
	private int chequeNo;

    @Temporal( TemporalType.DATE)
	@Column(name="ISSUE_DATE")
	private Date issueDate;

	@Column(name="PAID_NOTPAID")
	private String paidNotpaid;

	@Column(name="PAYABLE_TO")
	private String payableTo;

	//bi-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private Account account;

    public Cheque() {
    }

	public int getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getPaidNotpaid() {
		return this.paidNotpaid;
	}

	public void setPaidNotpaid(String paidNotpaid) {
		this.paidNotpaid = paidNotpaid;
	}

	public String getPayableTo() {
		return this.payableTo;
	}

	public void setPayableTo(String payableTo) {
		this.payableTo = payableTo;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}