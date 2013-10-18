package com.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManager;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class AccTypeAvailableServlet extends BusinessServlet {

	EmployeeManager emb;
	@Override 
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/xml");
		res.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = res.getWriter();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+req.getParameter("cmd"));
		
		if(req.getParameter("cmd").equals("check")){
			
			int var=check(req.getParameter("accname"));
			if(var==1)
				res.getWriter().println("1");
			else
				res.getWriter().println("alskdjfkkkkkkk");
			
		}
		
		
		if(req.getParameter("cmd").equals("SaveNewData")){
			
			boolean var=SaveNewData(req.getParameter("accountName"),req.getParameter("accRate"));
			if(var)
				res.getWriter().println("1");
			else
				res.getWriter().println("alskdjfkkkkkkk");
			
		}
		
		if(req.getParameter("cmd").equals("SaveLoanData")){
			
			boolean var=SaveLoanData(req.getParameter("accountName"),req.getParameter("accRate"));
			if(var)
				res.getWriter().println("1");
			else
				res.getWriter().println("alskdjfkkkkkkk");
			
		}
		
		
		
		if(req.getParameter("cmd").equals("UpdateData")){
			
			String accountName=req.getParameter("accountName");
			String accRate=req.getParameter("accRate");
			boolean xyz=UpdateData(accountName,accRate);
			if(xyz)
				res.getWriter().println("1");
			else
				res.getWriter().println("alskdjfkkkkkkk");
		}
		
		
		
		if(req.getParameter("cmd").equals("UpdateLoanData")){
			
			String accountName=req.getParameter("accountName");
			String accRate=req.getParameter("accRate");
			boolean xyz=UpdateLoanData(accountName,accRate);
			if(xyz)
				res.getWriter().println("1");
			else
				res.getWriter().println("alskdjfkkkkkkk");
		}
	
		writer.close();
		
	}
	public int check(String accname){
		
		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx;
			ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;

			boolean result=emb.isAccountExists(accname);
			if(result)
				return 1;
			else
				return 2;

		} catch (Exception e) {
			System.out.println("problem in applicatn detail servlet ------------------------"+e);
			return 2;
		}

	}
	
	public boolean SaveNewData(String accountName,String accRate){
		
		System.out.println("NOw in Save DAta");
		
	try {
		ContextUtils contextUtils = new ContextUtils();
		Context ctx;
		ctx = contextUtils.getInitialContext();

		Object ref = ctx.lookup("EmployeeManager");
		emb = (EmployeeManager) ref;
		emb.creatingNewAccount(accountName, accRate);
		
		return true;
	} catch (Exception e) {
		
		System.out.println("problem in applicatn detail servlet ------------------------"+e);
		return false;
		
	}
	
	}
	public boolean SaveLoanData(String accountName,String accRate){
		
		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx;
			ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;
			emb.creatingLoanAccount(accountName, accRate);
			
			return true;
		} catch (Exception e) {
			
			System.out.println("problem in applicatn detail servlet ------------------------"+e);
			return false;
			
		}
		
		}
	public boolean UpdateData(String accountName,String accRate){
		
		
		System.out.println("i am in Upadate");
		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx;
			ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;
			emb.UpdateData(accountName, accRate);
			
			return true;
		} catch (Exception e) {
			
			System.out.println("problem in applicatn detail servlet ------------------------"+e);
			return false;
			
		}
		
		}
	public boolean UpdateLoanData(String accountName,String accRate){
		
		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx;
			ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("EmployeeManager");
			emb = (EmployeeManager) ref;
			emb.UpdateLoan(accountName, accRate);
			
			return true;
		} catch (Exception e) {
			
			System.out.println("problem in applicatn detail servlet ------------------------"+e);
			return false;
			
		}
		
		}
	
}
