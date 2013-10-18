/**
 * 
 */
package com.cdac.svarn.web.accountmgmt.biller;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.biller.AddBillerManager;
import com.cdac.svarn.business.transactionmgmt.TransactionManagerRemote;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;

/**
 * @author d1153029
 *
 */
public class PayBillServlet extends BusinessServlet{
	
	private static final long serialVersionUID = 1L;

	public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{
		HttpSession session = requestObj.getSession();
		
		try{
		System.out.println("delete biller servlet me aa gaya");
		
//		tp.setSelfAccountNo((String)session.getAttribute("account_no"));
//		tp.setNameOfThirdParty((String) requestObj.getParameter("name"));
//		tp.setThirdPartyAccountNo((String) requestObj.getParameter("accno"));
//		tp.setTpNickName((String) requestObj.getParameter("nick"));
//		tp.setTransferLimit((String) requestObj.getParameter("limit"));
		
		
		String selfacc = (String)requestObj.getParameter("self");
//		String tpname = (String) requestObj.getParameter("compacc2");
		String tpacc = (String) requestObj.getParameter("compacc1");
//		String nickname = (String) requestObj.getParameter("compacc3");
//		String limit = (String) requestObj.getParameter("compacc4");
		String toChangeAmnt = (String) requestObj.getParameter("tochangeamnt");
		String remarks = (String) requestObj.getParameter("remarks");
		
		System.out.println("self acc :"+selfacc);
		TransactionManagerRemote  ft;
		try{

			ContextUtils contextUtils = new ContextUtils();
			Context ctx = contextUtils.getInitialContext();
			Object ref = ctx.lookup("TransactionManager");
			ft  = (TransactionManagerRemote) ref;

			System.out.println("now calling transaction");
			
			
			boolean flag=false;
			flag = ft.fundsLogic(selfacc,tpacc,toChangeAmnt,remarks);
			
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
		
		}catch (Exception e) {
			// TODO: handle exception
		}

}
}
