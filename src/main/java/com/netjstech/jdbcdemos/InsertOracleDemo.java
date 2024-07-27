package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOracleDemo {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Load or register a driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// Another way
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			// Creating connection
	    	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
		                          "netjs", "netjs");

			// Create statement
			Statement stmt = connection.createStatement();
			
			String insertQuery = "Insert into staff_master (staff_name, designation_code, "
					+ "department_code, hire_date, staff_dob, mgr_code, salary) "
					+ "values ('Ram', 21, 21, '15-12-2015', '19-11-1980', 28, 80000.75)";

			int count = stmt.executeUpdate(insertQuery);
			if (count == 1) {
				System.out.println("Record is inserted successfully !!" + count);
			} else {
				System.out.println("Record is not inserted successfully !!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
	        if(connection != null){
	          //closing connection 
	          try {
	            connection.close();
	          } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	        } // if condition
		}// finally

	}

}
