/**
 * 
 */
package com.cdac.svarn.web.accountmgmt.thirdparty;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.svarn.business.accountmgmt.thirdparty.AddThirdPartyManager;
import com.cdac.svarn.jndi.ContextUtils;
import com.cdac.svarn.web.generic.BusinessServlet;
/**
 * @author d1153029
 *
 */
public class DeleteThirdPartyServlet extends BusinessServlet{

		private static final long serialVersionUID = 1L;

		public void execute (HttpServletRequest requestObj, HttpServletResponse responseObj) 
		{
			HttpSession session = requestObj.getSession();
			
			try{
			System.out.println("delete 3p servlet me aa gaya");
			
			
			String selfacc = (String)requestObj.getParameter("tpself");
			String tpname = (String) requestObj.getParameter("compacc2");
			String tpacc = (String) requestObj.getParameter("compacc1");
			String nickname = (String) requestObj.getParameter("compacc3");
			String limit = (String) requestObj.getParameter("compacc4");
			
			System.out.println("self acc :"+selfacc);
			AddThirdPartyManager atp;
			
			try{
				
				ContextUtils contextUtils = new ContextUtils();
				Context ctx = contextUtils.getInitialContext();
				Object ref = ctx.lookup("addThirdPartyManager");
				atp  = (AddThirdPartyManager) ref;
				
				System.out.println("----1");
				
				boolean flag=atp.del3p(selfacc,tpacc,tpname,nickname,limit);
				
				
				System.out.println("AFTER adding third party : "+flag);
				
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
				System.out.println("exception in servlet : "+e);
			}
			
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("kuch prob hai...");
			}	
			
		}	
			
	}		
			
	

