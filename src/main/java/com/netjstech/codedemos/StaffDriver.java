package com.netjstech.codedemos;

import com.netjstech.codedemos.dto.Staff;
import com.netjstech.codedemos.service.StaffService;
import com.netjstech.codedemos.service.StaffServiceImpl;

public class StaffDriver {
	public static void main(String[] args) {
		try {
			int staff_cd = 23;
			StaffService staffService = new StaffServiceImpl();
			Staff staff = staffService.getStaffById(staff_cd);
			if(staff != null) {
				System.out.println(staff);
			}
			else {
				System.out.println("No staff information for " + staff_cd);
			}
				
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
