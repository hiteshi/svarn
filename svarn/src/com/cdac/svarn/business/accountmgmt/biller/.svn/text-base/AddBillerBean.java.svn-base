package com.cdac.svarn.business.accountmgmt.biller;

/**
 * 
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.business.usermgmt.UserManagerBean;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.entities.Transaction;

/**
 * @author d1153029
 *
 */
@Stateless
@RemoteBinding(jndiBinding = "addBillerManager")
public class AddBillerBean implements AddBillerManager{

	
	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);
	
	
	
	
	public boolean addBiller(String selfacc, String tpacc, String tpname,
			String nickname, String limit) {
		// TODO Auto-generated method stub
		
		System.out.println("add biller invoked");
		
		
		int tpaccount = Integer.parseInt(tpacc);
		int adToAcc = Integer.parseInt(selfacc);
		
		System.out.println("after parsing int ");
		
		Double xferlimit = Double.parseDouble(limit);
//		Account acc = manager.find(Account.class, tpaccount);
		
		// if exist then add
//		if(acc == null){
//		
//			System.out.println("biller account not found sorry!!");
//			return false;
//		}
//		else{
			
			Account acc = manager.find(Account.class, adToAcc);
			
			System.out.println("----1");
			
			Biller tp = new Biller();
			
			System.out.println("----2");
			
			
			tp.setAccount(acc);
			tp.setBillerAccountNo(tpaccount);
			tp.setBillerName(tpname);
			tp.setBillerNickName(nickname);
			tp.setTransferLimit(xferlimit);
			
			
			System.out.println("----3");
			
			manager.persist(tp);
			
			System.out.println("----4");
			
			manager.persist(acc);
			
		
			
			System.out.println("----5");
			
			
			return true;
			
		}//----- ADD BILLER 
		
			
	public boolean delbiller(String selfacc, String tpacc, String tpname,
			String nickname, String limit) {
		// TODO Auto-generated method stub
		
		
		System.out.println("del biller invoked tpacc :"+tpacc+" selfacc : "+ selfacc);
		
		
		int tpaccount = Integer.parseInt(tpacc);
		System.out.println("----1 int tpacc: "+tpaccount);
		int adToAcc = Integer.parseInt(selfacc);
		System.out.println("----2");
		int tpid = 0;
		System.out.println("after parsing int ");
		
		Double xferlimit = Double.parseDouble(limit);
		Account acc = manager.find(Account.class, tpaccount);
		
		// if exist then add
		if(acc == null){
		
			System.out.println("biller account not found sorry!!");
			return false;
		}
		else{
			
			acc = manager.find(Account.class, adToAcc);
			acc.getThirdParties().size();
			
			System.out.println("----1");
			
			
			List<Biller> li = acc.getBillers();
			
			System.out.println("----2 list is : "+li);
			
			for(int i=0;i<li.size();i++){
				
				System.out.println(" tp account no"+ li.get(i).getBillerAccountNo());
				
				if(li.get(i).getBillerAccountNo() == tpaccount){
					
					
					
					tpid = li.get(i).getBillerId();
					System.out.println("----3 got id as : "+tpid);
					
				}
				
			}
			
			
			System.out.println("----4");	
			
			Biller tp = manager.find(Biller.class, tpid);
			
			manager.remove(tp);
			
					
			System.out.println("----5");
			
			
			return true;
			
		}
		
		
		
	}


	

}
