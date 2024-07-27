package com.netjstech.jdbcdemos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionOracleDemo {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			//DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
                    "netjs", "netjs");
			
		     // Auto commit disabled
		      connection.setAutoCommit(false);
		      
		      int fromAccount = 1;
		      int toAccount = 4;
		      int amount = 1000;
		      withdrawAmount(connection, fromAccount, amount);
		      depositAmount(connection, toAccount, amount);
		      System.out.println("Transfer done...");
		      // Commit transaction
		      connection.commit();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			if(connection != null){
		        try {
		          // Rolling back transaction
		          connection.rollback();
		          System.out.println("Rolling back the transaction");
		        } catch (SQLException e1) {
		          // TODO Auto-generated catch block
		          e1.printStackTrace();
		        }
			}
			e.printStackTrace();
		}	

	}
	private static void withdrawAmount(Connection connection, int accountNum, int amount) throws SQLException{
	    System.out.println("In withdraw");
		String sql = "UPDATE bankaccount SET balance = balance - ? WHERE account_num = ?";
	    PreparedStatement stmt = null;
	    try {
	      stmt = connection.prepareStatement(sql);
	      stmt.setInt(1, amount);
	      stmt.setInt(2, accountNum);
	      int count = stmt.executeUpdate();
	      if(count == 0){
	        throw new SQLException("Account number not found " + accountNum);
	      }
	    }finally{
	      if(stmt != null){
	        stmt.close();
	      }
	    }
	}	 
		  
	private static void depositAmount(Connection connection, int accountNum, int amount) throws SQLException{
		System.out.println("In Deposit");
		String sql = "UPDATE bankaccount SET balance = balance + ? WHERE account_num = ?";
	    PreparedStatement stmt = null;
	    try {
	      stmt = connection.prepareStatement(sql);
	      stmt.setInt(1, amount);
	      stmt.setInt(2, accountNum);
	      int count = stmt.executeUpdate();
	      if(count == 0){
	        throw new SQLException("Account number not found " + accountNum);
	      }
	    }finally{
	      if(stmt != null){
	        stmt.close();
	      }
	    }    
	}
}
