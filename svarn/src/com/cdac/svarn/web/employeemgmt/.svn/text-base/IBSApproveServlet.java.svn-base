package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManager;
import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.jndi.ContextUtils;


public class IBSApproveServlet extends HttpServlet{
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
		

		int custId = Integer.parseInt((String)requestObj.getParameter("cid"));
		int accountNo = Integer.parseInt((String)requestObj.getParameter("acc"));

		
		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("EmployeeManager");
		//	Object ref = ctx.lookup("TransactionManager");
	
			emb = (EmployeeManager) ref;
		//	emb = (TransactionManagerRemote) ref;
			
			

			if (emb.approveIBSRegistration(custId, accountNo)) {
				writer.println("Application successfully approved   " );
			} else {
				writer.println("Application not successfully approved   ");
			}

		}catch(Exception e){
			System.out.println("exception in ApplicatApproveServlet-------------"+e );
		}

		writer.close();                

	}
}
/*package in.cdac.svarn.web.employeemgmt;

import in.cdac.svarn.business.employeemgmt.EmployeeManager;
import in.cdac.svarn.business.usermgmt.CustomerManager;
import in.cdac.svarn.entities.Registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovedServlet extends HttpServlet{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest requestObj, HttpServletResponse responseObj)
	throws IOException
	{
		responseObj.setContentType("text/xml");

		responseObj.setHeader("Cache-Control", "no-cache");

		
		PrintWriter writer = responseObj.getWriter();
		System.out.println("tuple you want to add   : "+(String)requestObj.getParameter("qq"));
		
		int ss=Integer.parseInt((String)requestObj.getParameter("qq"));
		
		
		EmployeeManager emb = new EmployeeManager();
		

		CustomerManager cmr = new CustomerManager();
		ArrayList<Registration> users = cmr.getUsers();
		
		if(ss<users.size()){
			emb.approveApplicant(ss);
		//	System.out.println("size is : --------------------------user "+ss);
		}
		else{
			ss=ss-users.size();
		//	System.out.println("size is : --------------------------comp "+ss);
			emb.approveCompanies(ss);
		}
		
		
		
		
		
		
		
		writer.println("Application Approved."  );
		writer.close();                
	}
}
*/