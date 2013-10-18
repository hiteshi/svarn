/*package in.cdac.svarn.web.employeemgmt;

import java.io.IOException;
import in.cdac.svarn.business.employeemgmt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovedIBS extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	PreparedStatement ptmt=null;
	Connection con=null;
	ResultSet rs = null;
	EmployeeManager em = new EmployeeManager();

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
		String accNo=req.getParameter("ano");
		String emailId=req.getParameter("eid");
		String phNo=req.getParameter("pno");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>Customer Id : "+custId+" Account No : "+accNo+" emailId ="+emailId+" phNo ="+phNo);
		em.approveIBS(accNo,custId,emailId,phNo);
		
	}

}
*/