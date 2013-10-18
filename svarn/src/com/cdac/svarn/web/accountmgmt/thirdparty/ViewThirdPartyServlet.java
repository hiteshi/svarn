package com.cdac.svarn.web.accountmgmt.thirdparty;



import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.thirdparty.viewThirdPartyManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.ThirdParty;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class ViewThirdPartyServlet extends BusinessServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{
		
		
		viewThirdPartyManager tp;
		try{
			
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("viewThirdPartyManager");
			tp  = (viewThirdPartyManager) ref;
			
			Account populated3p;
			
			System.out.println("view 3p invoked");
//			ArrayList<ThirdParty> thirdParties=new ArrayList<ThirdParty>();
			
			int accountNo = Integer.parseInt((String)requestObj.getParameter("val"));
			
			System.out.println("acc number received : "+accountNo);
			
			
		populated3p = tp.populate3p(accountNo);
			List<ThirdParty> thirdParties=  populated3p.getThirdParties();
			
			System.out.println("after getting set of 3p ");
			
//			Set<ThirdParty> thirdParties= tp.getThirdParties(accountNo);
			
			
//			String account=requestObj.getParameter("val");
			
			//System.out.println("received object  ------------------ "+account);
			
//			viewThirdParty vtpb = new viewThirdParty();
//			thirdParties=vtpb.getThirdParty(account);
			
			
			
			HttpSession session = requestObj.getSession();
			session.setAttribute("tps", thirdParties);
			
			
			System.out.println("after setting 3p set in session ");
			
		}
		catch(Exception e)
		{
			System.out.println("exception in servlet : "+e);
		}
	}  
}
