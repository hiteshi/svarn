package com.cdac.svarn.web.usermgmt;


import java.io.IOException;
import java.math.BigInteger;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.entities.RegisterCompany;
import com.cdac.svarn.jndi.ContextUtils;

public class CompanyRegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	RegisterCompany user = new RegisterCompany();
		user.setCompanyName((String) req.getParameter("companyName"));
		user.setContactPersonName((String) req.getParameter("contactPersonName"));
		user.setContactPersonEmail((String) req.getParameter("contactPersonemailId"));
		user.setContactPersonMobile(new BigInteger((String) req.getParameter("contactPersonMobile")));
		user.setBranchCity((String) req.getParameter("branchCity"));
		user.setBranchState((String) req.getParameter("branchState"));
		user.setBranchName((String) req.getParameter("branchName"));
		
		UserManager umb;
		
		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("UserManager");

			umb = (UserManager) ref;
			
			Boolean flag = umb.createCompany(user);
			if (flag) {
				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/generic/RegistrationSuccessful.jsp");
				dispatch.forward(req, res);
			} else {
				res.sendRedirect("/svarn");
			}

		}catch(Exception e){
			System.out.println("exception in ApplicatApproveServlet-------------"+e );
		}
/*		try {
			UserManager cmr = new UserManager();
			Boolean flag = cmr.createCompany(user);
			if (flag) {
				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/generic/NewFile.jsp");
				dispatch.forward(req, res);
			} else {
				res.sendRedirect("/svarn/index.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
	}
}
