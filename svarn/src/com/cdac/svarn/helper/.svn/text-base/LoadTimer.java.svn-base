/**
 * 
 */
package com.cdac.svarn.helper;

import com.cdac.svarn.business.accountmgmt.autodebit.ITimedBean;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author deepak
 */
public class LoadTimer implements ServletContextListener {
	// @EJB(name="timerBean", mappedName="ejb/TimedBean/remote")
	@EJB(name = "timerBean", mappedName = "ejb/timedBean")
	private ITimedBean timerBean;

	ITimedBean helloEjb;
	public void contextInitialized(ServletContextEvent servletcontextevent) {
		System.out.println("**************\nStarting timer");
		try {
			Context context = new InitialContext();
			helloEjb = (ITimedBean) context.lookup("ejb/timedBean");
			System.out.println("27: result of lookup helloEjb" + helloEjb);
			/*helloEjb = (ITimedBean) context.lookup(ITimedBean.class.getName());
			System.out.println("29: result of lookup helloEjb" + helloEjb);*/
			System.out.println("helloEjb: " + helloEjb);
//			
			helloEjb.clearTimers();
			System.out.println("yoyo---------------------------------timer cleared in load timer");
			
			helloEjb.startTimer();
			
		} catch (Exception e) {
			System.out.println("\n\n\ne.getMessage(): " + e.getMessage());
//			e.printStackTrace();
		}


		//TODO check this out, why this injection is not working
		System.out.println("timerBean is : " + timerBean);
//		timerBean.startTimer();
		System.out.println(" timer started...");
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		System.out.println("****context getting destroyed");
		if( helloEjb!=null) {
			System.out.println("clearing timers: " + helloEjb.clearTimers());
		}
	}

	public ITimedBean getTimerBean() {
		return timerBean;
	}

	public void setTimerBean(ITimedBean timerBean) {
		this.timerBean = timerBean;
	}

}