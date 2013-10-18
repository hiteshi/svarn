package com.cdac.svarn.business.accountmgmt.thirdparty;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import com.cdac.svarn.entities.Account;
import com.cdac.svarn.entities.ThirdParty;




@Remote
public interface viewThirdPartyManager {
	
	public List<ThirdParty> getThirdParties(int account);
	
	public Account populate3p(int accountNo);
	
	public List<ThirdParty> setTpValz(int selfAcc);
	
}





//
//
//import com.cdac.svarn.entities.ThirdParty;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultList;
//import java.util.ArrayList;
//
//public class viewThirdParty {
//
//
//	PreparedStatement ptmt=null;
//	Connection con=null;
//	
//	ConnectionFactory cf = new ConnectionFactory();
//	public ArrayList<ThirdParty> getThirdParty(String account){
//		
//		try{
//			
//			ArrayList<ThirdParty> tps=new ArrayList<ThirdParty>();
//		con = cf.getConnection();
//		String sql="select * from THIRD_PARTY where SELF_ACCOUNT_NO="+account;
//		ptmt = con.prepareStatement(sql);
//		ResultList rs=ptmt.executeQuery();
//		
//		
//		while(rs.next()){
//			ThirdParty tp=new ThirdParty();
//			
//			tp.ListNameOfThirdParty(rs.getString("NAME_OF_THIRD_PARTY"));
//			tp.ListSelfAccountNo(rs.getString("SELF_ACCOUNT_NO"));
//			tp.ListThirdPartyAccountNo(rs.getString("THIRD_PARTY_ACCOUNT_NO"));
//			tp.ListTpNickName(rs.getString("TP_NICK_NAME"));
//			tp.ListTransferLimit(rs.getString("TRANSFER_LIMIT"));
//			
//			tps.add(tp);
//			
//		}
//		
//		con.close();
//		
//		
//		return tps;
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Error in connection inside bean: " + e);
//		}
//		
//		return null; 
//	}
//}
