package com.cdac.svarn.business.accountmgmt.biller;

import javax.ejb.Remote;


@Remote
public interface AddBillerManager {
	
	
	public boolean addBiller (String selfacc, String tpacc, String tpname, String nickname, String limit);
	
	
	public boolean delbiller(String selfacc, String tpacc, String tpname,String nickname, String limit);
	
		
	
}











































//package com.cdac.svarn.business.accountmgmt.biller;
//
//import in.cdac.svarn.connection.ConnectionFactory;
//import in.cdac.svarn.entities.Biller;
//import in.cdac.svarn.entities.Company;
//import in.cdac.svarn.entities.ThirdParty;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//public class AddBillerManager {
//
//
//	PreparedStatement ptmt=null;
//	Connection con=null;
//	
//	ConnectionFactory cf = new ConnectionFactory();
//	public boolean addBiller(Biller biller){
//		
//		try{
//		con = cf.getConnection();
//		
//		String sql = "";
//		ptmt = con.prepareStatement(sql);
//		ptmt.executeUpdate();
//		con.close();
//		
//		
//		return true;
//		}
//		catch (Exception e) {
//		
//			System.out.println("Error in connection inside bean: " + e);
//		}
//		
//		return false;
//	}
//	
//	
//	
//	
//	public ArrayList<Company> getBillers(){
//		try{
//		con = cf.getConnection();
//		ArrayList<Company> companies=new ArrayList<Company>();
//		String sql = "SELECT * FROM COMPANY";
//		ptmt = con.prepareStatement(sql);
//		ResultSet rs=  ptmt.executeQuery();
//		
//		while(rs.next()){
//			Company cmpny = new Company();
//			cmpny.setName(rs.getString("NAME"));
//			cmpny.setCompanyId(rs.getString("COMPANY_ID"));
//			cmpny.setContactPersonEmail(rs.getString("CONTACT_PERSON_EMAIL"));
//			cmpny.setContactPersonMobile(rs.getString("CONTACT_PERSON_MOBILE"));
//			cmpny.setContactPersonName(rs.getString("CONTACT_PERSON_NAME"));
//			
//			companies.add(cmpny);
//		}
//		
//		
//		con.close();
//		
//		
//		return companies;
//		}
//		catch (Exception e) {
//		
//			System.out.println("Error in connection inside bean: " + e);
//		}
//		
//		return null;
//	}
//	
//}
