package com.cdac.svarn.web.accountmgmt.biller;





import java.util.List;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.biller.ViewBillerManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class IdentifyAccountServlet extends BusinessServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{
		
		
		ViewBillerManager tp;
		try{
			
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("viewBillerManager");
			tp  = (ViewBillerManager) ref;
			
			Account populated3p;
			
			System.out.println("view Biller invoked");
//			ArrayList<ThirdParty> thirdParties=new ArrayList<ThirdParty>();
			
			int accountNo = Integer.parseInt((String)requestObj.getParameter("val"));
			
			System.out.println("acc number received : "+accountNo);
			
			
		populated3p = tp.populate3p(accountNo);
			List<Biller> thirdParties=  tp.getBillers(accountNo);
			
			System.out.println("after getting set of companies ");
			
//			Set<ThirdParty> thirdParties= tp.getThirdParties(accountNo);
			
			
//			String account=requestObj.getParameter("val");
			
			//System.out.println("received object  ------------------ "+account);
			
//			viewThirdParty vtpb = new viewThirdParty();
//			thirdParties=vtpb.getThirdParty(account);
			
			
			
			HttpSession session = requestObj.getSession();
			session.setAttribute("companies", thirdParties);
			
			
			System.out.println("after setting companies set in session ");
			
		}
		catch(Exception e)
		{
			System.out.println("exception in servlet : "+e);
		}
	}  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void doPost(HttpServletRequest requestObj, HttpServletResponse responseObj) 
//	{
//		try{
//			
//			ThirdParty tp=new ThirdParty();
//			ArrayList<ThirdParty> thirdParties=new ArrayList<ThirdParty>();
//			
//			String account=requestObj.getParameter("val");
//			
//			System.out.println("received object  ------------------ "+account);
//			
//			viewThirdParty vtpb = new viewThirdParty();
//			thirdParties=vtpb.getThirdParty(account);
//			HttpSession session = requestObj.getSession();
//			session.setAttribute("tps", thirdParties);
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println("exception in servlet : "+e);
//		}
//	}  
}





























//import java.io.PrintWriter;
//
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class IdentifyAccountServlet extends HttpServlet{
//
//	private static final long serialVersionUID = 1L;
//
//	public void doPost(HttpServletRequest requestObj, HttpServletResponse responseObj) 
//	{
//		
//		
//		try{
//		System.out.println(" servlet me aa gaya");
//		
//		String abcd=requestObj.getParameter("val");
//		
//		System.out.println("received object  ------------------ "+abcd);
//		HttpSession session = requestObj.getSession();
//		
//		session.setAttribute("account", abcd);
//		
//		
//		PrintWriter writer = responseObj.getWriter();
//		writer.println("siddddddddddddddddddddd");
//		}
//		catch(Exception e)
//		{
//			System.out.println("exception in servlet : "+e);
//		}
//	}  
//}
