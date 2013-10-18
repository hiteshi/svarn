package com.cdac.svarn.business.accountmgmt.autodebit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.cdac.svarn.business.usermgmt.UserManagerBean;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.AutoDebit;
import com.cdac.svarn.entities.Transaction;

@Stateless
@RemoteBinding(jndiBinding = "autoDebitManager")
public class AutoDebitBean implements AutoDebitManager {
	
	@PersistenceContext(unitName = "svarn_persistence_context")
	private EntityManager manager;
	private static Logger logger = Logger.getLogger(UserManagerBean.class);
	
	
//	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
//	public boolean addAutoDebit(int selfAcc,int adAcc,Date onDate,Double amount,String nickName,Double minBalance,ITimedBean helloEjb) {
		public boolean addAutoDebit(int selfAcc,int adAcc,int onDate,Double amount,String nickName,Double minBalance) {
		// TODO Auto-generated method stub
		System.out.println("add auto invoked in bean");
		
		if(amount<0){
			System.out.println("negetive value of amount no transaction will be done");
			return false;
		}
		else{
		Account acc = manager.find(Account.class, selfAcc);
		acc.getAutoDebits().size();
		
		System.out.println("----1 acc : "+acc);
		
		AutoDebit ad = new AutoDebit();
		
		System.out.println("----2");
		
		ad.setAccount(acc);
		ad.setAmount(amount);
		ad.setBeneficiaryAccountNo(adAcc);
		ad.setOnDate(onDate);
		ad.setAutoNickName(nickName);
		ad.setMinBalance(minBalance);
		
		System.out.println("----3");
		
		manager.persist(ad);
		
		System.out.println("----4");
		
		manager.persist(acc);
		
		System.out.println("----5");
		
		Date xpiredate = new Date(System.currentTimeMillis() + 5000);//---------- xpire time
		
		System.out.println("----6");
		
		String selfAccT = ""+selfAcc;
		
		System.out.println("----7 selfAccT : "+selfAccT);
		
		String adAccT = ""+adAcc;
		
		System.out.println("----8 adAccT : "+adAccT);
		
//		helloEjb.startTimer();
//		scheduleTransfer(selfAccT,adAccT,xpiredate);
		
		System.out.println("----9");
		
		
		
		return true;
		}
				
	}
	
//	@Resource javax.ejb.TimerService timerService;
//	
//	public void scheduleTransfer(String selfAcc, String adAcc,Date dateOf){
//		
//		System.out.println("---- schedule timer invoked");
//		
//	String item = selfAcc + " is adding autoDebit Account as " + adAcc;
//
//	System.out.println("89: timerService: " + timerService);
//	System.out.println("item : "+item+" timer obj : "+timerService.getTimers());
//	
//	
//    for (Object obj : timerService.getTimers()) {
//    	System.out.println("----11");
//        javax.ejb.Timer timer = (javax.ejb.Timer)obj;
//        System.out.println("----12");
//        String scheduled = (String)timer.getInfo();
//        System.out.println("----13 scheduled : "+scheduled);
//        if (scheduled.equals(item)) {
//            timer.cancel();
//        }
//    }
//
//    timerService.createTimer(dateOf, item);
//}
//	
//	@Timeout
//    public void maintenance(javax.ejb.Timer timer) {
//       System.out.println("TIMEOUT METHOD CALLED");
//       String scheduled = (String)timer.getInfo();
//       System.out.println(scheduled);
//    }
//	
	

	@Override
	public void delAutoDebit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAutoDebit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printHello() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<5;i++)
		System.out.println("hello printing");
		
	}

	@Override
	public List<AutoDebit> getAutoDebits() {
		// TODO Auto-generated method stub
		
		try {
			logger.info("invoked the getAutoDebits...");
			Query query = manager.createQuery("from AutoDebit ad");
			List<AutoDebit> adz=(ArrayList<AutoDebit>)query.getResultList();
			return adz;

		} catch (NoResultException e) {
			logger.info("Exception because of user does not exist...", e);
			return null;
		}
		
		
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void autoTransfer(int fromAcc, int toAcc, Double amount, Double minBal) {
		// TODO Auto-generated method stub
		
		Account acc = manager.find(Account.class, fromAcc);
		acc.getAutoDebits().size();
		
		System.out.println("  -------- 1 ------- ");
		
		Double minCondition = minBal+amount;
		Double currBal = acc.getCurrentBalance();
		
		System.out.println("  ------- 2 ------- minCondition : "+minCondition+" currBal : "+currBal);
		
		if (minCondition <= currBal){
			
			System.out.println(" ------- 3 -------- ");
			
			currBal-=amount;
			
			System.out.println("  -------- 4 ------- after deducting amount from curr bal : "+currBal);
			
			Transaction trans1 = new Transaction();
			
			trans1.setAccount(acc);
			trans1.setCreditDebit("Debit");
			trans1.setRemarks("autoDebit to "+toAcc);
			trans1.setTransactionAmount(amount);
			trans1.setTransactionDate(new Date());
			trans1.setTransactionReference(toAcc);
			trans1.setTransactionType("Account");
			
			try{
			manager.persist(trans1);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("unable to persist trans1");
			}
			
			List<Transaction>  list2 = new ArrayList<Transaction>();
			list2.add(trans1);
			
			
			acc.setTransactions(list2);
			
			acc.setCurrentBalance(currBal);
			manager.merge(acc);
			
			System.out.println("  ------- 5 -------- after merging ");
			
			
			acc = manager.find(Account.class, toAcc);
			
			System.out.println("  -------- 6 ------- after finding to account ");
			
			currBal = acc.getCurrentBalance();
			
			System.out.println(" ------- 7 -------- got toAcc curr Bal : "+currBal);
			
			currBal+=amount;
			

			System.out.println("  -------- 8 ------- after adding amount to curr bal : "+currBal);
			
			Transaction trans = new Transaction();
			
			trans.setAccount(acc);
			trans.setCreditDebit("Credit");
			trans.setRemarks("autoDebit from "+fromAcc);
			trans.setTransactionAmount(amount);
			trans.setTransactionDate(new Date());
			trans.setTransactionReference(fromAcc);
			trans.setTransactionType("Account");
			
			manager.persist(trans);
			
			
			List<Transaction>  list1 = new ArrayList<Transaction>();
			list1.add(trans);
			
			
			acc.setTransactions(list1);
			
			
			
			acc.setCurrentBalance(currBal);
			manager.merge(acc);
			
			System.out.println("  ------- 9 -------- after merging");
			
			
			
		}
		else{
			
			System.out.println(" minimum condition not satisfied --------------- ");
			
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
