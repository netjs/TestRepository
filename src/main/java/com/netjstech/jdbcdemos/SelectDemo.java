package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.netjstech.codedemos.dto.Staff;

public class SelectDemo {

	public static void main(String[] args) {
		List<Staff> staffList = getStaff();
		System.out.println("Staff List");
		for(Staff staff : staffList) {
			System.out.println(staff);
		}

	}
	
	private static List<Staff> getStaff() {
		Connection conn = null;
		List<Staff> staffList = new ArrayList<Staff>();
		String selectQuery = "SELECT staff_code,\r\n"
				+ "   staff_name,\r\n"
				+ "   designation_code,\r\n"
				+ "   department_code,\r\n"
				+ "   hire_date,\r\n"
				+ "   staff_dob,\r\n"
				+ "   mgr_code,\r\n"
				+ "   salary\r\n"
				+ "FROM staff_master";
		try	{
			
			conn = DriverManager.getConnection (
					"jdbc:mysql://localhost:3306/netjs", "root", "admin");
			Statement stmt = conn.createStatement();
			// Query the staff details 
			ResultSet rset = stmt.executeQuery(selectQuery);
			//int i = 0;
			while(rset.next()) {
				Staff staff = new Staff();
				staff.setStaffCd(rset.getInt("staff_code"));
				staff.setStaffName(rset.getString("staff_name"));
				staff.setHireDate(rset.getDate("hire_date").toLocalDate());
				staff.setSalary(rset.getDouble("salary"));
				staff.setDepartmentCd(rset.getInt("department_code"));
				staff.setDesigCd(rset.getInt("designation_code"));
				staff.setDob(rset.getDate("staff_dob").toLocalDate());
				staff.setMgrCd(rset.getInt("mgr_code"));
				staffList.add(staff);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return staffList;
	}

}
