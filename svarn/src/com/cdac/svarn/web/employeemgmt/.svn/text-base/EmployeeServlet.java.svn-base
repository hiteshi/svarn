
package com.cdac.svarn.web.employeemgmt;


import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		doPost(req, res);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String a="2";
		/*	CustomerManager cmr = new CustomerManager();
			ArrayList<Registration> users = cmr.getUsers();
			request.setAttribute("U", users);
			request.setAttribute("selectEmployee", a);
			*/	
					RequestDispatcher dispatch = this.getServletContext()
					.getRequestDispatcher("/view/employeemgmt/EmployeeHome.jsp");
			dispatch.forward(request, response);
				

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
