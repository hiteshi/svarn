package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManager;
import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.entities.RegisterIb;
import com.cdac.svarn.entities.Registration;
import com.cdac.svarn.jndi.ContextUtils;


public class IBSTableServlet extends HttpServlet {


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
		System.out.println("hi rohit................");
		try{
			responseObj.setContentType("text/xml");
			responseObj.setHeader("Cache-Control", "no-cache");
			PrintWriter writer = responseObj.getWriter();




			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;

			int i=0;

			ArrayList<RegisterIb> users = emb.getIbsUser();
			writer.println("<table border=\"1\">");
			writer.println("<tr>");
			writer.println("<th>Reg. ID</th>");
			writer.println("<th>Name</th>");
			writer.println("</tr>");

			for(;i<users.size();i++)
			{
				String link="<td><a href=\"#\" onclick=\"JavaScript:xmlhttpPost("+i+","+users.get(i).getId().getAccountNo()+","+users.get(i).getId().getCustomerId()+");\">"+users.get(i).getId().getCustomerId()+"</a>";
				writer.println(""+link);
				writer.println("</td>");
				writer.println("<td>"+users.get(i).getFirstName()+"</td>");
				writer.println("</tr>");
			}

			writer.println("</table>");

/*
			ArrayList<RegistrationCompany> companies = emr.getUsers();

			writer.println("<br>");

			writer.println("<table border=\"1\">");
			writer.println("<tr>");
			writer.println("<th>Reg. ID</th>");
			writer.println("<th>Company Name</th>");
			writer.println("</tr>");
			int newsize=(companies.size()+users.size());
			for(int ii=0;i<newsize;i++,ii++)
			{
				String link="<td><a href=\"#\" onclick=\"JavaScript:xmlhttpPost("+i+","+users.size()+");\">"+companies.get(ii).getRegistrationId()+"</a>";
				writer.println(""+link);
				writer.println("</td>");
				writer.println("<td>"+companies.get(ii).getCompanyName()+"</td>");
				writer.println("</tr>");
			}

			writer.println("</table>");




			ArrayList<IBSRegistration> ibss = emr.getIBSS();

			writer.println("<br>");

			writer.println("<table border=\"1\">");
			writer.println("<tr>");
			writer.println("<th>Account No</th>");
			writer.println("<th>Customer ID</th>");
			writer.println("</tr>");
			newsize=(companies.size()+users.size()+ibss.size());
			for(int ii=0;i<newsize;i++,ii++)
			{
				String link="<td><a href=\"#\" onclick=\"JavaScript:xmlhttpPost("+i+","+(users.size()+companies.size())+");\">"+ibss.get(ii).getAccountNo()+"</a>";
				writer.println(""+link);
				writer.println("</td>");
				writer.println("<td>"+ibss.get(ii).getCustId()+"</td>");
				writer.println("</tr>");
			}

			writer.println("</table>");


*/


			writer.close();    
		}catch (Exception e) {
			// TODO: handle exception
		}
	}        

}
