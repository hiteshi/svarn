package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEE_HISTORY database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE_HISTORY")
public class EmployeeHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HISTORY_ID")
	private int historyId;

	@Column(name="BRANCH_CODE")
	private int branchCode;

	@Column(name="DEPARTMENT")
	private String department;

	@Column(name="DESIGNATION")
	private String designation;

    @Temporal( TemporalType.DATE)
	@Column(name="FROM_DATE")
	private Date fromDate;

    @Temporal( TemporalType.DATE)
	@Column(name="TILL_DATE")
	private Date tillDate;

    @Temporal( TemporalType.DATE)
	@Column(name="TO_DATE")
	private Date toDate;

	//bi-directional many-to-one association to Employee
    @ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

    public EmployeeHistory() {
    }

	public int getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getTillDate() {
		return this.tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}