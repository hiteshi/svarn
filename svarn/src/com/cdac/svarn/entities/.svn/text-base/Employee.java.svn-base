package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID")
	private int employeeId;

	@Column(name="BRANCH_CODE")
	private int branchCode;

	@Column(name="DEPARTMENT")
	private String department;

    @Temporal( TemporalType.DATE)
	@Column(name="EMP_DOB")
	private Date empDob;

	@Column(name="EMP_FIRST_NAME")
	private String empFirstName;

	@Column(name="EMP_GENDER")
	private String empGender;

	@Column(name="EMP_LAST_NAME")
	private String empLastName;

	@Column(name="EMP_PASSWORD")
	private String empPassword;

    @Temporal( TemporalType.DATE)
	@Column(name="HIRED_ON")
	private Date hiredOn;

	@Column(name="PASSWORD")
	private String password;

	//bi-directional many-to-many association to Address
	@ManyToMany(mappedBy="employees")
	private List<Address> addresses;

	//bi-directional many-to-one association to EmployeeHistory
	@OneToMany(mappedBy="employee")
	private List<EmployeeHistory> employeeHistories;

    public Employee() {
    }

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public Date getEmpDob() {
		return this.empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getEmpFirstName() {
		return this.empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpGender() {
		return this.empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpLastName() {
		return this.empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public Date getHiredOn() {
		return this.hiredOn;
	}

	public void setHiredOn(Date hiredOn) {
		this.hiredOn = hiredOn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<EmployeeHistory> getEmployeeHistories() {
		return this.employeeHistories;
	}

	public void setEmployeeHistories(List<EmployeeHistory> employeeHistories) {
		this.employeeHistories = employeeHistories;
	}
	
}