package com.cdac.svarn.business.usermgmt;

import java.util.List;

import javax.ejb.Remote;

import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.entities.Ib;
import com.cdac.svarn.entities.RegisterCompany;
import com.cdac.svarn.entities.RegisterIb;
import com.cdac.svarn.entities.RegisterLoan;
import com.cdac.svarn.entities.Registration;

@Remote
public interface UserManager {

	public boolean createUser( Registration user);
	public boolean createLoanUser( RegisterLoan user);
//	public Ib findUser(String pkey);
	public Ib isUserExists(String loginId, String password);
	public List<Customer> isValidUser(String custId, String accNo);
	public Ib populateUser (String loginId);
	//public boolean updateUser(User user);
	public List<Account> getAccounts(String loginId);
	public void setibuser(Ib ib);
	public boolean saveIBS(RegisterIb regValues);
	
	public boolean createCompany(RegisterCompany regCompany);
	public boolean isUserNameExist(String userName);
	public boolean saveUserPassword(String oldUserName,String userName, String userPassword, String transactionPassword);
	public void closeAccount(String accountNo,String customerId,String feedback);

}
