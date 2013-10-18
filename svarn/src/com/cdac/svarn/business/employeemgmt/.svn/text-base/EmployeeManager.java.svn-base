package com.cdac.svarn.business.employeemgmt;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.RegisterClosing;
import com.cdac.svarn.entities.RegisterCompany;
import com.cdac.svarn.entities.RegisterIb;
import com.cdac.svarn.entities.RegisterLoan;
import com.cdac.svarn.entities.Registration;

@Remote
public interface EmployeeManager {

	
	public ArrayList<Registration> getUsers();
	public ArrayList<RegisterLoan> getLoanUsers();
	
	public ArrayList<RegisterCompany> getCompanies();
	public ArrayList<RegisterClosing> getClosings();
	
	public ArrayList<RegisterIb> getIbsUser();
	
	
	public boolean deleteRegistration(int index);
	public boolean deleteLoanRegistration(int index);
	
	public boolean deleteIBSRegistration(int cid, int acc);
	public boolean deleteCompanyRegistration(int index);
	public boolean deleteClosingRegistration(int index);
	public boolean isAccountExists(String accname);
	public boolean creatingNewAccount(String accountName, String accRate);
	public boolean creatingLoanAccount(String accountName, String accRate);
	public boolean UpdateData(String accountName, String accRate);
	public boolean UpdateLoan(String accountName, String accRate);
	
	public boolean approveIBSRegistration(int custId, int accountNo);
	public boolean isUserNameExist(String userName);
	
	public Account getAccountNo(int accNo);


}
