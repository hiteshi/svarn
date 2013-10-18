package com.cdac.svarn.web.usermgmt;

//import com.cdac.svarn.connection.ConnectionFactory;
//import in.cdac.svarn.entities.Customer;
//import in.cdac.svarn.entities.IBS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.usermgmt.UserManager;
import com.cdac.svarn.entities.Customer;
import com.cdac.svarn.jndi.ContextUtils;

/**
 * TODO : Write a short summary of this type
 * 
 * @author d1153025
 * 
 */

public class IBSRegistrationServlet extends HttpServlet {

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



		String custId=req.getParameter("cid");
		String accNo=req.getParameter("acc");
		PrintWriter writer = res.getWriter();
		UserManager umr;

		try {

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("UserManager");
			umr = (UserManager) ref;
			System.out.println("in servlet getting user object as : ");

			System.out.println("cusId = "+custId+" acc = "+accNo);

			List<Customer> cust = umr.isValidUser(custId, accNo);
			if(cust!=null){

				boolean flag=false;
				for (int i=0; i<cust.size();i++ ){

					if (cust.get(i).getCustomerId() == Integer.parseInt(custId)){
						System.out.println("Customer email id = "+cust.get(i).getCustEmail() );


						res.setContentType("text/xml");
						res.setHeader("Cache-Control", "no-cache");


						writer.println("<form id='f1' action='/svarn/saveibs' method='post'>");
						writer.println("<fieldset><legend>CONFORM THE DETAILS</legend>");
						writer.println("<table height=\"200\" width=\"400\"><tr>");
						writer.println("<td><list>Customer First Name</list></td><td><list>:</list></td>");
						writer.println("<td><input id=\"cname\" name=\"cname\" type=\"text\" readonly value=\""+cust.get(i).getCustFirstName()+"\" ></td></tr><tr>");
						writer.println("<td><list>Phone No</list></td><td><list>:</list></td>");
						writer.println("<td><input id=\"phno\" name=\"phno\" type=\"text\" maxlength=\"10\" value=\""+cust.get(i).getCustMobile()+"\"></td>");
						writer.println("</tr><tr><td><list>Email Id</list></td>	<td><list>:</list></td>");
						writer.println("<td><input id=\"emid\" name=\"emid\" type=\"text\" value=\""+cust.get(i).getCustEmail()+"\" ></td>");
						writer.println("<td><input id=\"accnum\" name=\"accnum\" type=\"hidden\" value=\""+accNo+"\" ><input id=\"custId\" name=\"custId\" type=\"hidden\" value=\""+custId+"\" ></td>");
						writer.println("</tr><tr><td colspan=\"4\" align=\"right\"><input id=\"countinue\" type=\"submit\"");
						writer.println("value=\" Countinue \"></td></tr></table></fieldset></form>");
						flag=true;
					}



				}
			}
			else{
				System.out.println("Customer not Exist");
				res.setContentType("text/xml");
				res.setHeader("Cache-Control", "no-cache");
				writer.println("<fieldset>");
				writer.println("<table height=\"201\" width=\"400\"><tr>");
				writer.println("<td align='center'>Incorrect Account No or Customer ID</td></tr></table></fieldset>");
			}
			/*

			if(cust!=null){

				System.out.println("Customer email id = "+cust.getCustEmail() );


				res.setContentType("text/xml");
				res.setHeader("Cache-Control", "no-cache");


				writer.println("<form id='f1' action='/svarn/saveibs' method='post'>");
				writer.println("<fieldset><legend>CONFORM THE DETAILS</legend>");
				writer.println("<table height=\"200\" width=\"400\"><tr>");
				writer.println("<td><list>Customer First Name</list></td><td><list>:</list></td>");
				writer.println("<td><input id=\"cname\" name=\"cname\" type=\"text\" readonly value=\""+cust.getCustFirstName()+"\" ></td></tr><tr>");
				writer.println("<td><list>Phone No</list></td><td><list>:</list></td>");
				writer.println("<td><input id=\"phno\" name=\"phno\" type=\"text\" maxlength=\"10\" value=\""+cust.getCustMobile()+"\"></td>");
				writer.println("</tr><tr><td><list>Email Id</list></td>	<td><list>:</list></td>");
				writer.println("<td><input id=\"emid\" name=\"emid\" type=\"text\" value=\""+cust.getCustEmail()+"\" ></td>");
				writer.println("<td><input id=\"accnum\" name=\"accnum\" type=\"hidden\" value=\""+accNo+"\" ><input id=\"custId\" name=\"custId\" type=\"hidden\" value=\""+custId+"\" ></td>");
				writer.println("</tr><tr><td colspan=\"4\" align=\"right\"><input id=\"countinue\" type=\"submit\"");
				writer.println("value=\" Countinue \"></td></tr></table></fieldset></form>");



			}else {
				System.out.println("Customer not Exist");
				res.setContentType("text/xml");
				res.setHeader("Cache-Control", "no-cache");
				writer.println("<fieldset>");
				writer.println("<table height=\"201\" width=\"400\"><tr>");
				writer.println("<td align='center'>Incorrect Account No or Customer ID</td></tr></table></fieldset>");
			}

			 */

		} catch (NamingException ex) {
			System.out.println("exception in IBSREGistration servlet.....................");
		}
		finally{
			writer.close();
		}
	}


}
