package com.cdac.svarn.web.usermgmt;



import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.employeemgmt.EmployeeManagerBean;
import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.jndi.ContextUtils;

public class AvailableUserNameServlet extends HttpServlet {
	
	
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
		
		String userName=req.getParameter("uname");
		//System.out.println(req.getParameter("oldUserName"));
		System.out.println("User Name : "+ userName);
		PrintWriter writer = res.getWriter();
		UserManager umr;

		try {

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("UserManager");
			umr = (UserManager) ref;
			
			
			res.setContentType("text/xml");
			res.setHeader("Cache-Control", "no-cache");
			
			boolean result=umr.isUserNameExist(userName);
			if(result){
				writer.println("available");
			}else {
				writer.println("not available");
			}
			
		} catch (Exception ex) {
			System.out.println("exception in AvailableUserNameServlet servlet.....................");
		}
		finally{
			writer.close();
		}
	}

}
