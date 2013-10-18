package com.cdac.svarn.business.transactionmgmt;

import java.util.List;
import javax.ejb.Remote;
import com.cdac.svarn.entities.Transaction;



@Remote
public interface TransactionManagerRemote {
	
	
	public boolean fundsLogic (String accFrom,String accTo, String amountXfer,String remarks);
	
	public boolean partyLogic (String accFrom,String accTo, String amountXfer,String remarks);
	
	public boolean onlineDD(String ddaccount, String ddamount1,String inFavourOf, String payableAt, String remarksdd);
	
	public List<Transaction> viewStatement(String startDate,String endDate,String account);
	
	public boolean approveRegistration(int regId, double amount);
	
	public boolean approveLoanRegistration(int regId);
	
	public boolean approveCompanyRegistration(int regId, double amount);
	
	public boolean approveClosingRegistration(int regId);
	
	public boolean CalculateInterest();
	
}








//
//import in.cdac.svarn.connection.ConnectionFactory;
//import in.cdac.svarn.entities.Transaction;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Savepoint;
//import java.util.ArrayList;
//
//
//import javax.naming.NamingException;
//
//public class TransactionManager {
//	
//	PreparedStatement ptmt=null;
//	PreparedStatement ptmt1=null;
//	PreparedStatement ptmt2=null;
//	PreparedStatement ptmt3=null;
//	PreparedStatement ptmt4=null;
//	Connection con=null;
//	Savepoint save1=null;
//	Savepoint save2=null;
//	
//	ConnectionFactory cf;
//	
//	
//	public boolean performTransaction(String accFrom,String accTo, String amountXfer,String remarks) {
//		
//		cf = new ConnectionFactory();
//		try {
//			con = cf.getConnection();
//			con.setAutoCommit(false);
//			
//			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//			
//			
//			
//			
//			
//			
//			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NO =" + accFrom + " AND CURRENT_BALANCE >= " + amountXfer + ";" ;
//			
//			System.out.println("select sql : "+ sql);
//			
//			ptmt = con.prepareStatement(sql);
//			ResultSet rs=ptmt.executeQuery();
//			
//			
//			
//			if (!rs.next()){
//				
//					
//				con.close();
//				return false;
//			}
//			else {
//				
//
//				String sql1 = "UPDATE ACCOUNT SET CURRENT_BALANCE = CURRENT_BALANCE - " + amountXfer + " WHERE ACCOUNT_NO = "+ accFrom + ";" ;
//				System.out.println("update from sql : "+ sql1);
//				ptmt1 = con.prepareStatement(sql1);
//				
//				
//				String sql2 = "INSERT INTO TRANSACTION(ACCOUNT_NO, TRANSACTION_AMOUNT, TRANSACTION_REFERENCE, TRANSACTION_TYPE, REMARKS, CREDIT_DEBIT) VALUES(" + accFrom + ", " + amountXfer+ ", " + accTo +", 'ACCOUNT' , '" + remarks + "', 'DEBIT');";
//				System.out.println("insert Transaction from sql : "+ sql2);
//				ptmt2 = con.prepareStatement(sql2);
//				
//				
//				String sql3 = "UPDATE ACCOUNT SET CURRENT_BALANCE = CURRENT_BALANCE + " + amountXfer + " WHERE ACCOUNT_NO = "+ accTo + ";" ;
//				System.out.println("update to sql : "+ sql3);
//				ptmt3 = con.prepareStatement(sql3);
//				
//				
//				String sql4 = "INSERT INTO TRANSACTION(ACCOUNT_NO,TRANSACTION_AMOUNT, TRANSACTION_REFERENCE, TRANSACTION_TYPE, CREDIT_DEBIT) VALUES(" + accTo + ", " + amountXfer + ", " + accFrom + ", 'ACCOUNT', 'CREDIT');";
//				System.out.println("insert Transaction to sql : "+ sql4);
//				ptmt4 = con.prepareStatement(sql4);
//
//				
//				
//				save1 = con.setSavepoint();
//				
//				ptmt1.execute();
//				ptmt2.execute();
//				ptmt3.execute();
//				ptmt4.execute();
//				
//				
//				con.commit();
//				con.setAutoCommit(true);
//				
//				System.out.println("HELLO JI..........");
//				
//				
//				return true;
//				
//			}
//				
//			
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//			return false;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			try {
//				con.rollback(save1);
//				con.commit();
//								System.out.println("piche jaat hai................");
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				System.out.println("unable to roll back................");
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			System.out.println("phals return karat hai................");
//			return false;
//		}
//		finally {
//			
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("unable to close the connection");
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//	}
//
//
//	public boolean onlineDD(String ddaccount, String ddamount1,
//			String inFavourOf, String payableAt, String remarksdd) {
//		// TODO Auto-generated method stub
//				
//		cf = new ConnectionFactory();
//		try {
//			con = cf.getConnection();
//			con.setAutoCommit(false);
//			
//			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//			
//			
//			int amt = Integer.parseInt(ddamount1);
//			amt += 1000;
//			String ddamount = ""+amt;
//			
//			
//			
//			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NO = "+ ddaccount +" AND CURRENT_BALANCE > " + ddamount+";";
//			System.out.println("select sql : "+ sql);
//			
//			ptmt = con.prepareStatement(sql);
//			ResultSet rs=ptmt.executeQuery();
//			System.out.println("rs check ke pahle : ");
//			if (!rs.next()){
//				
//					System.out.println("rs true nai hua");
//				con.close();
//				return false;
//			}
//			else {
//				System.out.println("rs true hua hai");
//				save2 = con.setSavepoint();
//				
//				String sql1 = "INSERT INTO DEMAND_DRAFT(FAVOUR_OF, PAYABLE_AT, ISSUE_DATE, ACCOUNT_NO, AMOUNT) VALUES('"+ inFavourOf +"', '"+ payableAt +"', NOW(), "+ ddaccount +","+ ddamount1 +");";
//				System.out.println("update from sql : "+ sql1);
//				ptmt1 = con.prepareStatement(sql1);
//				ptmt1.execute();
//				
//				System.out.println("sql1 succ");
//				
//				
//				String sql2 = "SELECT * FROM DEMAND_DRAFT WHERE ACCOUNT_NO = "+ ddaccount +" ORDER BY ISSUE_DATE DESC;";
//				System.out.println("insert Transaction from sql : "+ sql2);
//				ptmt2 = con.prepareStatement(sql2);
//				ResultSet rs2 = ptmt2.executeQuery();
//				rs2.next();
//				String ddNumber = rs2.getString("DD_NUMBER");
//				
//				System.out.println("rs true hua hai");
//				
//				if (ddNumber!=null){
//				
//				String sql3 = "UPDATE ACCOUNT SET CURRENT_BALANCE = CURRENT_BALANCE - " + ddamount1 + " WHERE ACCOUNT_NO = "+ ddaccount + ";" ;
//				System.out.println("update to sql : "+ sql3);
//				ptmt3 = con.prepareStatement(sql3);
//				ptmt3.execute();
//				
//				String sql4 = "INSERT INTO TRANSACTION(ACCOUNT_NO, TRANSACTION_AMOUNT, TRANSACTION_REFERENCE, TRANSACTION_TYPE, REMARKS, CREDIT_DEBIT) VALUES(" + ddaccount + ", " + ddamount1 + ", " + ddNumber +", 'DEMAND DRAFT' , '" + remarksdd + "', 'DEBIT');";
//				System.out.println("insert Transaction to sql : "+ sql4);
//				ptmt4 = con.prepareStatement(sql4);
//				ptmt4.execute();
//				
//				}else
//					throw new SQLException();
//				
//				
//				
//				
//				
//				
//				
//				
//				con.commit();
//				con.setAutoCommit(true);
//				
//				System.out.println("HELLO JI..........");
//				
//				
//				return true;
//				
//			}
//				
//			
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//			return false;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			try {
//				con.rollback(save2);
//				con.commit();
//								System.out.println("piche jaat hai................");
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				System.out.println("unable to roll back................");
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//			System.out.println("phals return karat hai................");
//			return false;
//		}
//		finally {
//			
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("unable to close the connection");
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//		
//		
//		
//	}
//	
//	public ArrayList<Transaction> viewStatement(String startDate,String endDate,String account){
//		
//		cf = new ConnectionFactory();
//		try {
//			con = cf.getConnection();
//			ArrayList<Transaction> trans = new ArrayList<Transaction>();
//			
//			
//			String sql = "SELECT * FROM TRANSACTION WHERE TRANSACTION_DATE BETWEEN '"+ startDate +" 00:00:00' AND '"+ endDate +" 00:00:00' AND ACCOUNT_NO = "+ account +";";
//			System.out.println("select sql : "+ sql);
//			
//			ptmt = con.prepareStatement(sql);
//			ResultSet rs=ptmt.executeQuery();
//			System.out.println("rs check ke pahle : ");
//			
//			while (rs.next()){
//				
//				Transaction transobj = new Transaction();
//				transobj.setTransactionAmount(rs.getString("TRANSACTION_AMOUNT"));
//				transobj.setTransactionType(rs.getString("TRANSACTION_TYPE"));
//				transobj.setTransactionDate(rs.getString("TRANSACTION_DATE"));
//				transobj.setRemarks(rs.getString("REMARKS"));
//				transobj.setCreditDebit(rs.getString("CREDIT_DEBIT"));
//				trans.add(transobj);
//			}
//			
//			return trans;
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//			System.out.println("phals return karat hai................");
//			
//		}
//		finally {
//			
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("unable to close the connection");
//				e.printStackTrace();
//			}
//		}
//		
//		return null;
//		
//		
//		
//	}
//	
//	
//	
//
//}
