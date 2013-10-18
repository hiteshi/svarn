/**
 * 
 */
package com.cdac.svarn.web.accountmgmt.biller;

import java.io.PrintWriter;
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

/**
 * @author d1153029
 *
 */
public class SetCompanyServlet extends BusinessServlet {

	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{
		
		
		ViewBillerManager tp;
		try{
			
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("viewBillerManager");
			tp  = (ViewBillerManager) ref;
			PrintWriter writer = responseObj.getWriter();
			Account populated3p;
			
			System.out.println("set company invoked");
//			ArrayList<ThirdParty> thirdParties=new ArrayList<ThirdParty>();
			
			int companyId = Integer.parseInt((String)requestObj.getParameter("val"));
			
			System.out.println("acc number received : "+companyId);
			
			
//		populated3p = tp.populate3p(companyId);
			List<Account> companyAcc =  tp.getCompanyAcc(companyId);
			
			System.out.println("after getting set of companies ");
			
//			Set<ThirdParty> thirdParties= tp.getThirdParties(accountNo);
			
			
//			String account=requestObj.getParameter("val");
			
			//System.out.println("received object  ------------------ "+account);
			
//			viewThirdParty vtpb = new viewThirdParty();
//			thirdParties=vtpb.getThirdParty(account);
			
//			writer.write();
			
			
			
			
			writer.println("<select name=\"xxx\" id=\"companyaccountlist\" onchange=\"javascript:changeOn('compacc1')\" >");
			
			writer.println("<option selected=\"selected\">Select Account   </option>");
//			writer.println("<c:forEach items=\"${companyAcc}\" var=\"acc\">");
				
			for (int i=0;i<companyAcc.size();i++){	
			
			writer.println("<option value='"+companyAcc.get(i).getAccountNo()+"'>	"+companyAcc.get(i).getAccountNo()+"");
				
//			writer.println("	${acc.currentBalance}");
//			writer.println("	${acc.accountType}");
//			writer.println("	${acc.nickName }");
			writer.println(""+companyAcc.get(i).getBranch().getBranchName()+"");
			
			}			
			writer.println("</option>");
//			writer.println("</c:forEach>");
			writer.println("</select>");
			
			HttpSession session = requestObj.getSession();
			session.setAttribute("companyAcc", companyAcc);
			
			
			System.out.println("after setting companies set in session ");
			
		}
		catch(Exception e)
		{
			System.out.println("exception in servlet : "+e);
		}
	}  
	
	
}
