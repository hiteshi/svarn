package com.cdac.svarn.business.usermgmt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.entities.*;


/**
 * TODO : Write a short summary of this type
 * 
 * @author svarn
 * 
 */
@Stateless

@RemoteBinding(jndiBinding = "UserManager")
public class UserManagerBean implements UserManager {

	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);

	//	public User findUser(String pkey) {
	//		return manager.find(User.class, pkey);
	//	}

	public Ib isUserExists(String loginId, String password) {
		try {
			logger.info("invoked the isUserExist...");

			Query query = manager.createQuery("from Ib a where a.userName=:loginId and a.userPassword=:password");
			System.out.println("given logingId is : "+loginId+" & given password is : "+password);
			query.setParameter("loginId", loginId);
			query.setParameter("password", password);
			
			Ib newib = (Ib) query.getSingleResult();
			newib.getAccounts().size();
			
			System.out.println("b4 obj as :");
			
			List<Account> acc1 = newib.getAccounts();
			
			System.out.println("got obj as :"+acc1);
			
			
			if (acc1.get(0).getActiveInactive().equalsIgnoreCase("Active")){
				
				System.out.println("user is valid");
				return newib;
				
			}else{
				System.out.println("user is in - valid");
				return null;
				
			}

//			return (Ib) query.getSingleResult();//---------------------------- final if any error remove

		} catch (NoResultException e) {
			//logger.info("Exception because of user does not exist...", e);
		//	System.out.println("Exception is thrown b'coz password is wrong.");
			return null;
		}
	}

	public Ib populateUser(String loginId){

		Ib ib= manager.find(Ib.class, loginId);
		ib.setLatestLoginDate(new Date());
		return ib;
	}

	public List<Account> getAccounts(String loginId) {

		try{

			logger.info("invoked get Accounts...");
			Query query = manager.createQuery("from ACCOUNT a ");
			query.setParameter("loginId", loginId);
			List<Account> accounts = (List<Account>)query.getResultList();
			logger.info("after getting Accounts...");
			return accounts;
		} catch (NoResultException e) {
			logger.info("Exception because of accounts  not found...", e);
			return null;
		}


	}


	public void setibuser(Ib ib){

		manager.merge(ib);


	}


	public boolean createUser( Registration user) {


		/*System.out.println("manager.persist(user)------111111-----"+user.getBranchCity());
		 user.setRegistrationId(65412);
		manager.flush();
		//manager.persist(user);
		System.out.println("manager.persist(user)-----222222------");


		user.getRegistrationId();

		manager.merge(user);

		return true;

		 */

		//		Ib ib= manager.find(Ib.class, loginId);
		//		ib.setLatestLoginDate(new Date());
		//		return ib;

		try{
		manager.merge(user);
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("unable to persist");
			return false;
		}

	}

	@Override
	public List<Customer> isValidUser(String custId, String accNo) {
		try {
			logger.info("invoked the isUserExist...");
			
			int accnum = Integer.parseInt(accNo);
		//	System.out.println("hi rohit................................");
			Account acc = manager.find(Account.class, accnum);
			acc.getCustomers().size();
		//	System.out.println("hello rohit................................");
			
					
			

//			Query query = manager.createQuery("select distinct c from Customer c, Account a where c.customerId=:custId and a.accountNo=:accNo");
//			//Query query = manager.createQuery("select c from Customer c,Account a where ACCOUNT_CUSTOMER.CUSTOMER_ID=:custId and ACCOUNT_CUSTOMER.ACCOUNT_NO=:accNo");
//			System.out.println(custId+" | "+accNo);
//			
//			query.setParameter("custId", Integer.parseInt(custId));
//			query.setParameter("accNo", Integer.parseInt(accNo));

//			return (Customer) query.getSingleResult();
			
			return acc.getCustomers();

		} catch (Exception e) {
			logger.info("Exception because of user does not exist...", e);
			System.out.println("Exception because of user does not exist...");
			return null;
		}
	}

	@Override
	public boolean saveIBS(RegisterIb regIb) {
		// TODO Auto-generated method stub
		try{
		manager.persist(regIb);
		
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean createCompany(RegisterCompany regCompany) {

		try{
		manager.merge(regCompany);
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("unable to <merge> for Creating Company.");
			return false;
		}
		
	}

	@Override
	public boolean createLoanUser(RegisterLoan user) {
		try{
		//	System.out.println("inside loan Registration bean---------1---------------"+user.getFirstName());
			manager.merge(user);
		//	System.out.println("inside loan Registration Servlet------------2------------"+user.getFirstName());
			return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("unable to persist");
				return false;
			}
	}

	@Override
	public boolean isUserNameExist(String userName) {
		
		Ib ib = new Ib();
		logger.info("invoked isUserNameExist...");
		try{
			//-----------------------------------------------------check username
			
			
			Query query = manager.createQuery("from Ib where userName =:userName ");
			query.setParameter("userName", userName);
			query.getSingleResult();
			
			
			
			return false;
		} catch (NoResultException e) {
			
			//logger.info(userName+" exist in database...");
			return true;
		}
		
	}

	@Override
	public boolean saveUserPassword(String oldUserName,String userName, String userPassword, String transactionPassword) {
		
		System.out.println("oldUserName :"+oldUserName+" userName :"+userName+" userPassword :"+userPassword+" transactionPassword :"+transactionPassword);
		logger.info("saveUserPassword...");
		try{
			//-----------------------------------------------------Saving username---------------------
					
			//manager.merge(ib);
//			Ib ib1=new Ib();
			Ib ib1 =manager.find(Ib.class, oldUserName);
			ib1.getAccounts().size();
			
			List<Account> li = ib1.getAccounts();
			
			Ib oops =new Ib();
			
			oops.setUserName(userName);
			oops.setUserPassword(userPassword);
			oops.setTransactionPassword(transactionPassword);
			oops.setLatestLoginDate(new Date());
			oops.setOpeningDate(ib1.getOpeningDate());
			oops.setCustomer(ib1.getCustomer());
			
			
			
			manager.remove(ib1);
			
//			ib1.setUserName(userName);
//			ib1.setUserPassword(userPassword);
//			ib1.setTransactionPassword(transactionPassword);
//			ib1.setLatestLoginDate(new Date());
////			ib1.setOpeningDate(ib.getOpeningDate());
////			ib1.setCustomer(ib.getCustomer());
//			
////			manager.merge(ib1);
			
			
			List<Ib>  ibz = new ArrayList<Ib>();
			ibz.add(oops);
			
			for(int i=0;i<li.size();i++){
				
				li.get(i).setIbs(ibz);
				
			}
			
			manager.persist(oops);
			
			
//			ib1=manager.find(Ib.class, )
			
			
			
			
		/*	List<Account> lst=new ArrayList<Account>();*/
//			List<Account> listAccount = ib.getAccounts();
			/*Iterator<Account> it=listAccount.iterator();
			while(it.hasNext())
			{
				lst.add(it.next());
				
			}*/
//			Account acc= listAccount.get(0);
//			acc=manager.find(Account.class,acc.getAccountNo());
//			List<Ib> iblist=acc.getIbs();
//			iblist.set(0,ib1);
//			//Account acc1=new Account();
//			acc.setIbs(iblist);
//		
//			
//			manager.remove(ib);
//			manager.persist(ib1);
//			
//			manager.merge(acc);
//			//manager.persist(acc);
//			//ib1.setAccounts(lst);	
						
						
			return true;
		} catch (NoResultException e) {
			
			logger.info("could not save...!!!");
			return false;
		}
	}

	@Override
	public void closeAccount(String accountNo, String customerId,String feedback) {
		
			RegisterClosing rgc = new RegisterClosing();
			rgc.setAccountNo(Integer.parseInt(accountNo));
			rgc.setUserId(Integer.parseInt(customerId));
			rgc.setFeedback(feedback);
			manager.persist(rgc);
			
	}


}

