package com.cdac.svarn.web.transactionmgmt;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Ib;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;


/**
 * THIS IS A SERVLET RESPONSIBLE TO REDIRECT THE TRANSACTION CODE BACK TO AFTERLOGIN..... WHETHER SUCESSFUL OR NOT..
 * COZ THAT VALUE IS PRE CHECKED.
 * @author d1153029
 *
 */
public class TransactionSuccessfulServlet extends BusinessServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void execute (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserManager lmb;

		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("UserManager");
			lmb  = (UserManager) ref;
			Ib user;
			HttpSession session = req.getSession();
			user = lmb.populateUser((String)session.getAttribute("username"));
			System.out.println("getting accounts from username : "+(String)session.getAttribute("username"));
			//	---permanent comment				List<Account> accounts = new ArrayList<Account>();
			List<Account> accounts=user.getAccounts();


								System.out.println("after getting accounts list");
			session.setAttribute("accounts", accounts);

			RequestDispatcher dispatch = this.getServletContext()
			.getRequestDispatcher(
					"/view/usermgmt/afterLogin/HomePageAfterLogin.jsp");
			dispatch.forward(req, resp);






		}catch (Exception e) {
			// TODO: handle exception
		}




	}


}
