package com.cdac.svarn.web.usermgmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.helper.SendMail;
import com.cdac.svarn.web.generic.BusinessServlet;

public class SendcomplanServelet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
			doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String senderEmailID=req.getParameter("emailId");
		String emailSubject="Complaint";
		String emailBody= req.getParameter("complane");
		String receverEmailID="svarnbank@gmail.com";
		
		System.out.println("sender email id :"+senderEmailID);
		System.out.println("email body :"+emailBody);
		
		SendMail sm=new SendMail(senderEmailID, receverEmailID,emailSubject, emailBody);

		System.out.println("Complan Mail hase been send");
		
		System.out.println("Complaint is registered;");
		
		res.sendRedirect("/svarn/view/html/LodgeComplain.html");

		

		
	}

}
