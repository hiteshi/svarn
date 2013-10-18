/**
 * 
 */
package com.cdac.svarn.web.usermgmt;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.web.generic.BusinessServlet;

/**
 * @author d1153029
 *
 */
public class LogoutServlet extends BusinessServlet {


	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	// CONF OBJECT IS PASSED SO AS TO RETAIN THE CONIG OF THIS SERVLET

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		doPost(req, res);
	}

	public void execute (HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();
			System.out.println(session.getAttribute("custFirstName")+" "+session.getAttribute("custLastName")+" has Logged out");
//			Customer cmr=(Customer)session.getAttribute("custDetails");

//			System.out.println(cmr.getCustFirstName()+" has Logged out");
			session.invalidate();
			res.sendRedirect("/svarn/");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
