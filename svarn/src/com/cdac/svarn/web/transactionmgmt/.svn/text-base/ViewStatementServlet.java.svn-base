package com.cdac.svarn.web.transactionmgmt;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.entities.Transaction;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

/**
 * 
 * @author d1153029
 *
 */
public class ViewStatementServlet extends BusinessServlet {
	
private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}
	
	public void execute(HttpServletRequest requestObj, HttpServletResponse responseObj) throws ServletException, IOException
	{

		
		HttpSession session = requestObj.getSession();
		String startDate = (String) requestObj.getParameter("startdate");
		System.out.println("now calling transaction"+startDate);
		String endDate = (String) requestObj.getParameter("enddate");
		System.out.println("now calling transaction"+endDate);
		String account = (String) requestObj.getParameter("accnum");
		System.out.println("now calling transaction"+account);
		
		
		TransactionManagerRemote  ft;
		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("TransactionManager");
			ft  = (TransactionManagerRemote) ref;

			System.out.println("now calling transaction");
			
			
			
			session.setAttribute("startdate", startDate);
			session.setAttribute("enddate", endDate);
			
			
		
			List<Transaction> trans = ft.viewStatement(startDate, endDate, account);
			
//			System.out.println("AFTER PERFORM TRANSACTION : "+flag);
			
			if (trans!=null){
			
				requestObj.setAttribute("trans", trans);
				
				
//				RequestDispatcher dispatch = this.getServletContext()
//				.getRequestDispatcher("/view/transactionmgmt/display_statement.jsp");
				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/usermgmt/afterLogin/trial.jsp");
				dispatch.forward(requestObj, responseObj);
			
			}
			else{
				
				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/usermgmt/afterLogin/Xns.jsp");
				dispatch.forward(requestObj, responseObj);
				
			}
			
			}catch (Exception e) {
			// TODO: handle exception
		}
//		TransactionManager ft = new TransactionManager();
////		System.out.println("now calling transaction");
//		
//		ArrayList<Transaction> trans= new ArrayList<Transaction>();
//		trans = ft.viewStatement(startDate,endDate,account);
//		
//		if (trans!=null){
//		
//			requestObj.setAttribute("trans", trans);
//			
//			
//			RequestDispatcher dispatch = this.getServletContext()
//			.getRequestDispatcher("/view/transactionmgmt/display_statement.jsp");
//			dispatch.forward(requestObj, responseObj);
//		
//		}
//		else{
//			
//			RequestDispatcher dispatch = this.getServletContext()
//			.getRequestDispatcher("/view/usermgmt/afterLogin/Xns.jsp");
//			dispatch.forward(requestObj, responseObj);
//			
//		}
		
		
		
		
		
	}
	
	
	

}
