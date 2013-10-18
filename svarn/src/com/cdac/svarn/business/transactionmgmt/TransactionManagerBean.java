/**
 * 
 */
package com.cdac.svarn.business.transactionmgmt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.business.usermgmt.UserManagerBean;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Address;
import com.cdac.svarn.entities.Branch;
import com.cdac.svarn.entities.Company;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.entities.DemandDraft;
import com.cdac.svarn.entities.DemandLoan;
//import com.cdac.svarn.entities.Deposit;
import com.cdac.svarn.entities.DepositInterest;
import com.cdac.svarn.entities.LoanInterest;
import com.cdac.svarn.entities.RegisterClosing;
import com.cdac.svarn.entities.RegisterCompany;
import com.cdac.svarn.entities.RegisterLoan;
import com.cdac.svarn.entities.Registration;
import com.cdac.svarn.entities.Saving;
import com.cdac.svarn.entities.TermLoan;
import com.cdac.svarn.entities.ThirdParty;
import com.cdac.svarn.entities.Transaction;
import com.cdac.svarn.helper.SendMail;

/**
 * @author d1153029
 *
 */
@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@RemoteBinding(jndiBinding = "TransactionManager")
public class TransactionManagerBean implements TransactionManagerRemote {

	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);
	String senderEmailID="svarnbank@gmail.com";
	
	
	public boolean fundsLogic (String accFrom,String accTo, String amountXfer,String remarks){
		
		int accountTo = Integer.parseInt(accTo);
		int accountFrom = Integer.parseInt(accFrom);
		int amount = Integer.parseInt(amountXfer);
		
		if(amount<0){return false;}
		else{
		System.out.println("3p xfer fundslogic invoked ");
		
		Account acc = manager.find(Account.class, accountFrom);
		
		Double curr_bal = acc.getCurrentBalance();
		
		if (amount <= (curr_bal-1000)){
			
			return performTransaction(accFrom,accTo, amountXfer,remarks);
			
		}
		else {
			System.out.println("amount greater than bal returning false");
			return false;
			
		}
		}
		
	}
	
	public boolean partyLogic (String accFrom,String accTo, String amountXfer,String remarks){
		
		int accountTo = Integer.parseInt(accTo);
		int accountFrom = Integer.parseInt(accFrom);
		int amount = Integer.parseInt(amountXfer);
		Double amount1 = (double) amount;
		Double limitz = null;
		
		System.out.println("3p xfer partylogic invoked ");
		
		Account acc = manager.find(Account.class, accountFrom);
		
		Double curr_bal = acc.getCurrentBalance();
		
		System.out.println("after find");	
		if (amount <= (curr_bal-1000)){
			
			
			acc = manager.find(Account.class, accountFrom);
			acc.getThirdParties().size();
			System.out.println("after find 2 value of acc : "+acc);
			
			System.out.println("after find 2 value of acc : "+acc.getAccountNo());
			
			List<ThirdParty> li = acc.getThirdParties();
			
			System.out.println("size of li : "+li.size());
			
			for(int i=0;i<li.size();i++){
				System.out.println("after find 2 value of acc : "+li.get(i).getTpName());
				if(li.get(i).getTpAccountNo() == accountTo){
					
					limitz=li.get(i).getTransferLimit();
					
				}
				
			}
			
//			
//			Query query = manager.createQuery("from ThirdParty a where a.account=:accFrom and a.tpAccountNo=:accTo");
//			
//			query.setParameter("accFrom", accFrom);
//			query.setParameter("accTo", accTo);
			
//			
//			ThirdParty tp = new ThirdParty();
//			
//			tp = (ThirdParty)query.getSingleResult();
			
			System.out.println("after query VALUE OF LIMITZ : "+limitz);	
			
//			if (amount<=tp.getTransferLimit()){
			if (amount1<=limitz){
			
				System.out.println("amnt sufficient calling perform transaction");	
					
				return performTransaction(accFrom,accTo, amountXfer,remarks);
				
			}else {
			
				System.out.println("limit crossed");
				return false;

			}
			
			
		}
		else {
			
			System.out.println("amount greater than bal returning false");
			return false;
			
		}
		
		
	}
	
	public boolean performTransaction(String accFrom,String accTo, String amountXfer,String remarks){
		
		/*System.out.println("Perform transaction invoked ... ");
		//String toChangeAmnt = (String) requestObj.getParameter("tochangeamnt");
		System.out.println("now calling transaction xfer : "+amountXfer);
		//String remarks = (String) requestObj.getParameter("remarks");
		System.out.println("now calling transaction remarks : "+remarks);
		//String accountTo = (String) requestObj.getParameter("accTo");
		System.out.println("now calling transaction accTo : "+accTo);
		//String accountFrom = (String) requestObj.getParameter("accFrom");
		System.out.println("now calling transaction accFrom : "+accFrom);*/
		
		int accountTo = Integer.parseInt(accTo);
		int accountFrom = Integer.parseInt(accFrom);
		
		//System.out.println("---1");
		
		
		
		Account acc = manager.find(Account.class, accountFrom);
	
		
		//System.out.println("---2");
		
		Double curr_bal = acc.getCurrentBalance();
		Double amnt = Double.parseDouble(amountXfer);
		
	//	System.out.println("---3");
		
		curr_bal -= amnt;
		acc.setCurrentBalance(curr_bal);
		
		Transaction trans = new Transaction();
		 
		
	//	System.out.println("---4    curr_bal = "+curr_bal);
		
		
		trans.setAccount(acc);
		trans.setCreditDebit("Debit");
		trans.setRemarks(remarks);
		trans.setTransactionAmount(amnt);
		trans.setTransactionDate(new Date());
		trans.setTransactionReference(accountTo);
		trans.setTransactionType("Account");
		
		manager.persist(trans);
		
		
		List<Transaction>  list = new ArrayList<Transaction>();
		list.add(trans);
		
	//	System.out.println("---5");
		
		acc.setTransactions(list);
		for (Transaction t : list)
		{
			System.out.println(t.getRemarks());
			
		}
		manager.persist(acc);
		//System.out.println("flush chal gaya");
		//manager.persist(acc);
		
//		till here all the credit operations are over
			
	//	System.out.println("---6");
		
		acc = manager.find(Account.class, accountTo);
		
		curr_bal = acc.getCurrentBalance();
		amnt = Double.parseDouble(amountXfer);
		
		curr_bal += amnt;
		acc.setCurrentBalance(curr_bal);
		
	//	System.out.println("---7  curr_bal = "+curr_bal);
		
		trans = new Transaction();
		 
		trans.setAccount(acc);
		trans.setCreditDebit("Credit");
		trans.setRemarks("---");
		trans.setTransactionAmount(amnt);
		trans.setTransactionDate(new Date());
		trans.setTransactionReference(accountFrom);
		trans.setTransactionType("Account");
		
//		List<Transaction>  list2 = new ArrayList<Transaction>();
//		list2.add(trans);
		
		
		manager.persist(trans);
		
		
	//	System.out.println("---8");
		
		
//		acc.setTransactions(list2);
		
		manager.persist(acc);
		
		
	//	System.out.println("---9");
		
		return true;
		
		
		
	}

	@Override
	public boolean onlineDD(String accFrom, String amountXfer,
			String inFavourOf, String payableAt, String remarks) {
		// TODO Auto-generated method stub
		
		
		
		int accountFrom = Integer.parseInt(accFrom);
		int amount = Integer.parseInt(amountXfer);
		
		Account acc = manager.find(Account.class, accountFrom);
		
		Double curr_bal = acc.getCurrentBalance();
		
				
		if (amount <= (curr_bal-1000)){
			
										
				return orderDD ( accFrom,  amountXfer,inFavourOf, payableAt,  remarks);
				
						
			
		}
		else {
			
			System.out.println("amount greater than bal returning false");
			return false;
			
		}
	
		
	}


	public boolean orderDD (String accFrom, String amountXfer,
			String inFavourOf, String payableAt, String remarks) {
				
		
		int accountFrom = Integer.parseInt(accFrom);
		
	//	System.out.println("---1");
				
		Account acc = manager.find(Account.class, accountFrom);
	
	//	System.out.println("---2");
		
		Double curr_bal = acc.getCurrentBalance();
		Double amnt = Double.parseDouble(amountXfer);
		
	//	System.out.println("---3");
		
		curr_bal -= amnt;
		acc.setCurrentBalance(curr_bal);
		
		Transaction trans = new Transaction();
		 		
	//	System.out.println("---4    curr_bal = "+curr_bal);
				
		trans.setAccount(acc);
		trans.setCreditDebit("Debit");
		trans.setRemarks(remarks);
		trans.setTransactionAmount(amnt);
		trans.setTransactionDate(new Date());
		trans.setTransactionReference(0);
		trans.setTransactionType("Demand Draft");
		
		manager.persist(trans);
		
		List<Transaction>  list = new ArrayList<Transaction>();
		list.add(trans);
		
				
	//	System.out.println("---5");
		
		acc.setTransactions(list);
		for (Transaction t : list)
		{
			System.out.println(t.getRemarks());
			
		}
		
		DemandDraft dd = new DemandDraft();
		
	//	System.out.println("---6");
		dd.setAccount(acc);
		dd.setAmount(amnt);
		dd.setFavourOf(inFavourOf);
		dd.setIssueDate(new Date());
		dd.setPayableAt(payableAt);
		
	//	System.out.println("---6 : b4 DD");
		
		manager.persist(dd);
		
	//	System.out.println("---7 : after DD");
		
		manager.persist(acc);
		
		
		
		return true;
		
		
		
		
		
	}

	@Override
	public List<Transaction> viewStatement(String startDate, String endDate,
			String account) {
		// TODO Auto-generated method stub
		
		System.out.println("view stmt invoked");
		int accno = Integer.parseInt(account);
		Account acc = manager.find(Account.class, accno);
		acc.getTransactions().size();
		
		System.out.println("after getting acc");
		
		
		DateFormat formatter ; 
		 Date sdate = null ;
		 Date edate = null ; 
		  formatter = new SimpleDateFormat("yyyy-MM-dd");
		  try {
			sdate = (Date)formatter.parse(startDate);
			edate = (Date)formatter.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("in catch of date");
			e.printStackTrace();
		}
		
		System.out.println("start date : "+sdate);
		System.out.println("end date : "+edate);

		
		List<Transaction> trans = acc.getTransactions();
		
		for (Transaction t : trans)
		{
			System.out.println(t.getTransactionDate());
			
		}
		System.out.println("we got date as : "+trans.get(0).getTransactionDate());
		
		Date gdate = trans.get(0).getTransactionDate();
		
		if (gdate.after(sdate))
			System.out.println("we got date as : "+trans.get(0).getTransactionDate());
		
		return trans;
		
					
		
		
		
	}
	
	
	public boolean approveRegistration(int regId, double amount) {
		// TODO Auto-generated method stub
		
		try {
		//	logger.info("approveRegistration invoked..............");
			Registration r = manager.find(Registration.class, regId);
			Date date = new Date();
			Customer cust=new Customer();
			
			cust.setCustFirstName(r.getFirstName());
			cust.setCustLastName(r.getLastName());
			cust.setCustGender(r.getGender());
			cust.setCustDob(r.getDateOfBirth());
			cust.setCustFatherName(r.getFatherName());
			cust.setCustEmail(r.getEmailId());
			cust.setCustMobile(r.getMobileNo());
			cust.setCustMotherName(r.getMotherName());
			
			Address address = new Address();
			
			address.setAddressLine1(r.getAddressLine1());
			address.setAddressLine2(r.getAddressLine2());
			address.setCity(r.getCity());
			address.setState(r.getState());
			address.setPinCode(r.getPinCode());
			address.setAddressType("CORRESPONDENCE");
			address.setFromDate(date);
			
			List<Customer>  listCustomer = new ArrayList<Customer>();
			listCustomer.add(cust);
			
			
			List<Address>  listAddress = new ArrayList<Address>();
			listAddress.add(address);
			
			
			address.setCustomers(listCustomer);
			cust.setAddresses(listAddress);
			
			
			Saving saving = new Saving();
			saving.setAccountType(r.getAccountType());
			
			saving.setDateOfOpen(date);
			saving.setCurrentBalance(amount);
			
			Query query = manager.createQuery("from Branch b where b.branchName=:branch");
			query.setParameter("branch", r.getBranchName());
			Branch branch = (Branch)query.getSingleResult();
			saving.setBranch(branch);
			
			saving.setNickName(r.getFirstName());
			saving.setActiveInactive("ACTIVE");
			
			query = manager.createQuery("from DepositInterest di where di.depositTypeDescription=:description");
			query.setParameter("description", r.getAccountType());
			DepositInterest depositInterest = (DepositInterest)query.getSingleResult();
			
			saving.setDepositInterest(depositInterest);
			saving.setUpdatedOn(date);
			saving.setInterestAmount(0.00);
			
			saving.setCustomers(listCustomer);
			
			
			
			manager.persist(cust);
			manager.persist(saving);
			manager.persist(address);
			
			System.out.println("Account No created is : "+ saving.getAccountNo());
			
			Transaction trans = new Transaction();
			Account acct = manager.find(Account.class, saving.getAccountNo());
			trans.setAccount(acct);
			trans.setCreditDebit("Credit");
			trans.setRemarks("Initial Deposit");
			trans.setTransactionAmount(amount);
			trans.setTransactionDate(new Date());
		
			trans.setTransactionReference(0);
			trans.setTransactionType("Cash");
			
			manager.persist(trans);
			
			manager.remove(r);
			
//-------------Sending E-Mail to customer for sending the Account No. and Customer ID----------------------
			
			String receiverEmailID = cust.getCustEmail();
			String emailSubject = "SVARN Bank : Your Account No. and Customer ID.";
			String emailBody = "Dear Customer,\n\nThank you for Opening Savings Account with our Bank.\n\n" +
					"\t\tYour Account No. is : "+saving.getAccountNo()+"\n\t\tYour Customer ID is : "+cust.getCustomerId()+"\n\nWith Regards" +
							"\nSVARN Bank\nvisit us on https://172.16.32.45:8080/svarn";
			
			SendMail sendMail = new SendMail(senderEmailID,receiverEmailID, emailSubject, emailBody);
			
			
			return true;
		}catch(Exception e){
			System.out.println("Unable to approve the application with the registrationId : "+regId);
			return false;
		}
	}


	public boolean approveCompanyRegistration(int regId, double amount) {
	
		try {
			logger.info("approveCompanyRegistration invoked..............");
			
			RegisterCompany r = manager.find(RegisterCompany.class, regId);
			
			Company comp=new Company();
			
			comp.setName(r.getCompanyName());
			comp.setContactPersonEmail(r.getContactPersonEmail());
			comp.setContactPersonName(r.getContactPersonName());
			comp.setContactPersonMobile(r.getContactPersonMobile());
			
			
			List<Company>  listCompany = new ArrayList<Company>();
			listCompany.add(comp);
			
			Account acc = new Account();
			
			Date date = new Date();
			acc.setDateOfOpen(date);
			
			acc.setCurrentBalance(amount);
			
			
			
			Query query = manager.createQuery("from Branch b where b.branchName=:branch");
			query.setParameter("branch", r.getBranchName());
			Branch branch = (Branch)query.getSingleResult();
			
			acc.setBranch(branch);
			acc.setAccountType("CURRENT ACCOUNT");
			acc.setNickName(r.getCompanyName());
			acc.setActiveInactive("ACTIVE");
			
			
			List<Account>  listAccount = new ArrayList<Account>();
			listAccount.add(acc);
			
			comp.setAccounts(listAccount);
			
			
			acc.setCompanies(listCompany);
			
			manager.persist(comp);
			manager.persist(acc);	
			manager.remove(r);
			
//-------------Sending E-Mail to Company Contact Person for sending the Account No. and Company ID----------------------
			
			String receiverEmailID = comp.getContactPersonEmail();
			String emailSubject = "SVARN Bank : Your Account No. and Company ID.";
			String emailBody = "Dear Customer,\n\nThank you for Opening Current Account with our Bank.\n\n" +
					"\t\tYour Account No. is : "+acc.getAccountNo()+"\n\t\tYour Customer ID is : "+comp.getCompanyId()+"\n\nWith Regards" +
							"\nSVARN Bank\nvisit us on https://172.16.32.45:8080/svarn";
			
			SendMail sendMail = new SendMail(senderEmailID,receiverEmailID, emailSubject, emailBody);
			
			
			return true;
		}catch(Exception e){
			System.out.println("Unable to approve the application with the registrationId : "+regId);
			return false;
		}
		
	}

	@Override
	public boolean approveLoanRegistration(int regId) {
		// TODO Auto-generated method stub

		try {
			logger.info("approveLoanRegistration invoked..............");
			RegisterLoan r = manager.find(RegisterLoan.class, regId);
			Date date = new Date();
			Customer cust=new Customer();
			System.out.println("Inside transaction manager been for Approve loan-----------------------1.0---------------------");
			cust.setCustFirstName(r.getFirstName());
			cust.setCustLastName(r.getLastName());
			cust.setCustGender(r.getGender());
			cust.setCustDob(r.getDateOfBirth());
			cust.setCustFatherName(r.getFatherName());
			cust.setCustEmail(r.getEmailId());
			cust.setCustMobile(r.getMobileNo());
			cust.setCustMotherName(r.getMotherName());
			System.out.println("Inside transaction manager been for Approve loan-----------------------1.1---------------------");
			
			Address address = new Address();
			
			address.setAddressLine1(r.getAddressLine1());
			address.setAddressLine2(r.getAddressLine2());
			address.setCity(r.getCity());
			address.setState(r.getState());
			address.setPinCode(r.getPinCode());
			address.setAddressType("CORRESPONDENCE");
			address.setFromDate(date);
			System.out.println("Inside transaction manager been for Approve loan-----------------------1.2---------------------");
			List<Customer>  listCustomer = new ArrayList<Customer>();
			listCustomer.add(cust);
			
			
			List<Address>  listAddress = new ArrayList<Address>();
			listAddress.add(address);
			
			System.out.println("Inside transaction manager been for Approve loan-----------------------1.3---------------------");
			address.setCustomers(listCustomer);
			cust.setAddresses(listAddress);
			
			System.out.println("Inside transaction manager been for Approve loan-----------------------1---------------------");
			
			if(r.getLoanType().equals("Demand Loan")){
				DemandLoan demand = new DemandLoan();
				demand.setAccountType(r.getLoanType());
				demand.setCurrentBalance(r.getAmountRequired());
				demand.setDateOfOpen(date);
				
				Query query = manager.createQuery("from Branch b where b.branchName=:branch");
				query.setParameter("branch", r.getBranchName());
				Branch branch = (Branch)query.getSingleResult();
				demand.setBranch(branch);
				
				demand.setNickName(r.getFirstName());
				demand.setActiveInactive("ACTIVE");
				
				System.out.println("Inside transaction manager been for Approve loan--------------------2------------------------"+ r.getSpecificType());

				query = manager.createQuery("from LoanInterest li where li.loanTypeDescription=:description");
				query.setParameter("description", r.getSpecificType());
				LoanInterest loanInterest = (LoanInterest)query.getSingleResult();
				demand.setLoanInterest(loanInterest);
				
				demand.setAmountSanctioned(r.getAmountRequired());
				double amnt = r.getAmountRequired();
				amnt *= -1;
				System.out.println("The amount is : "+r.getAmountRequired());
				System.out.println("The negative of amount is :"+amnt);
				demand.setAmountRemaining(amnt);
				
				demand.setTimeLimit(r.getTimeLimit());
				
				demand.setCustomers(listCustomer);
				System.out.println("Inside transaction manager been for Approve loan---------------------3-----------------------");

				
				manager.persist(cust);
				manager.persist(demand);
				manager.persist(address);
				
				Transaction trans = new Transaction();
				Account acct = manager.find(Account.class, demand.getAccountNo());
				trans.setAccount(acct);
				trans.setCreditDebit("Credit");
				trans.setRemarks("Initial Deposit");
				trans.setTransactionAmount(r.getAmountRequired());
				trans.setTransactionDate(new Date());
			
				trans.setTransactionReference(0);
				trans.setTransactionType("Cash");
				System.out.println("Inside transaction manager been for Approve loan-------------------4-------------------------");

				manager.persist(trans);
				
//-------------Sending E-Mail to User for sending the Account No. and Customer ID----------------------
				System.out.println("Inside transaction manager been for Approve loan------------------------5--------------------");

				String receiverEmailID = cust.getCustEmail();
				String emailSubject = "SVARN Bank : Your Account No. and Customer ID.";
				String emailBody = "Dear Customer,\n\nThank you for Opening Current Account with our Bank.\n\n" +
						"\t\tYour Account No. is : "+demand.getAccountNo()+"\n\t\tYour Customer ID is : "+cust.getCustomerId()+"\n\nWith Regards" +
								"\nSVARN Bank\nvisit us on : https://172.16.32.45:8080/svarn";
				System.out.println("Inside transaction manager been for Approve loan-------------------------6-------------------");

				SendMail sendMail = new SendMail(senderEmailID,receiverEmailID, emailSubject, emailBody);
				
				
			}
			else{
			
				TermLoan termLoan = new TermLoan();
				termLoan.setAccountType(r.getLoanType());
				termLoan.setCurrentBalance(r.getAmountRequired());
				termLoan.setDateOfOpen(date);
				
				Query query = manager.createQuery("from Branch b where b.branchName=:branch");
				query.setParameter("branch", r.getBranchName());
				Branch branch = (Branch)query.getSingleResult();
				termLoan.setBranch(branch);
				
				termLoan.setNickName(r.getFirstName());
				termLoan.setActiveInactive("ACTIVE");
				
				
				query = manager.createQuery("from LoanInterest li where li.loanTypeDescription=:description");
				query.setParameter("description", r.getSpecificType());
				LoanInterest loanInterest = (LoanInterest)query.getSingleResult();
				termLoan.setLoanInterest(loanInterest);
				termLoan.setAmountSanctioned(r.getAmountRequired());
				double amnt = r.getAmountRequired();
				amnt *= -1;
				System.out.println("The amount is : "+r.getAmountRequired());
				System.out.println("The negative of amount is :"+amnt);
				
				termLoan.setAmountRemaining(amnt);
				
				termLoan.setPeriodOfPremium(r.getPeriodOfPremimum());
				termLoan.setPremium(r.getPremium());
				
				termLoan.setCustomers(listCustomer);
				
				manager.persist(cust);
				manager.persist(termLoan);
				manager.persist(address);
				
				Transaction trans = new Transaction();
				Account acct = manager.find(Account.class, termLoan.getAccountNo());
				trans.setAccount(acct);
				trans.setCreditDebit("Credit");
				trans.setRemarks("Initial Deposit");
				trans.setTransactionAmount(r.getAmountRequired());
				trans.setTransactionDate(new Date());
			
				trans.setTransactionReference(0);
				trans.setTransactionType("Cash");
				
				manager.persist(trans);
				
//-------------Sending E-Mail to User for sending the Account No. and Customer ID----------------------
				
				String receiverEmailID = cust.getCustEmail();
				String emailSubject = "SVARN Bank : Your Account No. and Customer ID.";
				String emailBody = "Dear Customer,\n\nThank you for Opening Current Account with our Bank.\n\n" +
						"\t\tYour Account No. is : "+termLoan.getAccountNo()+"\n\t\tYour Customer ID is : "+cust.getCustomerId()+"\n\nWith Regards" +
								"\nSVARN Bank\nvisit us on : https://172.16.32.45:8080/svarn";
				
				SendMail sendMail = new SendMail(senderEmailID,receiverEmailID, emailSubject, emailBody);
				
				
			}
			
			manager.remove(r);
			
			return true;
		}catch(Exception e){
			System.out.println("Unable to approve the LoanApplication with the registrationId : "+regId+"\n\n"+e);
			return false;
		}
	}

	@Override
	public boolean approveClosingRegistration(int regId) {

		try {
			logger.info("approveCompanyRegistration invoked..............");
			
			RegisterClosing r = manager.find(RegisterClosing.class, regId);
			
			Account acc = manager.find(Account.class, r.getAccountNo());
			
			
			acc.setActiveInactive("Inactive");
			manager.merge(acc);
			manager.remove(r);
			
/*//-------------Sending E-Mail to Company Contact Person for sending the Account No. and Company ID----------------------
			
			String receiverEmailID = comp.getContactPersonEmail();
			String emailSubject = "SVARN Bank : Your Account No. and Company ID.";
			String emailBody = "Dear Customer,\n\nThank you for Opening Current Account with our Bank.\n\n" +
					"\t\tYour Account No. is : "+acc.getAccountNo()+"\n\t\tYour Customer ID is : "+comp.getCompanyId()+"\n\nWith Regards" +
							"\nSVARN Bank\nvisit us on https://172.16.32.45:8080/svarn";
			
			SendMail sendMail = new SendMail(senderEmailID,receiverEmailID, emailSubject, emailBody);
			
*/			
			return true;
		}catch(Exception e){
			System.out.println("Unable to approve the application with the registrationId : "+regId);
			return false;
		}
	}

	@Override
	public boolean CalculateInterest() {
		
		try {
//			System.out.println("CalculateInterest--------------1--------");
//			String str = "Saving Account";
//			Query query = manager.createQuery("from DepositInterest where depositTypeDescription=:description");
//			query.setParameter("description", str);
//			DepositInterest di = (DepositInterest)query.getSingleResult();
//			
//			
//			
//			
//			
//			double rate = di.getDepositRate();
//			
//			
//			List<Saving> saving=new ArrayList<Saving>();
//			System.out.println("CalculateInterest---------2-------------"+di.getDepositRate());
//			
//			Query query1 = manager.createQuery("from Saving where accountNo>=0");
//			
//			saving=(ArrayList<Saving>)query1.getResultList();
//			System.out.println("CalculateInterest--------3--------------"+saving.get(0).getAccountNo());
//			
//			int size=saving.size();
//			
//			for(int i=0;i<size;i++)
//			{
//				System.out.println("CalculateInterest--------calculating for --------------"+saving.get(i).getAccountNo());
//				
//				double bal=saving.get(i).getCurrentBalance();
//				bal=saving.get(i).getInterestAmount()+((bal*rate)/(36500));
//				saving.get(i).setInterestAmount(bal);
//
//				Date date=new Date();
//				saving.get(i).setUpdatedOn(date);
//				manager.merge(saving);
//				System.out.println("CalculateInterest----------------------calculated");
//				
//			}
//			
//			System.out.println("CalculateInterest--------5--------------");
			
//			System.out.println("CalculateInterest--------------1--------");
			
			Query query = manager.createQuery("from Saving d");
			
//			System.out.println("CalculateInterest--------------2--------");
			
			List<Saving> savings = (ArrayList<Saving>)query.getResultList();
			
//			System.out.println("CalculateInterest--------------3--------");
			
			
			for (int i=0;i<savings.size();i++){
				
//				System.out.println("CalculateInterest--------------4--------");
				
				if (savings.get(i).getActiveInactive().equalsIgnoreCase("ACTIVE")){
				
					
//					System.out.println("CalculateInterest--------------5--------");
				Double rate = savings.get(i).getDepositInterest().getDepositRate();
				
//				System.out.println("CalculateInterest--------------6--------");
				
				Double bal = savings.get(i).getCurrentBalance();
				
//				System.out.println("CalculateInterest--------------7--------");
				
				bal=savings.get(i).getInterestAmount()+((bal*rate)/(36500));
				
//				System.out.println("CalculateInterest--------------8--------");
				
				savings.get(i).setInterestAmount(bal);
				
//				System.out.println("CalculateInterest--------------9--------");
				
				try{
				manager.merge(savings.get(i));
				
				System.out.println("merge kar diya ");
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("unable to merge ... ");
				}
				
				
				}else{
					
					
					
				}
				
				
			}
			
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	
}
