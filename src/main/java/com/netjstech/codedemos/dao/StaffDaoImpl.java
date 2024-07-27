package com.netjstech.codedemos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.netjstech.codedemos.dto.Staff;

public class StaffDaoImpl implements StaffDao{

	@Override
	public Staff getStaffById(int staffCode) throws SQLException {
		Staff staff = null;
		String sql = "SELECT * from staff_master where id = ?";
		try(Connection connection = DBUtil.getDBConnection()){
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, staffCode);
			ResultSet rset = pstmt.executeQuery();
			
			while(rset.next()) {
				staff = new Staff();
				staff.setStaffCd(rset.getInt("id"));
				staff.setStaffName(rset.getString("staff_name"));
				staff.setHireDate(rset.getDate("hire_date").toLocalDate());
				staff.setSalary(rset.getDouble("salary"));
				staff.setDepartmentCd(rset.getInt("department_code"));
				staff.setDesigCd(rset.getInt("designation_code"));
				staff.setDob(rset.getDate("staff_dob").toLocalDate());
				staff.setMgrCd(rset.getInt("mgr_code"));
			}
		}
		return staff;
	}

	@Override
	public String deleteStaffById(int staffCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addStaff(Staff staff) {
		// TODO Auto-generated method stub
		return null;
	}
}
