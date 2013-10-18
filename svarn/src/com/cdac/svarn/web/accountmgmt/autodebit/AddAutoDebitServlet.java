package com.cdac.svarn.web.accountmgmt.autodebit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.autodebit.AutoDebitManager;
import com.cdac.svarn.business.accountmgmt.autodebit.ITimedBean;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class AddAutoDebitServlet extends BusinessServlet implements ServletContextListener {
	
	private static final long serialVersionUID = 1L;
	@EJB(name = "timerBean", mappedName = "ejb/timedBean")
	private ITimedBean timerBean;
	
	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{
		HttpSession session = requestObj.getSession();
		
		try{
		System.out.println(" add auto debit servlet me aa gaya");
				
	
		int selfacc = Integer.parseInt((String)requestObj.getParameter("tpself"));
		int adacc = Integer.parseInt((String) requestObj.getParameter("adacc"));
		Double amount = Double.parseDouble((String)requestObj.getParameter("amount"));
		String onDate = (String) requestObj.getParameter("onDate");
		Double minBalance = Double.parseDouble((String) requestObj.getParameter("minBalance"));
		String nickName = (String) requestObj.getParameter("nick");
		
		System.out.println("self : "+selfacc+" adacc : "+adacc+" amount : "+amount+" onDate :"+onDate+" minBal :"+minBalance+" nick : "+nickName);
		
		int ondate = Integer.parseInt(onDate);
		
//		DateFormat formatter ; 
//		Date ondate = null ;
//		
//		 formatter = new SimpleDateFormat("yyyy-MM-dd");
//		 try {
//			ondate = (Date)formatter.parse(onDate);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			System.out.println("in catch of date");
//			e.printStackTrace();
//		}
//		
		
		System.out.println("date made to :"+ondate);
		AutoDebitManager atp;
		ITimedBean helloEjb;
		
		try{
			
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("autoDebitManager");
			helloEjb = (ITimedBean) ctx.lookup("ejb/timedBean");
			System.out.println("27: result of lookup helloEjb" + helloEjb);
			System.out.println("helloEjb: " + helloEjb);
			atp  = (AutoDebitManager) ref;
			
			System.out.println("----1");
			
//			boolean flag=atp.addAutoDebit(selfacc, adacc, ondate, amount, nickName, minBalance,helloEjb);
			boolean flag=atp.addAutoDebit(selfacc, adacc, ondate, amount, nickName, minBalance);
			
			System.out.println("----2");
			
			
//			just trial code
//			if(amount == 5){
//				
//				helloEjb.clearTimers();
//				
//			}
			
			
			
			helloEjb.startTimer();
			
			
			System.out.println("AFTER adding autodebit flag : "+flag);
			
			if (flag){

				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/usermgmt/afterLogin/Xs.jsp");
				dispatch.forward(requestObj, responseObj);

				//			ft.addRemark(remarks);

			}
			else {

				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/usermgmt/afterLogin/Xns.jsp");
				dispatch.forward(requestObj, responseObj);

			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in servlet : "+e);
		}
		
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("kuch prob hai...");
		}	
	
	

}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
