package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSet {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Load or register a driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// Another way
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// Creating connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "netjs", "netjs");

			// Create statement
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String selectQuery = "SELECT * FROM staff_master";
			// Query the staff details
			ResultSet rset = stmt.executeQuery(selectQuery);
			// Processing Resultset
			while (rset.next()) {
				System.out.println("id: " + rset.getInt("id") + " Name: " + rset.getString("staff_name")
						+ " Hire Date: " + rset.getDate("hire_date") + " Salary: " + rset.getDouble("salary")
						+ " Date of Birth: " + rset.getDate("staff_dob"));
			}
			// moving to 3rd row
			rset.absolute(3);
			System.out.println("Displaying 3rd row");
			System.out.println("id: " + rset.getInt("id") + " Name: " + rset.getString("staff_name") + " Hire Date: "
					+ rset.getDate("hire_date") + " Salary: " + rset.getDouble("salary") + " Date of Birth: "
					+ rset.getDate("staff_dob"));

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				// closing connection
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // if condition
		} // finally

	}

}
