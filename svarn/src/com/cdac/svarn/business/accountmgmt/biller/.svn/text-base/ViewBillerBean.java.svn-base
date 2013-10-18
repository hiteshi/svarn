/**
 * 
 */
package com.cdac.svarn.business.accountmgmt.biller;

/**
 * @author d1153029
 *
 */


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.business.usermgmt.UserManagerBean;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.entities.Company;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.entities.ThirdParty;




@Stateless
@RemoteBinding(jndiBinding = "viewBillerManager")
public class ViewBillerBean implements ViewBillerManager {

	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);
	
	
	public Account populate3p (int account){
		
		System.out.println("popu biller  invoked");
		
		Account acc = manager.find(Account.class, account);
		acc.getBillers().size();
		
		
		
		return acc;
		
	}
	
	
	public List<Biller> getBillers (int account){
		
		System.out.println("get billers invoked");
		try {
			logger.info("invoked the getUsers...");
			Query query = manager.createQuery("from Company user");
			
						
			List<Biller> users=(ArrayList<Biller>)query.getResultList();
			
			System.out.println("returning list get3p ");
			
			return users;


			
			
		} catch (NoResultException e) {
			logger.info("Exception i dont know ...", e);
			return null;
		}
		
		
		
		
				
	}


	@Override
	public List<Account> getCompanyAcc(int companyId) {
		// TODO Auto-generated method stub
		
		System.out.println("company id received : "+companyId);
		Company comp = manager.find(Company.class, companyId);
		comp.getAccounts().size();
		
		
		
		
		
		return comp.getAccounts();
	}


	@Override
	public List<Biller> setBillerValz(int selfAcc) {
		// TODO Auto-generated method stub
		
		Account acc = manager.find(Account.class, selfAcc);
		acc.getBillers().size();
		
		
		return acc.getBillers();
	}


	@Override
	public List<Customer> viewProfile(int selfAcc) {
		// TODO Auto-generated method stub
		
		Account acc = manager.find(Account.class, selfAcc);
		acc.getCustomers().size();
		
				
		return acc.getCustomers();
	}
	
}
