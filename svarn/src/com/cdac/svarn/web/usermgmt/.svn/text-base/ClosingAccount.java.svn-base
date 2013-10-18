package com.cdac.svarn.web.usermgmt;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.helper.SendMail;
import com.cdac.svarn.jndi.ContextUtils;


public class ClosingAccount extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String customerId=req.getParameter("CustomerId");
		String accountNo= req.getParameter("AccountNo");
		String feedback= req.getParameter("Feedback");
		
		System.out.println("Customer Id----------------"+customerId);
		System.out.println("Account No----------------"+accountNo);
		System.out.println("Acfeedakdjfkdj----------------"+feedback);
		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("UserManager");
			UserManager umr = (UserManager) ref;
			umr.closeAccount(accountNo, customerId,feedback);
			
			
			/* -------------------------------Redirecting Problem -------------------------------- */
			
			
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/view/html/Welcome.html");
			dispatch.forward(req, res);
			
			/* -------------------------------Check the above block -------------------------------- */
			
			System.out.println("Sucessfully Registered.. Redirecting to home page");
			
		}catch (Exception e) {
			
			System.out.println("Error in Registaring.. "+e);
		}
		
		/*
		String senderEmailID="nikhil.sharma.it@gmail.com";
		String emailSubject="PIN for colsing an account";
		String emailBody= "your pin no is : ";
		
		
		
		
		System.out.println("recever email id :"+senderEmailID);
		System.out.println("recever email body :"+emailBody);
		emailBody= "this is a test complain mail";
		
		SendMail sm=new SendMail();
		sm.sendMail(senderEmailID, emailSubject, emailBody);
		System.out.println("Complan Male hase been send");*/
		
	}

}
