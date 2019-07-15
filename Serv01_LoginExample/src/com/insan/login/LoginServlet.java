package com.insan.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/LoginServlet", loadOnStartup=1,
			initParams= {@WebInitParam(name="user", value="Afroz"),
						@WebInitParam(name="password", value="afroz123@")})
public class LoginServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
	 if(getServletContext().getInitParameter("dbUrl").equals("jdbc:mysql://localhost:3306/practicedb") && 
	 	getServletContext().getInitParameter("dbUser").equals("root") &&
		getServletContext().getInitParameter("dbPwd").equals("rootmac1@")) {
		 
		 getServletContext().setAttribute("DB_Success", "True");
	 }else {
		  throw new ServletException("DB Connection error");
	 }

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pwd");
		
		String userID = getServletConfig().getInitParameter("user");
		String pwd = getServletConfig().getInitParameter("password");
		
		log("Input from browser::user:: "+user+"  password:: "+pass);
		
		if(user.equals(userID) && pass.equals(pwd)) {
			resp.sendRedirect("LoginSuccess.jsp");
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = resp.getWriter();
			out.println("<font color:'red'>Either username or password is wrong </font>");
			rd.include(req, resp);
		}
	}

}
