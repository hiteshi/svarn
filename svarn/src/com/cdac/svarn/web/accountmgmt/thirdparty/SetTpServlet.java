/**
 * 
 */
package com.cdac.svarn.web.accountmgmt.thirdparty;

import java.io.PrintWriter;
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

/**
 * @author d1153029
 *
 */
public class SetTpServlet extends BusinessServlet {

	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{
		
		
		viewThirdPartyManager tp;
		try{
			
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("viewThirdPartyManager");
			tp  = (viewThirdPartyManager) ref;
			PrintWriter writer = responseObj.getWriter();
			Account populated3p;
			
			System.out.println("set company invoked");
			int self = Integer.parseInt((String)requestObj.getParameter("self"));
			int tpacc = Integer.parseInt((String)requestObj.getParameter("tp"));
			
		
			
			List<ThirdParty> companyAcc =  tp.setTpValz(self);
			
		
			writer.println("<table>");
			for (int i=0;i<companyAcc.size();i++){	
		
				if (companyAcc.get(i).getTpAccountNo() == tpacc){
					
					System.out.println("the condition satisfied ");
					
					
					int j=1;
					writer.println("<tr><td>Third Party A/C </td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getTpAccountNo()+"'/><br>");
					writer.println("</td></tr>");
					
					j++;
					writer.println("<tr><td>Third Party Name 		</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getTpName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Third Party Nick Name 	</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getTpNickName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Third Party limt </td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getTransferLimit()+"'/><br>");
					writer.println("</td></tr>");
					
					break;
					
				}
			
			
			}writer.println("</table>");			
		
			
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
