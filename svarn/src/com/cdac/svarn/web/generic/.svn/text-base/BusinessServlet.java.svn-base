package com.cdac.svarn.web.generic;


import com.cdac.svarn.constant.Constants;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

abstract public class BusinessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		this.doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		clearCache(res);
		trackSession(req, res);
		execute(req, res);

	}
	
	private void clearCache(HttpServletResponse servletResponse) {
		servletResponse.addHeader("Pragma", "no-cache");
		servletResponse.setHeader("Cache-Control",
				"no-cache,no-store,must-revalidate");
		servletResponse.addHeader("Cache-Control", "pre-check=0,post-check=0");
		servletResponse.setDateHeader("Expires", 0);

	}
	
	public void trackSession(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute(Constants.LOGINID);
		if (loginId == null) {
			try {
				res.sendRedirect("/svarn/index.jsp");
			} catch (Exception ex) {
				ex.printStackTrace();

			}

		}

	}//---------- track session ----
	
	
	abstract public void execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;
	
	
	
	
	
	

}
