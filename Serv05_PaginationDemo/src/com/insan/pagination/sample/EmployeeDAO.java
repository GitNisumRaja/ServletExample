package com.insan.pagination.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	private Connection con = null;
	
	private Connection getConnection()throws ClassNotFoundException,SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/practicedb", "root", "macroot1$");
		return con;
		
	}
	
	//start:- starting index
	//total:- total no of record from start position
	public List<Employee> getEmployee(int start,int total) throws SQLException,ClassNotFoundException{
		List<Employee> empList = new ArrayList<>();
		con = getConnection();
		
		if(con!= null) {
			PreparedStatement ps = con.prepareStatement("select * from Employee limit "+start+ ","+ total);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpEmail(rs.getString("empEmail"));
				empList.add(emp);
				
			}
			return empList;
		}
		return empList;
	}

}
