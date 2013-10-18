package com.cdac.svarn.business.accountmgmt.autodebit;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.cdac.svarn.entities.AutoDebit;

@Remote
public interface AutoDebitManager {
	
	
	
//	public boolean addAutoDebit(int selfAcc,int adAcc,Date onDate,Double amount,String nickName,Double minBalance, ITimedBean helloEjb);
	
	public boolean addAutoDebit(int selfAcc,int adAcc,int onDate,Double amount,String nickName,Double minBalance);
	
	public void delAutoDebit();
	
	public void viewAutoDebit();

	public void printHello();
	
	public List<AutoDebit> getAutoDebits();
	
	public void autoTransfer(int i, int j, Double double1, Double double2);

}
