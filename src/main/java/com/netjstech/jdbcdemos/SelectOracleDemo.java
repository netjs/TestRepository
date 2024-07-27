package com.netjstech.jdbcdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.netjstech.codedemos.dto.Staff;

public class SelectOracleDemo {
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
		String selectQuery = "SELECT id,"
				+ "   staff_name,"
				+ "   designation_code,"
				+ "   department_code,"
				+ "   hire_date,"
				+ "   staff_dob,"
				+ "   mgr_code,"
				+ "   salary"
				+ " FROM staff_master";
		try	{
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
                    "netjs", "netjs");
			
			Statement stmt = conn.createStatement();
			// Query the staff details 
			ResultSet rset = stmt.executeQuery(selectQuery);
			//int i = 0;
			while(rset.next()) {
				Staff staff = new Staff();
				staff.setStaffCd(rset.getInt("id"));
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
