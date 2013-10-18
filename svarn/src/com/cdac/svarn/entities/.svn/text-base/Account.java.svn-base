package com.cdac.svarn.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name="ACCOUNT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ACCOUNT_NO")
	private int accountNo;

	@Column(name="ACCOUNT_TYPE")
	private String accountType;

	@Column(name="CURRENT_BALANCE")
	private Double currentBalance;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_CLOSE")
	private Date dateOfClose;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_OPEN")
	private Date dateOfOpen;

	@Column(name="NICK_NAME")
	private String nickName;
	
	@Column(name="ACTIVE_INACTIVE")
	private String activeInactive;

	//bi-directional many-to-many association to Customer
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="ACCOUNT_CUSTOMER"
		, joinColumns={
			@JoinColumn(name="ACCOUNT_NO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CUSTOMER_ID")
			}
		)
	private List<Customer> customers;

	//bi-directional many-to-one association to Cheque
	@OneToMany(mappedBy="account")
	private List<Cheque> cheques;

	//bi-directional many-to-one association to DemandDraft
	@OneToMany(mappedBy="account")
	private List<DemandDraft> demandDrafts;

	//bi-directional many-to-many association to Company
    @ManyToMany
	@JoinTable(
		name="ACCOUNT_COMPANY"
		, joinColumns={
			@JoinColumn(name="ACCOUNT_NO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="COMPANY_ID")
			}
		)
	private List<Company> companies;

	//bi-directional many-to-one association to Branch
    @ManyToOne
	@JoinColumn(name="BRANCH_CODE")
	private Branch branch;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;

	//bi-directional many-to-one association to Biller
	@OneToMany(mappedBy="account")
	private List<Biller> billers;

	//bi-directional many-to-one association to ThirdParty
	@OneToMany(mappedBy="account")
	private List<ThirdParty> thirdParties;

	//bi-directional many-to-one association to AutoDebit
	@OneToMany(mappedBy="account")
	private List<AutoDebit> autoDebits;

	//bi-directional many-to-many association to Ib
    @ManyToMany
	@JoinTable(
		name="IBS_ACCOUNT"
		, joinColumns={
			@JoinColumn(name="ACCOUNT_NO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="USER_NAME")
			}
		)
	private List<Ib> ibs;

    public Account() {
    }

	public int getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getCurrentBalance() {
		return this.currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getDateOfClose() {
		return this.dateOfClose;
	}

	public void setDateOfClose(Date dateOfClose) {
		this.dateOfClose = dateOfClose;
	}

	public Date getDateOfOpen() {
		return this.dateOfOpen;
	}

	public void setDateOfOpen(Date dateOfOpen) {
		this.dateOfOpen = dateOfOpen;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public List<Cheque> getCheques() {
		return this.cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}
	
	public List<DemandDraft> getDemandDrafts() {
		return this.demandDrafts;
	}

	public void setDemandDrafts(List<DemandDraft> demandDrafts) {
		this.demandDrafts = demandDrafts;
	}
	
	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public List<Biller> getBillers() {
		return this.billers;
	}

	public void setBillers(List<Biller> billers) {
		this.billers = billers;
	}
	
	public List<ThirdParty> getThirdParties() {
		return this.thirdParties;
	}

	public void setThirdParties(List<ThirdParty> thirdParties) {
		this.thirdParties = thirdParties;
	}
	
	public List<AutoDebit> getAutoDebits() {
		return this.autoDebits;
	}

	public void setAutoDebits(List<AutoDebit> autoDebits) {
		this.autoDebits = autoDebits;
	}
	
	public List<Ib> getIbs() {
		return this.ibs;
	}

	public void setIbs(List<Ib> ibs) {
		this.ibs = ibs;
	}

	public String getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(String activeInactive) {
		this.activeInactive = activeInactive;
	}
	
}