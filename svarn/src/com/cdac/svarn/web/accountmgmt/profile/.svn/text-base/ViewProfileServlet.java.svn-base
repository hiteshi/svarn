/**
 * 
 */
package com.cdac.svarn.web.accountmgmt.profile;

import java.io.PrintWriter;
import java.util.List;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.biller.ViewBillerManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Biller;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

/**
 * @author d1153029
 *
 */
public class ViewProfileServlet extends BusinessServlet {
	
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
			PrintWriter writer = responseObj.getWriter();
			Account populatedAcc;
			
			System.out.println("view profile servlet invoked");
//			ArrayList<ThirdParty> thirdParties=new ArrayList<ThirdParty>();
			
			int self = Integer.parseInt((String)requestObj.getParameter("self"));
//			int tpacc = Integer.parseInt((String)requestObj.getParameter("tp"));
			
			System.out.println("self acc number received : "+self);
//			System.out.println("tp acc number received : "+tpacc);
			
			
//		populated3p = tp.populate3p(companyId);
			List<Customer> companyAcc =  tp.viewProfile(self);
			
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
				
			for (int i=0;i<companyAcc.size();){	
//			
				System.out.println("yo---------");
				
//				if (companyAcc.get(i).getBillerAccountNo() == tpacc){
					
					System.out.println("the condition satisfied in billler wala ");
					
					int j=1;
					writer.println("<table border=\"1\">");
					
					writer.println("<tr><td>First Name :</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustFirstName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Last Name	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustLastName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Gender 	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustGender()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>DOB :</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustDob()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Fathers Name 	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustFatherName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Mothers Name 	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustMotherName()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Phone 	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustPhone()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Mobile 	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustMobile()+"'/><br>");
					writer.println("</td></tr>");
					j++;
					writer.println("<tr><td>Email 	:</td><td>");
					writer.println("<input type='text' readonly='readonly' name='compacc"+j+"' value='"+companyAcc.get(i).getCustEmail()+"'/><br>");
					writer.println("</td></tr>");
					
					writer.println("</table>");
					break;
					
//				}
				
				
//			writer.println("<option value='"+companyAcc.get(i).getAccountNo()+"'>	"+companyAcc.get(i).getAccountNo()+"");
//				
////			writer.println("	${acc.currentBalance}");
////			writer.println("	${acc.accountType}");
////			writer.println("	${acc.nickName }");
//			writer.println(""+companyAcc.get(i).getBranch().getBranchName()+"");
			
			}			
//			writer.println("</option>");
////			writer.println("</c:forEach>");
//			writer.println("</select>");
			
			HttpSession session = requestObj.getSession();
			session.setAttribute("viewProfile", companyAcc);
			
			
			System.out.println("after setting companies set in session ");
			
		}
		catch(Exception e)
		{
			System.out.println("exception in servlet : "+e);
		}
	}  
	

}
