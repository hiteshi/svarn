package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BRANCH database table.
 * 
 */
@Entity
@Table(name="BRANCH")
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BRANCH_CODE")
	private int branchCode;

	@Column(name="BRANCH_MANAGER")
	private int branchManager;

	@Column(name="BRANCH_NAME")
	private String branchName;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="branch")
	private List<Account> accounts;

	//bi-directional one-to-one association to Address
	@OneToOne(mappedBy="branch")
	private Address address;

    public Branch() {
    }

	public int getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public int getBranchManager() {
		return this.branchManager;
	}

	public void setBranchManager(int branchManager) {
		this.branchManager = branchManager;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}