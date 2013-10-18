package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManager;
import com.cdac.svarn.entities.RegisterClosing;
import com.cdac.svarn.jndi.ContextUtils;


public class ClosingDetailsServlet extends HttpServlet {

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

		

			ArrayList<RegisterClosing> companies = emb.getClosings();



			String putValue;
			writer.println("<table border=\"1\">");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("registrationId");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+companies.get(ss).getClosingId();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Account No");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+companies.get(ss).getAccountNo();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Customer Id");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=""+companies.get(ss).getUserId();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("<tr>");
			writer.println("<td width=\"150\">");
			writer.println("Feedback");
			writer.println("</td>");
			writer.println("<td width=\"150\">");
			putValue=companies.get(ss).getFeedback();
			writer.println(putValue);
			writer.println("</td>");
			writer.println("</tr>");


			writer.println("</table>");
			
		} catch (Exception e) {
			System.out.println("problem in applicatn detail servlet ------------------------"+e);
		}
		writer.close();                    
	}        

}