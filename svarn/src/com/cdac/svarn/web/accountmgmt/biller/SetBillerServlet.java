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
import com.cdac.svarn.business.accountmgmt.thirdparty.viewThirdPartyManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.entities.ThirdParty;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

/**
 * @author d1153029
 *
 */
public class SetBillerServlet extends BusinessServlet {

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
			
			System.out.println("view profile servlet invoked");
//			ArrayList<ThirdParty> thirdParties=new ArrayList<ThirdParty>();
			
			int self = Integer.parseInt((String)requestObj.getParameter("self"));
			int tpacc = Integer.parseInt((String)requestObj.getParameter("tp"));
			
			System.out.println("self acc number received : "+self);
			System.out.println("tp acc number received : "+tpacc);
			
			
//		populated3p = tp.populate3p(companyId);
			List<Biller> companyAcc =  tp.setBillerValz(self);
			
			System.out.println("after getting set of companies ");
			
//			Set<ThirdParty> thirdParties= tp.getThirdParties(accountNo);
			
			
//			String account=requestObj.getParameter("val");
			
			//System.out.println("received object  ------------------ "+account);
			
//			viewThirdParty vtpb = new viewThirdParty();
//			thirdParties=vtpb.getThirdParty(account);
			
//			writer.write();
			
			
			
			
//			writer.println("<select name=\"xxx\" id=\"companyaccountlist\" onchange=\"javascript:changeOn('compacc1')\" >");
//			
//			writer.println("<option selected=\"selected\">Select Account   </option>");
//			writer.println("<c:forEach items=\"${companyAcc}\" var=\"acc\">");
			writer.println("<table border=\"1\">");	
			for (int i=0;i<companyAcc.size();i++){	
//			
				System.out.println("yo---------");
				
				if (companyAcc.get(i).getBillerAccountNo() == tpacc){
					
					System.out.println("the condition satisfied in billler wala ");
					
					int j=1;
					writer.println("<tr><td>Third Party A/C</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getBillerAccountNo()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Third Party Name 		</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getBillerName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Third Party Nick Name 	</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getBillerNickName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Third Party limt </td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getTransferLimit()+"'/><br>");
					writer.println("</td></tr>");
					break;
					
				}
				
			
			}	
			writer.println("</table>");
//			writer.println("</option>");
////			writer.println("</c:forEach>");
//			writer.println("</select>");
			
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
