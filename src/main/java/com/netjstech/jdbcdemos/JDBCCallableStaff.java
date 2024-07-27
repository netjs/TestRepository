package com.netjstech.jdbcdemos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;

public class JDBCCallableStaff {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Creating connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "netjs", "netjs");
			// Getting CallableStatement object
			CallableStatement cStatement = connection.prepareCall("{call select_staff_proc(?, ?, ?)}");
			// Setting params
			cStatement.setInt(1, 26);
			// Registering OUT parameters Using
			// JDBCType enum which is added in Java 8
			cStatement.registerOutParameter(2, JDBCType.VARCHAR);

			cStatement.registerOutParameter(3, JDBCType.DATE);

			cStatement.executeQuery();

			// Reading the OUT paramter here
			System.out.println("Fetched Result " + "Name: " + cStatement.getString(2) + " Hire Date: "
					+ cStatement.getDate(3));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
