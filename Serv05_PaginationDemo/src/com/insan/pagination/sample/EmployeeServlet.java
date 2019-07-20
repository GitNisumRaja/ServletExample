package com.insan.pagination.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	
	EmployeeDAO empDao = new EmployeeDAO();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String start = req.getParameter("page");
		int total = 5;
		int intpageId = Integer.parseInt(start);
		
		if(intpageId ==1) {
			
		}else {
			intpageId = intpageId -1;
			intpageId = intpageId*total +1;
		}
		try {
		List<Employee> empList = empDao.getEmployee(intpageId, total);
		out.println("Emplooyee Details");
		out.print("<table><td><th>EmpId</th><th>EmpName</th><th>EmpEmail</th></td>");
		for(Employee emp:empList) {
			
			out.print("<tr><td>"+emp.getEmpId()+"</td><td>"+emp.getEmpName()+"</td><td>"+emp.getEmpEmail()+"</td></tr>");
		}
		out.print("</table>");
		}catch(Exception exp) {
			out.println("Got exception::"+exp.getMessage());
		}
		
		out.println("<a href='empServlet?page=1'>1</a>");
		out.println("<a href='empServlet?page=2'>2</a>");
		out.println("<a href='empServlet?page=3'>3</a>");
		
		out.close();
	
	}

}
