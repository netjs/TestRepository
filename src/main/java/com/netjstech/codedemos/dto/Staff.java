package com.netjstech.codedemos.dto;

import java.time.LocalDate;

public class Staff {
	private int staffCd;
	private String staffName;
	private int departmentCd;
	private int desigCd;
	private LocalDate hireDate;
	private LocalDate dob;
	private int mgrCd;
	private double salary;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getDepartmentCd() {
		return departmentCd;
	}
	public void setDepartmentCd(int departmentCd) {
		this.departmentCd = departmentCd;
	}
	public int getDesigCd() {
		return desigCd;
	}
	public void setDesigCd(int desigCd) {
		this.desigCd = desigCd;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getMgrCd() {
		return mgrCd;
	}
	public void setMgrCd(int mgrCd) {
		this.mgrCd = mgrCd;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getStaffCd() {
		return staffCd;
	}
	public void setStaffCd(int staffCd) {
		this.staffCd = staffCd;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Staff Code- " + getStaffCd() + " Name- " + getStaffName() +
				" Salary- " + getSalary() + " Hire Date- " + getHireDate() + 
				" Staff DOB- " + getDob();
		
	}
}
