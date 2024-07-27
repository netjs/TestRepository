package com.netjstech.codedemos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netjstech.codedemos.dao.EmployeeDao;
import com.netjstech.codedemos.dao.EmployeeDaoImpl;
import com.netjstech.codedemos.dto.Employee;


public class EmployeeServiceImpl implements EmployeeService{
	//private static final Logger log = LogManager.getLogger(EmployeeServiceImpl.class);
	EmployeeDao empDao;
	public EmployeeServiceImpl(){
		empDao = new EmployeeDaoImpl();
	}
	@Override
	public Employee getEmployeeById(int empId) {
		//log.info("Entering getEmployeeById- " + empId);
		Employee emp = empDao.findEmployeeById(empId);
		//log.info("Exiting getEmployeeById");
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> empList = empDao.getEmployees();
		return empList;
	}

	@Override
	public List<Employee> getEmployeesByDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int empId) {
		Employee emp = empDao.findEmployeeById(empId);
		if(emp != null) {
			empDao.deleteEmployee(emp);
		}else {
			throw new IllegalArgumentException("Employee Id not found");
		}
	}
	@Override
	public String insertEmployee(Employee emp) {
		return empDao.insertEmployee(emp);
	}
	@Override
	public String insertEmployeePrepared(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.insertEmployeePrepared(emp);
	}
}
