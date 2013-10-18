package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;


import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManager;

import com.cdac.svarn.jndi.ContextUtils;

public class CompanyRejectServlet extends HttpServlet{

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
		System.out.println("hi rohit inside rejection servlet................");
		responseObj.setContentType("text/xml");
		responseObj.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = responseObj.getWriter();
		
		System.out.println("tuple yuo wan to delete   : "+(String)requestObj.getParameter("cmd"));
		
		
		int ss=Integer.parseInt((String)requestObj.getParameter("cmd"));

		System.out.println("deleting reg id : --------------------------"+ss);

		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;

			if(emb.deleteCompanyRegistration(ss))
			{
				writer.println("Application successfully deleted from the DataBase  "+ss);
			}
			else
			{
				writer.println("Application not successfully deleted from the DataBase  "+ss);
			}
		}
		catch(Exception e){
			writer.println("Application not successfully deleted from the DataBase  "+ss);
			System.out.println("problem in rejection servlet ----------------------"+e);
		}


		writer.close(); 

	}
}
