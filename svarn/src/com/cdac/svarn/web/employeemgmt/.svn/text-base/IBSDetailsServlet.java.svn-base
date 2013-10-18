package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.RegisterIb;
import com.cdac.svarn.entities.Registration;
import com.cdac.svarn.jndi.ContextUtils;


public class IBSDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest requestObj, HttpServletResponse responseObj)
	throws IOException
	{
		doPost(requestObj, responseObj);

	}
	EmployeeManager emb;
	protected void doPost(HttpServletRequest requestObj, HttpServletResponse responseObj)
	throws IOException
	{

		responseObj.setContentType("text/xml");
		responseObj.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = responseObj.getWriter();
		int ss=Integer.parseInt((String)requestObj.getParameter("qq"));


		
		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx;
			ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;

		

			ArrayList<RegisterIb> users = emb.getIbsUser();

			String putValue;
			writer.println("<table border=\"1\">");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Account NO");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+users.get(ss).getId().getAccountNo();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");
			
			Account acc=emb.getAccountNo(users.get(ss).getId().getAccountNo());
			
			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Account Type");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+acc.getAccountType();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Customer Id");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+users.get(ss).getId().getCustomerId();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");
			
			
			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("First Name");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=users.get(ss).getFirstName();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Mobile NO");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+users.get(ss).getMobileNo();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("applied on");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+users.get(ss).getAppliedOn();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("email Id");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=users.get(ss).getEmail();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("</table>");
			
			/*
		}

		if((ss>=users.size())&&(ss<companies.size()))
		{
			ss=ss-users.size();


			String putValue;
			writer.println("<table border=\"1\">");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("registrationId");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getRegistrationId();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Company Name");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getCompanyName();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Contact Person Name");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getContactPersonName();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Contact Person email Id");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getContactPersonEmail();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Contact Person Moblie No.");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getContactPersonMobile();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Branch Name");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getBranchName();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Branch City");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getBranchCity();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Branch State");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getBranchState();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("</table>");

		}

		ArrayList<IBSRegistration> ibss = emb.getIBSS();
		if(ss>=(users.size()+companies.size()))
		{

			ss=ss-(users.size()+companies.size());
			String putValue;
			writer.println("<table border=\"1\">");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Account No");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=ibss.get(ss).getAccountNo();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("<input type=\"hidden\" value="+putValue+" id=\"accountno\" name=\"accountno\"");
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("First Name");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=ibss.get(ss).getFirstName();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("AppliedON");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=ibss.get(ss).getAppliedOn();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Customer ID");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=ibss.get(ss).getCustId();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("<input type=\"hidden\" value="+putValue+" id=\"customerid\" name=\"customerid\"");
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Email ID");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=ibss.get(ss).getEmail();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("<input type=\"hidden\" value="+putValue+" id=\"email\" name=\"email\"");
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Moblie No.");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=ibss.get(ss).getMobileNo();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("<input type=\"hidden\" value="+putValue+" id=\"mobileno\" name=\"mobileno\"");
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("<input type='button' value='REJECT' id='denide' name='denide' />");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			writer.println("<input type=\"button\" value=\"APPROVED\" id=\"sendmaile\" name=\"sendmaile\" />");
			writer.println("</td>");
			writer.println("</tr>");



			writer.println("</table>");

		}

			 */
		} catch (Exception e) {
			System.out.println("problem in applicatn detail servlet ------------------------"+e);
		}
		writer.close();                    
	}        

}