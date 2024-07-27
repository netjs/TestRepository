package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCResultSetUpdate {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Load or register a driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			// Creating connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "netjs", "netjs");

			// Create statement
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String selectQuery = "SELECT * FROM department_master";
			// Query the staff details
			ResultSet rset = stmt.executeQuery(selectQuery);
			// Processing Resultset
			while (rset.next()) {
				System.out.println("id: " + rset.getInt("dept_cd") + " Name: " + rset.getString("dept_name"));
			} 
			rset.moveToInsertRow(); 
		     
			// rs.updateInt("id",18); //updates the first column using column name
			rset.updateString(2, "Transport"); // updates the second column using column index
			
			rset.insertRow();
			rset.moveToCurrentRow();
		
		}catch (SQLException e) {
				System.out.println(e.getMessage() + e.getErrorCode());
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
