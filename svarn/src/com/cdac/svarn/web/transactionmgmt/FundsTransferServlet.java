package com.cdac.svarn.web.transactionmgmt;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

public class FundsTransferServlet extends BusinessServlet{


	private static final long serialVersionUID = 1L;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}
	
	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) throws ServletException, IOException
	{

		System.out.println("funds servlet invoked ... ");
		HttpSession session = requestObj.getSession();

		String toChangeAmnt = (String) requestObj.getParameter("tochangeamnt");
		System.out.println("now calling transaction"+toChangeAmnt);
		String remarks = (String) requestObj.getParameter("remarks");
		System.out.println("now calling transaction"+remarks);
		String accountTo = (String) requestObj.getParameter("accTo");
		System.out.println("now calling transaction"+accountTo);
		String accountFrom = (String) requestObj.getParameter("accFrom");
		System.out.println("now calling transaction"+accountFrom);

		//		String toChangeAmnt = "458.68";
		//			String remarks = "Xfer";
		//			String accountTo = "2114412375";
		//				String accountFrom = "2114412376";
		TransactionManagerRemote  ft;
		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("TransactionManager");
			ft  = (TransactionManagerRemote) ref;

			System.out.println("now calling transaction");
			
			
			boolean flag=false;
			flag = ft.fundsLogic(accountFrom,accountTo,toChangeAmnt,remarks);
			
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
		//TransactionManagerRemote ft = new TransactionManagerRemote();
		

		

	}

}
