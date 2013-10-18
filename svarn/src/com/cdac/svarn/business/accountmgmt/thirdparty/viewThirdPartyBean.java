package com.cdac.svarn.business.accountmgmt.thirdparty;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.business.usermgmt.UserManagerBean;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.ThirdParty;




@Stateless
@RemoteBinding(jndiBinding = "viewThirdPartyManager")
public class viewThirdPartyBean implements viewThirdPartyManager {

	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);
	
	
	public Account populate3p (int account){
		
		System.out.println("popu3p invoked");
		
		Account acc = manager.find(Account.class, account);
		acc.getThirdParties().size();
		return acc;
		
	}
	
	
	public List<ThirdParty> getThirdParties (int account){
		
		System.out.println("get3p invoked");
		Account acc = manager.find(Account.class, account);
		
		System.out.println("returning list get3p ");
		
		return acc.getThirdParties();
		
				
	}


	public List<ThirdParty> setTpValz(int selfAcc) {
		// TODO Auto-generated method stub
		
		Account acc = manager.find(Account.class, selfAcc);
		acc.getThirdParties().size();
		
		
		
		
		return acc.getThirdParties();
	}
	
}
