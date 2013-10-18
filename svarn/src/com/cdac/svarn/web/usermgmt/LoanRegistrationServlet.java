package com.cdac.svarn.web.usermgmt;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.entities.RegisterLoan;
import com.cdac.svarn.entities.Registration;
import com.cdac.svarn.jndi.ContextUtils;

/**
 * @author nikhil
 * 
 */
public class LoanRegistrationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public Date dateParser(String d) {
		try {
			String str_date = d;
			Date date;
			DateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd");

			date = (Date) formatter.parse(str_date);

			return date;

		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}
		return null;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		System.out.println("inside loan Registration Servlet--------------1----------");
		UserManager umr;

		try {
			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("UserManager");
			umr = (UserManager) ref;

			Boolean flag = false;

			RegisterLoan user = new RegisterLoan();

			user.setFirstName((String) req.getParameter("firstName"));
			user.setLastName((String) req.getParameter("lastName"));
			user.setGender((String) req.getParameter("gender"));
			String dob = (String) req.getParameter("dateOfBirth");
			Date DOB = dateParser(dob);

			user.setDateOfBirth(DOB);
			user.setFatherName((String) req.getParameter("fatherName"));
			user.setMotherName((String) req.getParameter("motherName"));
			user.setEmailId((String) req.getParameter("emailId"));
			String mob = (String) req.getParameter("mobileNo");
			BigInteger mobile = new BigInteger(mob);
			user.setMobileNo(mobile);
			user.setPanCard((String) req.getParameter("panCard"));
			user.setForm((String) req.getParameter("form"));


			user.setBranchName((String) req.getParameter("branchName"));
			user.setAddressLine1((String) req.getParameter("addressLine1"));
			user.setAddressLine2((String) req.getParameter("addressLine2"));
			user.setCity((String) req.getParameter("city"));
			user.setState((String) req.getParameter("state"));
			int pin = Integer.parseInt((String) req.getParameter("pinCode"));
			user.setPinCode(pin);

			System.out.println("inside loan Registration Servlet------------2.1------------");

			try{
				int term=Integer.parseInt((String)req.getParameter("periodPremium"));
				System.out.println("inside loan Registration Servlet------------2.2------------");

				
				user.setLoanType("Term Loan");
				user.setSpecificType(req.getParameter("termType"));
				user.setPeriodOfPremimum(Integer.parseInt((String)req.getParameter("periodPremium")));
				user.setPremium(Double.parseDouble((String)req.getParameter("premium")));
				user.setSpecificType((String)req.getParameter("termType"));
				
			}catch(Exception e){
				System.out.println("inside loan Registration Servlet------------2.3------------");
				user.setSpecificType(req.getParameter("demandType"));
				user.setLoanType("Demand Loan");
				user.setSpecificType((String)req.getParameter("demandType"));
				user.setTimeLimit(Integer.parseInt((String)req.getParameter("timeLimit")));

			}

			System.out.println("inside loan Registration Servlet------------2.4------------");


			user.setAmountRequired(Double.parseDouble((String)req.getParameter("amtRequest")));







			System.out.println("inside loan Registration Servlet------------2.5------------");
			flag = umr.createLoanUser(user);
			System.out.println("inside loan Registration Servlet-------------3-----------");
			ctx = null;

			if (flag) {
				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher(
						"/view/generic/RegistrationSuccessful.jsp");
				dispatch.forward(req, res);
			} else {
				res.sendRedirect("/view/generic/ErrorPage.jsp");
			}

		} catch (NamingException ex) {
			ex.printStackTrace();
		}

	}
}
