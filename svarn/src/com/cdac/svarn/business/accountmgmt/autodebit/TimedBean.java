/**
 * 
 */
package com.cdac.svarn.business.accountmgmt.autodebit;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.naming.Context;

import com.cdac.svarn.entities.AutoDebit;

/**
 * @author d1153029
 */
@Stateless(mappedName="ejb/timedBean")
public class TimedBean implements ITimedBean {

	@Resource
	private SessionContext ctx;
	
	public void startTimer() {
		System.out.println("ctx.getTimerService():  " + ctx.getTimerService());
//		ctx.getTimerService().createTimer(1000, 10000, null);
		ctx.getTimerService().createTimer(1000, 60000, "check-Auto-Debit" + (int)(Math.random()*10000));
		
		System.out.println("\n\nTimers set....\n\n");
	}

	public String checkStatus() {
		Timer timer = null;
		Collection<Object>timers = ctx.getTimerService().getTimers();
		Iterator<Object> iter = timers.iterator();
		while (iter.hasNext()) {
			timer = (Timer) iter.next();
			String message= null;
			System.out.println("Timer will expire after "
					+ timer.getTimeRemaining() + " milliseconds.");
			message = "Timer will expire after " + timer.getTimeRemaining() + " milliseconds.";
			message+= "\ntimer.getNextTimeout() : " +timer.getNextTimeout() +"\n\n";
			return message;
		}
		return ("No timer found");
	}

	@Timeout
	public void handleTimeout(Timer timer) {
		System.out.println("HandleTimeout called:  " + timer.getInfo());
		
		AutoDebitManager atp1;
		
		try{
			
			Context ctx = new javax.naming.InitialContext();
			Object ref = ctx.lookup("autoDebitManager");
			atp1  = (AutoDebitManager) ref;
			
			List<AutoDebit> adz = atp1.getAutoDebits();
			
			Date currDate = new Date();
			
			int today = currDate.getDate();
			int thatday =0;
			
			System.out.println("currDate : "+today);
			
			for(int i=0;i<adz.size();i++){
				
				thatday=adz.get(i).getOnDate();
				System.out.println("that date of : "+adz.get(i).getAutoNickName()+" = "+thatday);
				
				if (today == thatday){
					
					atp1.autoTransfer(adz.get(i).getAccount().getAccountNo(),adz.get(i).getBeneficiaryAccountNo(),adz.get(i).getAmount(),adz.get(i).getMinBalance());
					
					System.out.println("yo yo .....");
					
					
				}
				
				
			}
			
			
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

	@Override
	public int clearTimers() {
		int count =0;
		for(Object obj : ctx.getTimerService().getTimers()){
			Timer timer = (Timer)obj;
			System.out.println("\n\n going to clear the timer: " + timer.getInfo());
			timer.cancel(); 
			count++;
		}
		return count;
	}
}
