package com.netjstech.codedemos;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netjstech.codedemos.dto.Employee;
import com.netjstech.codedemos.service.EmployeeService;
import com.netjstech.codedemos.service.EmployeeServiceImpl;



public class EmployeeDriver {
	//private static final Logger log = LogManager.getLogger(EmployeeDriver.class);
	public static void main(String[] args) {
		//log.info("Starting service call to get employee by ID");
		EmployeeService employeeService = new EmployeeServiceImpl();

//		log.debug("Employee information- " + emp);
		// Get Employees
//		List<Employee> empList = employeeService.getEmployees();
//		for(Employee employee : empList) {
//			System.out.println(employee);
//		}
//		
		// Get Employee by Id
//		Employee emp = employeeService.getEmployeeById(1);
//		System.out.println(emp);
//		
//		// Delete Employee by Id
//		employeeService.deleteEmployee(1);
//		System.out.println("-----Employee in the List----");
//		for(Employee employee : empList) {
//			System.out.println(employee);
//		}
		Employee emp = new Employee();
		emp.setEmpName("Harshita");
		emp.setDeptName("HR");
		emp.setHireDate(LocalDate.of(2021, Month.SEPTEMBER, 14));
		emp.setJob("Manager");
		emp.setSalary(52789.67);
		String msg = employeeService.insertEmployeePrepared(emp);
		System.out.println(msg);
	}

}
