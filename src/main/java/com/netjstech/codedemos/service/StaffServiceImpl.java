package com.netjstech.codedemos.service;

import java.sql.SQLException;

import com.netjstech.codedemos.dao.StaffDao;
import com.netjstech.codedemos.dao.StaffDaoImpl;
import com.netjstech.codedemos.dto.Staff;

public class StaffServiceImpl implements StaffService {
	StaffDao staffDao;
	public StaffServiceImpl(){
		staffDao = new StaffDaoImpl();
	}
	@Override
	public Staff getStaffById(int staffCode) {
		try {
			return staffDao.getStaffById(staffCode);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
