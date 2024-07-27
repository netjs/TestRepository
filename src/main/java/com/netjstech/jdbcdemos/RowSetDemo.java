package com.netjstech.jdbcdemos;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

	private static Object rowSet;

	public static void main(String[] args) throws ClassNotFoundException {
		JdbcRowSet rowSet = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			// Creating and Executing RowSet
			rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rowSet.setUsername("netjs");
			rowSet.setPassword("netjs");
	
			rowSet.setCommand("SELECT * FROM staff_master");
			rowSet.execute();
		   while (rowSet.next()) {  
			   System.out.println("id: " + rowSet.getInt("id") + " Name: " + rowSet.getString("staff_name")
				+ " Hire Date: " + rowSet.getDate("hire_date") + " Salary: " + rowSet.getDouble("salary")
				+ " Date of Birth: " + rowSet.getDate("staff_dob"));
           }  
            
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
	        if(rowSet != null){
	          //closing connection 
	          try {
	        	  rowSet.close();
	          } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	        } // if condition
		}// finally
	}

}
