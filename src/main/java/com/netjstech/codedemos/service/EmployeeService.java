package com.netjstech.codedemos.service;

import java.util.List;

import com.netjstech.codedemos.dto.Employee;


public interface EmployeeService {
	public Employee getEmployeeById(int empId);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByDept();
	public void deleteEmployee(int empId);
	public String insertEmployee(Employee emp);
	public String insertEmployeePrepared(Employee emp);
}
