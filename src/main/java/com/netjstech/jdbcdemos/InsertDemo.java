package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		try	{
			
			// Load or register a driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Connection
			Connection conn = DriverManager.getConnection (
			"jdbc:mysql://localhost:3306/netjs", "root", "admin");
	
			// Create statement
			Statement stmt = conn.createStatement(); 
			
			int count = stmt.executeUpdate("INSERT into staff_master "
					+ "(staff_name, designation_code, department_code, hire_date,"
					+ " staff_dob, mgr_code, salary)"
					+ " values('Venkat', 4, 1, '2018-07-15', '1990-11-05', 4, 58000.00)");
			if(count == 1) {
				System.out.println("Record is inserted successfully !!" + count);
			}else {
				System.out.println("Record is not inserted successfully !!");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
