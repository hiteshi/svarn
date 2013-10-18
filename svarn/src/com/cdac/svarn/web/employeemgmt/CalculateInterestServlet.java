package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.jndi.ContextUtils;

public class CalculateInterestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	PrintWriter writer=null;
	TransactionManagerRemote emb;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse responseObj)
	throws ServletException, IOException {
try{
		System.out.println("inside CalculateInterestServlet start----------------");
		ContextUtils contextUtils = new ContextUtils();
		Context ctx = contextUtils.getInitialContext();
		Object ref = ctx.lookup("TransactionManager");
		
		emb = (TransactionManagerRemote) ref;
		
		
		
		writer = responseObj.getWriter();
		if(req.getParameter("cmd").endsWith("CalculateSavingInterest")){

			boolean result= emb.CalculateInterest();
			if(result)
				writer.println("Interest Calculated... ");
			else
				writer.println("Ooops..!! Error occured while Calculation... ");
		}

	}catch(Exception e){
		System.out.println("Exception in CalculateInterestServlet---------"+e);
	}
	}

}
