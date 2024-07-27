package com.netjstech.codedemos.dao;

import java.util.List;
import com.netjstech.codedemos.dto.Employee;

public interface EmployeeDao {
	public Employee findEmployeeById(int empId);
	public List<Employee> getEmployees();
	public List<Employee> findEmployeesByDept();
	public void deleteEmployee(Employee emp);
	public String insertEmployee(Employee emp);
	public String insertEmployeePrepared(Employee emp);
}
