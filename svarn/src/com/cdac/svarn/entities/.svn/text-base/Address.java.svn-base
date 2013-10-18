package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private int addressId;

	@Column(name="ADDRESS_LINE1")
	private String addressLine1;

	@Column(name="ADDRESS_LINE2")
	private String addressLine2;

	@Column(name="ADDRESS_TYPE")
	private String addressType;

	@Column(name="CITY")
	private String city;

    @Temporal( TemporalType.DATE)
	@Column(name="FROM_DATE")
	private Date fromDate;

	@Column(name="PIN_CODE")
	private int pinCode;

	@Column(name="STATE")
	private String state;

    @Temporal( TemporalType.DATE)
	@Column(name="TILL_DATE")
	private Date tillDate;

	//bi-directional many-to-many association to Customer
	@ManyToMany(mappedBy="addresses")
	private List<Customer> customers;

	//bi-directional one-to-one association to Branch
	@OneToOne
	@JoinColumn(name="ADDRESS_ID", referencedColumnName="ADDRESS_ID")
	private Branch branch;

	//bi-directional many-to-many association to Employee
    @ManyToMany
	@JoinTable(
		name="ADDRESS_EMPLOYEE"
		, joinColumns={
			@JoinColumn(name="ADDRESS_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="EMPLOYEE_ID")
			}
		)
	private List<Employee> employees;

    public Address() {
    }

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public int getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getTillDate() {
		return this.tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}