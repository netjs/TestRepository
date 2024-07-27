package com.netjstech.codedemos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netjstech.codedemos.dto.Employee;


public class EmployeeDaoImpl implements EmployeeDao {
	//private static final Logger log = LogManager.getLogger(EmployeeDaoImpl.class);
	List<Employee> empList = new ArrayList<Employee>();
//	@Override
//	public Employee findEmployeeById(int empId) {
//		log.info("Entering findEmployeeById- " + empId);
//		Connection conn;
//		try {
//			conn = DBUtil.getDBConnection();
//			PreparedStatement pstmt = conn.prepareStatement("select empno, ename, hiredate, sal, dept_name"
//					+ " from emp e, department_master d where empno = ? and e.deptno = d.dept_code");
//			pstmt.setInt(1, empId);
//			ResultSet rs = pstmt.executeQuery();
//			Employee employee = new Employee();
//			while (rs.next()) {
//				employee.setEmpNo(rs.getInt("empno"));
//				employee.setEmpName(rs.getString("ename"));
//				employee.setHireDate(rs.getDate("hireDate").toLocalDate());
//				employee.setSalary(rs.getDouble("sal"));
//				employee.setDeptName(rs.getString("dept_name"));
//			}
//			log.info("Exiting findEmployeeById");
//			return employee;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			log.error("Error in findEmployeeById" + e.getMessage());
//		}
//		
//		return null;
//	}

//	@Override
//	public List<Employee> getEmployees() {
//		Connection conn;
//		List<Employee> empList = new ArrayList<Employee>();
//		try {
//			
//			conn = DBUtil.getDBConnection();
//			Statement stmt = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
//			ResultSet rs = stmt.executeQuery ("select empno, ename, hiredate, sal from emp");
//			while (rs.next()) {
//				Employee employee = new Employee();
//				employee.setEmpNo(rs.getInt("empno"));
//				employee.setEmpName(rs.getString("ename"));
//				employee.setHireDate(rs.getDate("hireDate").toLocalDate());
//				employee.setSalary(rs.getDouble("sal"));
//				empList.add(employee);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return empList;
//	}
//	public Employee findEmployeeById(int empId) {
//		log.info("Entering findEmployeeById");
//		for(Employee emp : empList) {
//			if(emp.getEmpNo() == empId) {
//				log.debug("EmployeeId found" + empId) ;
//				return emp;
//			}
//		}
//		log.info("Exiting findEmployeeById");
//		return null;
//	}
	
	public Employee findEmployeeById(int empId) {
		String sql = "SELECT * FROM employee_jdbc where id = ?";
		Connection conn = null;
		Employee employee = null;
		try {
			conn = DBUtil.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpNo(rs.getInt("id"));
				employee.setEmpName(rs.getString("name"));
				employee.setHireDate(rs.getDate("hire_date").toLocalDate());
				employee.setSalary(rs.getDouble("salary"));
				employee.setJob(rs.getString("job"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employee;
	}
	
	@Override
	public List<Employee> findEmployeesByDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee emp) {
		empList.remove(emp);

	}
	
	@Override
	public List<Employee> getEmployees() {
		
		
		Employee employee = new Employee();
		employee.setEmpNo(1);
		employee.setEmpName("Hemant");
		employee.setHireDate(LocalDate.of(2018, 11, 22));
		employee.setSalary(8000);
		employee.setJob("Developer");
		empList.add(employee);
		employee = new Employee();
		employee.setEmpNo(2);
		employee.setEmpName("Varsha");
		employee.setJob("Manager");
		employee.setHireDate(LocalDate.of(2016, 07, 02));
		employee.setSalary(10000);
		empList.add(employee);
		return empList;
	}
	@Override
	public String insertEmployee(Employee emp) {
		System.out.println("In insertEmployee");
		String sql = "INSERT INTO employee_jdbc(name, job, hire_date, salary, dept_name)" +
				" values('"+emp.getEmpName()+ "', '" + emp.getJob() + "', '" + emp.getHireDate()+
				"', "+emp.getSalary()+ ", '" + emp.getDeptName() +"')";
		System.out.println("SQL- " + sql);
		Connection conn = null;
		try {
			conn = DBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			if(count != 1) {
				throw new SQLException("Error while inserting");
			}
			return "Record Successfully inserted";
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Record not inserted";
	}
	
	public String insertEmployeePrepared(Employee emp) {
		System.out.println("In insertEmployee");
		String sql = "INSERT INTO employee_jdbc(name, job, hire_date, salary, dept_name)" +
				" values(?,?,?,?,?)";
		//System.out.println("SQL- " + sql);
		Connection conn = null;
		try {
			conn = DBUtil.getDBConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getEmpName());
			stmt.setString(2, emp.getJob());
			stmt.setDate(3, Date.valueOf(emp.getHireDate()));
			stmt.setDouble(4, emp.getSalary());
			stmt.setString(5, emp.getDeptName());
			System.out.println("SQL- " + sql);
			int count = stmt.executeUpdate();
			if(count != 1) {
				throw new SQLException("Error while inserting");
			}
			return "Record Successfully inserted";
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			

			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Record not inserted";
	}

}
