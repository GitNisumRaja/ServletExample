package com.insan.cookie.sample.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		Cookie cook = req.getCookies()[0];
		cook.setMaxAge(0);
		PrintWriter out= resp.getWriter();
		out.println("Logout Successfully");
		req.getRequestDispatcher("/index.html").include(req, resp);
		
	}
}
