/**
 * 
 */
package com.cdac.svarn.web.usermgmt;

import java.io.IOException;
import java.util.List;

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
import com.cdac.svarn.constant.Constants;
import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.Ib;
import com.cdac.svarn.jndi.ContextUtils;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;




	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	// CONF OBJECT IS PASSED SO AS TO RETAIN THE CONIG OF THIS SERVLET

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		doPost(req, res);
	}

	@SuppressWarnings("unused")
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

		if (session == null) {

			System.out.println("SESSION = NULL \nRedirecting... TO INDEX.JSP");
			res.sendRedirect("/svarn/index.jsp");

		}

		//-----------------------------------------------------------------------

		if (!session.getId().equals(req.getParameter("sessId"))) {

			System.out.println("sessionId=" + req.getParameter("sessId")
					+ " and inside=" + session.getId());
			session.invalidate();
			System.out.println("SESSION NOT EXIST SO \nRedirecting... TO INDEX.JSP");
			res.sendRedirect("/svarn");

		}


		else {
			
			try {
				ContextUtils contextUtils = new ContextUtils();
				Context ctx = contextUtils.getInitialContext();
				Object ref = ctx.lookup("UserManager");
				UserManager umr = (UserManager) ref;
				String loginId = (String) req.getParameter("UserName");
				String password = (String) req.getParameter("Password");
				Ib user = umr.isUserExists(loginId, password);
				
				//System.out.println("user.getCustomer().getCustomerId() ---->"+user.getCustomer().getCustomerId());
				//System.out.println("user.getCustomer().getCustomerId() ---->"+user.getAccounts().get(0).getAccountNo());
				System.out.println("user) ---->"+user);
				
				Ib cmpr = null;
			//	System.out.println("value of user is : "+ user);
				if(user == cmpr){
					
					System.out.println("Right now in it is getting NULL.....");
					System.out.println("User name or Password not maching.....");
					res.sendRedirect("/svarn?");
					
					
				}
				else
				  {

					System.out.println("Right now in it is getting Something.....");
					session.setAttribute(Constants.LOGINID, loginId);
					//session.setAttribute("accounts",user.getAccounts());
					session.setAttribute("customer", user.getCustomer());
					session.setAttribute("username", loginId);
					System.out.println("User Name in Login servelet :"+loginId);
				//	System.out.println("setting cutomer ----> "+user.getCustomer().getCustomerId());
					String str = user.getLatestLoginDate().toString();
					System.out.println("setting date as : "+ str);
					java.sql.Timestamp date = (java.sql.Timestamp) user.getLatestLoginDate();
					session.setAttribute("LastLogin",user.getLatestLoginDate().toString());
					
					
					System.out.println("setting date asighjgj : "+ date);
					
					user = umr.populateUser(loginId);
					
				//	System.out.println("after populate user ");
					
					//umr.setibuser(user);
					

					
					List<Account> accounts=user.getAccounts();
//					List<Account> accounts=umr.getAccounts(loginId);
				//	System.out.println("after list banne k bad.......... ");
					session.setAttribute("accounts", accounts);
					

					
					for (int i=0;i<accounts.size();i++){
						
				//	System.out.println("A/C --> "+accounts.get(i).getAccountNo());
			
					}
					//if(user.getLatestLoginDate()!=null){
						RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/view/usermgmt/afterLogin/HomePageAfterLogin.jsp");
						dispatch.forward(req, res);
//					}else {
//						
//						RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/view/usermgmt/afterLogin/ChangeUserName.jsp");
//						dispatch.forward(req, res);
//					}
					
				} 
				

			} catch (Exception ex) {
				//ex.printStackTrace();
				System.out.println("in catch block");
				RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/view/usermgmt/afterLogin/ChangeUserName.jsp");
				dispatch.forward(req, res);
			}

		}
	}

}
