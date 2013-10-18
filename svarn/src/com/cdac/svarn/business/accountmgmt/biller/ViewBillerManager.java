package com.cdac.svarn.business.accountmgmt.biller;



import java.util.List;

import javax.ejb.Remote;

import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.entities.ThirdParty;




	@Remote
	public interface ViewBillerManager {
		
		public List<Biller> getBillers(int account);
				
		public Account populate3p(int accountNo);

		public List<Account> getCompanyAcc(int companyId);
		
		public List<Biller> setBillerValz(int selfAcc);
		
		public List<Customer> viewProfile(int selfAcc);
		
	}
	
	
	

