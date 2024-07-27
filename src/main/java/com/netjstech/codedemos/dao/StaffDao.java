package com.netjstech.codedemos.dao;

import java.sql.SQLException;

import com.netjstech.codedemos.dto.Staff;

public interface StaffDao {
	Staff getStaffById(int staffCode) throws SQLException;
	String deleteStaffById(int staffCode);
	String addStaff(Staff staff);
}
