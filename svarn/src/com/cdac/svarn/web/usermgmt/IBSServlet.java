package com.cdac.svarn.web.usermgmt;

import java.io.IOException;
import java.math.BigInteger;
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
import com.cdac.svarn.entities.RegisterIb;
import com.cdac.svarn.entities.RegisterIbPK;
import com.cdac.svarn.jndi.ContextUtils;

public class IBSServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		UserManager umr;
		boolean result=false;
		System.out.println("-------------------------->>>>>>>>>>req.getParameter(cname) "+req.getParameter("cname")+" req.getParameter(accnum) "+ req.getParameter("accnum")+" req.getParameter(phno) "+req.getParameter("phno")+" req.getParameter(emid) "+req.getParameter("emid")+" req.getParameter(custId) "+req.getParameter("custId"));
		
		RegisterIb regValues=new RegisterIb();
		RegisterIbPK obj=new RegisterIbPK();
		
		obj.setAccountNo(Integer.parseInt(req.getParameter("accnum")));
		obj.setCustomerId(Integer.parseInt(req.getParameter("custId")));
		regValues.setId(obj);
		regValues.setFirstName(req.getParameter("cname"));
		regValues.setMobileNo(new BigInteger(req.getParameter("phno")));
		regValues.setEmail(req.getParameter("emid"));
		Date date=new Date();
		System.out.println(date+"-------------this is the date");
		regValues.setAppliedOn(new Date());
		
		ContextUtils contextUtils = new ContextUtils();
		Context ctx;
		try {
			ctx = contextUtils.getInitialContext();

			Object ref = ctx.lookup("UserManager");
			umr = (UserManager) ref;
			result= umr.saveIBS(regValues);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		if(result) {

			RequestDispatcher dispach = this.getServletContext().getRequestDispatcher("/view/generic/SuccessfulSaved.jsp");
			dispach.forward(req, res);
		}
		else {
			RequestDispatcher dispach = this.getServletContext().getRequestDispatcher("/view/html/SaveError.html");
			dispach.forward(req, res);
		}
	}/*
	public boolean registarIBS(String firstName,String accNo,String mobileNo,String emailID, String custID){

		try {

			ConnectionFactory cf = new ConnectionFactory();
			con = cf.getConnection();
			String sql = "INSERT INTO IBS_REGISTRATION(ACCOUNT_NO, FIRST_NAME, MOBILE_NO, EMAIL, APPLIED_ON, CUST_ID) VALUES ("+accNo+",'"+firstName+"',"+mobileNo+",'"+emailID+"',curdate(),"+custID+")";
			System.out.println("SQL ==="+sql);
			ptmt = con.prepareStatement(sql);

			int ptmtReturn=ptmt.executeUpdate();

			if(ptmtReturn==1) return true;
			else return false;


		}
		catch (Exception e) {

			System.err.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
*/

}
