/**
 * 
 */
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

/**
 * @author d1153029
 *
 */
@Stateless
@RemoteBinding(jndiBinding = "addThirdPartyManager")
public class AddThirdPartyBean implements AddThirdPartyManager{

	
	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);
	@Override
	public boolean add3p(String selfacc, String tpacc, String tpname,
			String nickname, String limit) {
		// TODO Auto-generated method stub
		
		System.out.println("add3p invoked");
		
		
		int tpaccount = Integer.parseInt(tpacc);
		int adToAcc = Integer.parseInt(selfacc);
		
		System.out.println("after parsing int ");
		
		Double xferlimit = Double.parseDouble(limit);
		Account acc = manager.find(Account.class, tpaccount);
		
		// if exist then add
		if(acc == null){
		
			System.out.println("third party account not found sorry!!");
			return false;
		}
		else{
			
			acc = manager.find(Account.class, adToAcc);
			
			System.out.println("----1");
			
			ThirdParty tp = new ThirdParty();
			
			System.out.println("----2");
			
			tp.setAccount(acc);
			tp.setTpAccountNo(tpaccount);
			tp.setTpName(tpname);
			tp.setTpNickName(nickname);
			tp.setTransferLimit(xferlimit);
			
			System.out.println("----3");
			
			manager.persist(tp);
			
			System.out.println("----4");
			
			manager.persist(acc);
			
		
			
			System.out.println("----5");
			
			
			return true;
			
		}
		
		
		
		
		
	}
	
	public boolean del3p(String selfacc, String tpacc, String tpname,
			String nickname, String limit) {
		// TODO Auto-generated method stub
		
		
		System.out.println("adel 3p invoked");
		
		
		int tpaccount = Integer.parseInt(tpacc);
		int adToAcc = Integer.parseInt(selfacc);
		int tpid = 0;
		System.out.println("after parsing int ");
		
		Double xferlimit = Double.parseDouble(limit);
		Account acc = manager.find(Account.class, tpaccount);
		
		// if exist then add
		if(acc == null){
		
			System.out.println("third party account not found sorry!!");
			return false;
		}
		else{
			
			acc = manager.find(Account.class, adToAcc);
			acc.getThirdParties().size();
			
			System.out.println("----1");
			
			
			List<ThirdParty> li = acc.getThirdParties();
			
			System.out.println("----2 list is : "+li);
			
			for(int i=0;i<li.size();i++){
				
				System.out.println(" tp account no"+ li.get(i).getTpAccountNo());
				
				if(li.get(i).getTpAccountNo() == tpaccount){
					
					
					
					tpid = li.get(i).getThirdPartyId();
					System.out.println("----3 got id as : "+tpid);
					
				}
				
			}
			
			
			System.out.println("----4");	
			
			ThirdParty tp = manager.find(ThirdParty.class, tpid);
			
			manager.remove(tp);
			
					
			System.out.println("----5");
			
			
			return true;
			
		}
		
		
		
	}
	
	
}
