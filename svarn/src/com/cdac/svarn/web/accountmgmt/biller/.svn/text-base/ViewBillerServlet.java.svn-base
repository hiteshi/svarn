package com.cdac.svarn.web.accountmgmt.biller;



import java.util.List;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.biller.ViewBillerManager;
import com.cdac.svarn.business.accountmgmt.thirdparty.viewThirdPartyManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.entities.ThirdParty;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class ViewBillerServlet extends BusinessServlet {

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
			int accountNo = Integer.parseInt((String)requestObj.getParameter("val"));
			
			System.out.println("acc number received : "+accountNo);
			
			
			populated3p = tp.populate3p(accountNo);
			List<Biller> thirdParties=  populated3p.getBillers();

			System.out.println("after getting set of 3p ");
			
			
			
			HttpSession session = requestObj.getSession();
			session.setAttribute("billers", thirdParties);
			
			
			System.out.println("after setting billers set in session ");
			
		}
		catch(Exception e)
		{
			System.out.println("exception in servlet : "+e);
		}
	}  
	
 
}
