package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PreparedStmtOracleDemo {
	public static void main(String[] args) {
		 insertStaffData("Likita", 4, 24, LocalDate.of(2017, 6, 16),
		 LocalDate.of(1985, 8, 18), 60000, 9);
		//updateStaffData(5, 62000, 9);
		
		deleteStaffData(5);
	}

	private static void insertStaffData(String staffName, int designationCd, int departmentCd, LocalDate hireDate,
			LocalDate staffDOB, double salary, int mgrCd) {
		Connection conn = null;
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
                    "netjs", "netjs");

			String sql = "insert into staff_master (staff_name, designation_code, "
					+ "department_code, hire_date, staff_dob, mgr_code, salary) values(?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, staffName);
			pstmt.setInt(2, designationCd);
			pstmt.setInt(3, departmentCd);
			pstmt.setDate(4, Date.valueOf(hireDate));
			pstmt.setDate(5, Date.valueOf(staffDOB));
			pstmt.setInt(6, mgrCd);
			pstmt.setDouble(7, salary);

			int count = pstmt.executeUpdate();

			System.out.println("Record is inserted successfully !! " +count);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// Update
	private static void updateStaffData(int staffCd, double salary, int mgrCd) {
		Connection conn = null;
		try {

			// DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
                    "netjs", "netjs");

			String sql = "UPDATE staff_master set salary=?, mgr_code=? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, salary);
			pstmt.setInt(2, mgrCd);
			pstmt.setInt(3, staffCd);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Record updated successfully !!");
			} else {
				throw new SQLException("Problem in updating");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// DELETE
	private static void deleteStaffData(int staffCd) {
		Connection conn = null;
		try {

			// DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
                    "netjs", "netjs");

			String sql = "DELETE FROM staff_master WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, staffCd);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Record deleted successfully !!");
			} else {
				throw new SQLException("Problem in deleting");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
