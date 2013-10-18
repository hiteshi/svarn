package com.cdac.svarn.web.usermgmt;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.entities.Ib;
import com.cdac.svarn.jndi.ContextUtils;

public class SaveNewPasswordServelet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		// --------------- adding header info for session ---------------

		res.addHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.addHeader("Cache-Control", "pre-check=0,post-check=0");
		res.setDateHeader("Expires", 0);

		// ----------------------------------------------------------------
		// ------- redirecting page to home page if no cookie found

		HttpSession session = req.getSession(true);

		UserManager umr;
		ContextUtils contextUtils = new ContextUtils();
		Context ctx;
		
		try {
			
			ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("UserManager");
			umr = (UserManager) ref;
			
			
			
			Ib ib = new Ib();
			ib.setUserName(req.getParameter("userName"));
			ib.setUserPassword(req.getParameter("userPassword"));
			ib.setTransactionPassword(req.getParameter("transactionPassword"));
			//umr.saveUserPassword(ib);
			//Date date=null;
			umr.saveUserPassword(req.getParameter("oldUserName"),req.getParameter("userName"), req.getParameter("userPassword"), req.getParameter("transactionPassword"));
			
			
			/*session.setAttribute("customer", ib.getCustomer());
			session.setAttribute("username", ib.getUserName());
			
		//	System.out.println("setting cutomer ----> "+user.getCustomer().getCustomerId());
			
			
			//java.sql.Timestamp date = null;//java.sql.Timestamp();
			session.setAttribute("LastLogin",null);
			*/
			
			
			
			System.out.println("Passwords and User name sucessfully updated...");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/index.jsp");
			dispatch.forward(req, res);
			
			
		} catch (NamingException e) {
			
			System.out.println("Cound not save(in SaveNewPassword servelet)");
			session.invalidate();
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/svarn/view/generic/ErrorPage.jsp");
			dispatch.forward(req, res);
			e.printStackTrace();
		}
	}

}
