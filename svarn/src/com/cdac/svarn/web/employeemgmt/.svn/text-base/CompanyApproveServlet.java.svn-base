package com.cdac.svarn.web.employeemgmt;


import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.jndi.ContextUtils;

public class CompanyApproveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest requestObj, HttpServletResponse responseObj)
	throws IOException
	{
		doPost(requestObj, responseObj);
	}
//	EmployeeManager emb;
	TransactionManagerRemote emb;
	protected void doPost(HttpServletRequest requestObj, HttpServletResponse responseObj)
	throws IOException
	{
		responseObj.setContentType("text/xml");
		responseObj.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = responseObj.getWriter();
		

		int regId=Integer.parseInt((String)requestObj.getParameter("cmd"));
		Double amount=Double.parseDouble((String)requestObj.getParameter("amount"));

		System.out.println("approving id + amount : --------------------------"+regId+",+ ,   "+amount);

		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
//			Object ref = ctx.lookup("EmployeeManager");
			Object ref = ctx.lookup("TransactionManager");
			
//			emb = (EmployeeManager) ref;
			emb = (TransactionManagerRemote) ref;
			
			

			if (emb.approveCompanyRegistration(regId, amount)) {
				writer.println("Application successfully approved   " + regId);
			} else {
				writer.println("Application not successfully approved   "+ regId);
			}

		}catch(Exception e){
			System.out.println("exception in ApplicatApproveServlet-------------"+e );
		}

		writer.close();                

	}
}