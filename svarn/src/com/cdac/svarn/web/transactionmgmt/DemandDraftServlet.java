package com.cdac.svarn.web.transactionmgmt;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class DemandDraftServlet extends BusinessServlet{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//HttpSession session = requestObj.getSession();
		
		String inFavourOf = (String) requestObj.getParameter("inFavourOf");
		System.out.println("now calling transaction"+inFavourOf);
		String payableAt = (String) requestObj.getParameter("payableAt");
		System.out.println("now calling transaction"+payableAt);
		String accountNo = (String) requestObj.getParameter("ddaccount");
		System.out.println("now calling transaction"+accountNo);
		String amount = (String) requestObj.getParameter("amountdd");
		System.out.println("now calling transaction"+amount);
		String remarks = (String) requestObj.getParameter("remarksdd");
		System.out.println("now calling transaction"+remarks);
	
		
		
		TransactionManagerRemote  ft;
		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("TransactionManager");
			ft  = (TransactionManagerRemote) ref;

			System.out.println("now calling transaction");
			
			
			boolean flag=false;
			flag = ft.onlineDD(accountNo, amount, inFavourOf, payableAt, remarks);
			
			System.out.println("AFTER PERFORM TRANSACTION : "+flag);
			
			if (flag){

				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/usermgmt/afterLogin/Xs.jsp");
				dispatch.forward(requestObj, responseObj);

				//			ft.addRemark(remarks);

			}
			else {

				RequestDispatcher dispatch = this.getServletContext()
				.getRequestDispatcher("/view/usermgmt/afterLogin/Xns.jsp");
				dispatch.forward(requestObj, responseObj);

			}
			
			}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		TransactionManager ft = new TransactionManager();
//		System.out.println("now calling transaction");
//		
//		boolean flag=false;
//		flag = ft.onlineDD(accountNo,amount,inFavourOf,payableAt,remarks);
//		if (flag){
//			
//			RequestDispatcher dispatch = this.getServletContext()
//			.getRequestDispatcher("/view/usermgmt/afterLogin/Xs.jsp");
//			dispatch.forward(requestObj, responseObj);
//			
////			ft.addRemark(remarks);
//			
//		}
//		else {
//			
//			RequestDispatcher dispatch = this.getServletContext()
//			.getRequestDispatcher("/view/usermgmt/afterLogin/Xns.jsp");
//			dispatch.forward(requestObj, responseObj);
//			
//		}
		
		
	}
	

}
