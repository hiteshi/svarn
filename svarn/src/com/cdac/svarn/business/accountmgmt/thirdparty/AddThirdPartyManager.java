package com.cdac.svarn.business.accountmgmt.thirdparty;

import javax.ejb.Remote;


@Remote
public interface AddThirdPartyManager {
	
	
	public boolean add3p (String selfacc, String tpacc, String tpname, String nickname, String limit);
	
		public boolean del3p(String selfacc, String tpacc, String tpname,String nickname, String limit);
	
	
	
}



























//
//import in.cdac.svarn.connection.ConnectionFactory;
//import in.cdac.svarn.entities.ThirdParty;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//public class AddThirdParty {
//
//
//	PreparedStatement ptmt=null;
//	Connection con=null;
//	
//	ConnectionFactory cf = new ConnectionFactory();
//	public boolean addThirdParty(ThirdParty tp){
//		
//		System.out.println("inside addThirdParty AccountNo : " + tp.getSelfAccountNo());
//		try{
//		con = cf.getConnection();
//		System.out.println("name of third party : " + tp.getNameOfThirdParty());
//		
//		String sql = "INSERT INTO THIRD_PARTY(SELF_ACCOUNT_NO, NAME_OF_THIRD_PARTY, THIRD_PARTY_ACCOUNT_NO, TRANSFER_LIMIT, TP_NICK_NAME) VALUES("+ tp.getSelfAccountNo() +",'"+tp.getNameOfThirdParty()+"',"+tp.getThirdPartyAccountNo()+","+tp.getTransferLimit()+",'"+tp.getTpNickName()+"')";
//		
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
//}
