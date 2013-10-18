package com.cdac.svarn.business.employeemgmt;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.entities.DepositInterest;
import com.cdac.svarn.entities.Ib;
import com.cdac.svarn.entities.LoanInterest;
import com.cdac.svarn.entities.RegisterClosing;
import com.cdac.svarn.entities.RegisterCompany;
import com.cdac.svarn.entities.RegisterIb;
import com.cdac.svarn.entities.RegisterIbPK;
import com.cdac.svarn.entities.RegisterLoan;
import com.cdac.svarn.entities.Registration;
import com.cdac.svarn.helper.SendMail;

/**
 * TODO : Write a short summary of this type
 * 
 * @author svarn
 * 
 */
@Stateless
@RemoteBinding(jndiBinding = "EmployeeManager")
public class EmployeeManagerBean implements EmployeeManager {

	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(EmployeeManagerBean.class);
	String senderEmailID="svarnbank@gmail.com";

	@Override
	public ArrayList<Registration> getUsers() {

		try {
			logger.info("invoked the getUsers...");

			Query query = manager.createQuery("from Registration");
			ArrayList<Registration> arr = (ArrayList<Registration>) query
					.getResultList();

			System.out.println("name of the candidate-------------------"
					+ arr.get(0).getFirstName());

			return arr;

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public ArrayList<RegisterIb> getIbsUser() {

		try {
			logger.info("invoked the getIbsUser()...");

			Query query = manager.createQuery("from RegisterIb");

			ArrayList<RegisterIb> arr = (ArrayList<RegisterIb>) query.getResultList();
			
	//		System.out.println("name of the candidate-------------------"+arr.get(0).getFirstName());
			
			return arr;

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public ArrayList<RegisterCompany> getCompanies() {

		try {
			logger.info("invoked the getCompanies...");

			Query query = manager.createQuery("from RegisterCompany");
			ArrayList<RegisterCompany> arr = (ArrayList<RegisterCompany>) query
					.getResultList();

			System.out.println("name of the candidate-------------------"
					+ arr.get(0).getCompanyName());

			return arr;

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public boolean deleteRegistration(int index) {
		try {
			logger.info("invoked the getUsers...");
			Registration r = manager.find(Registration.class, index);
			manager.remove(r);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteIBSRegistration(int cid, int acc ) {
		try {
			logger.info("invoked the ibs delete..."+ cid+", "+acc);
			RegisterIbPK rpk=new RegisterIbPK();
			rpk.setAccountNo(acc);
			rpk.setCustomerId(cid);
			
			RegisterIb r = manager.find(RegisterIb.class, rpk);
			
			manager.remove(r);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCompanyRegistration(int index) {
		try {
			logger.info("invoked the deletecompany...");
			RegisterCompany r = manager.find(RegisterCompany.class, index);
			manager.remove(r);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAccountExists(String accname) {
		
		System.out.println("lllll:"+accname);

		try {
			logger.info("invoked the isAccountExists...");
//
//			Query query = manager
//					.createQuery("from DepositInterest d where d.depositTypeDescription=:accname");
//			query.setParameter("accname", accname);
			
			Query query = manager.createQuery("from DepositInterest d");
			
			List<DepositInterest> li = query.getResultList(); 
			
			
			for (int i=0;i<li.size();i++){
				
				
				
				if(li.get(i).getDepositTypeDescription().equalsIgnoreCase(accname)){
					
					System.out.println("------------------>>>>>>Dis"+li.get(i).getDepositTypeDescription());
					
					return true;
					
				}
				
				
			}
			
			return false;
			
			
//			for ( DepositInterest d : li){
//				
//				if (li.depositTypeDescription)
//				
//			}
//			
//			DepositInterest obj = (DepositInterest)query.getSingleResult();
			
//			System.out.println("AAAAAAAAAAAAA"+obj);
//			if (obj!=null){
//				
//				
//				return true;
//				}
//			else
//				return false;
		} catch (Exception e) {

			System.out.println("error in isAccountExists" + e.getMessage());
			return false;
		}


	}

	@Override
	public boolean creatingNewAccount(String accountName, String accRate) {
		
		System.out.println("lllll:"+accountName+" "+accRate);

		try {
			logger.info("invoked the creatingNewAccount...");

			DepositInterest dpi = new DepositInterest();
			dpi.setDepositRate(new Double(accRate));
			dpi.setDepositTypeDescription(accountName);

			manager.persist(dpi);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("unable to persist");
			return false;
		}

	}


	@Override
	public boolean creatingLoanAccount(String accountName, String accRate) {
		
		try {
			logger.info("invoked the creatingLoanAccount..");

			LoanInterest lpi = new LoanInterest();
			lpi.setLoanRate(new Double(accRate));
			lpi.setLoanTypeDescription(accountName);

			manager.persist(lpi);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("unable to persist");
			return false;
		}
	}

	@Override
	public boolean UpdateData(String accountName, String accRate) {
		
		try {
			logger.info("invoked the UpdateData 123 ..");
			Query query = manager.createQuery("from DepositInterest d");
			
			List<DepositInterest> li = query.getResultList(); 
			
			int id =0;
			for (int i=0;i<li.size();i++){
				if(li.get(i).getDepositTypeDescription().equalsIgnoreCase(accountName)){
					
					id = li.get(i).getDepositTypeCode();
					
				}
			}
			DepositInterest dpi = manager.find(DepositInterest.class, id);
			dpi.setDepositRate(new Double(accRate));
			
			manager.merge(dpi);
			
			return true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("unable to persist");
			return false;
		}
	}


@Override
	public boolean UpdateLoan(String accountName, String accRate) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean approveIBSRegistration(int custId, int accountNo) {
		
		PassPhrase pass = new PassPhrase();
		
		try {
			logger.info("approveIBSRegistration invoked..............");
			String passwd=pass.getNext();
			String txpasswd = pass.getNext();
			String userName="";
			
			while(true){
			
				userName=pass.UserName();
				if(!isUserNameExist(userName)){
					
					break;
				}
			
			}
			
			Ib ib = new Ib();
			
			Customer cust = manager.find(Customer.class, custId);
			
			ib.setUserName(userName);
			ib.setCustomer(cust);
			ib.setUserPassword(passwd);
			ib.setTransactionPassword(txpasswd);
			Date date = new Date();
			ib.setOpeningDate(date);
			
			List<Ib>  listIb = new ArrayList<Ib>();
			listIb.add(ib);
			
			RegisterIbPK  regIbsPk = new RegisterIbPK();
			
			regIbsPk.setAccountNo(accountNo);
			regIbsPk.setCustomerId(custId);
			
			RegisterIb regIbs = manager.find(RegisterIb.class, regIbsPk);
			
			cust.setCustMobile(regIbs.getMobileNo());
			cust.setCustEmail(regIbs.getEmail());
			
				
			Account acct = manager.find(Account.class, accountNo);
			List<Account> listAccount = new ArrayList<Account>();
			listAccount.add(acct);
			
			acct.setIbs(listIb);
			ib.setAccounts(listAccount);
			
			manager.merge(cust);
			manager.merge(ib);
			manager.remove(regIbs);
			
			String receiverEmailID = regIbs.getEmail();
			String emailSubject = "Your UserName and Password";
			String emailBody = "\n\n\nDear "+cust.getCustFirstName()+" "+cust.getCustLastName()+",\n\n\n\t\t\t\t\t\tUser Name: "+userName+"\n\t\t\t\t\t\tPassword: "+passwd+"\n\t\t\t\t\t\tTransaction Password: "+txpasswd+"\nPlease dont reveal your password and user name to anyone.\n\n Bank never asks you for the password\n\n\n\n\nManager\nhttps://172.16.32.45:8080/svarn\nMail us at : svarnbank@gmail.com";
			
			@SuppressWarnings("unused")
			SendMail sendMail = new SendMail(senderEmailID,receiverEmailID, emailSubject, emailBody);
			
			return true;
		}catch(Exception e){
			System.out.println("Unable to approve the application with the CustomerId : "+custId);
			return false;
		}
		
	}

	public boolean isUserNameExist(String userName){
		
		try{
		Ib ib = new Ib();
		
		Query query = manager.createQuery("from Ib i where i.userName=:userName");
		query.setParameter("userName", userName);
		ib = (Ib) query.getSingleResult();
		return true;
		
		}catch(Exception e){
			
			return false;
		}
		
	}

	@Override
	public ArrayList<RegisterLoan> getLoanUsers() {
		try {
			logger.info("invoked the getLoanUsers...");

			Query query = manager.createQuery("from RegisterLoan");
			ArrayList<RegisterLoan> arr = (ArrayList<RegisterLoan>) query.getResultList();

			System.out.println("name of the candidate-------------------"
					+ arr.get(0).getFirstName());

			return arr;

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public boolean deleteLoanRegistration(int index) {
		try {
			logger.info("invoked the deleteLoanRegistration...");
			RegisterLoan r = manager.find(RegisterLoan.class, index);
			manager.remove(r);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Account getAccountNo(int accNo) {
		Account acct = manager.find(Account.class, accNo);
		System.out.println("account type--------------------"+acct.getAccountType());
		return acct;
	}

	@Override
	public boolean deleteClosingRegistration(int index) {
		try {
			logger.info("invoked the deletecompany...");
			RegisterClosing r = manager.find(RegisterClosing.class, index);
			manager.remove(r);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<RegisterClosing> getClosings() {
		try {
			logger.info("invoked the getClosing in EmployeeManagerBean...");

			Query query = manager.createQuery("from RegisterClosing");
			ArrayList<RegisterClosing> arr = (ArrayList<RegisterClosing>) query.getResultList();
			return arr;

		} catch (Exception e) {
			System.out.println("Exception in getClosings() EmployeeManagerBean------ "+e);
			return null;
		}
	}
	
}
			
