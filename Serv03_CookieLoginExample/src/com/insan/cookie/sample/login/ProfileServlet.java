package com.insan.cookie.sample.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ProfileServlet")
public class ProfileServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		log("welcome to profileServlet");
		Cookie  []cookies = req.getCookies();
		if(cookies!= null) {
			log("inside if block"+ cookies[0].getValue());
			out.println("Hi "+cookies[0].getValue()+ "it is profile page");
			out.println("<a href='LogoutServlet'>Logout</a>");
			req.getRequestDispatcher("/login.html").include(req, resp);
			
		}else {
			out.println("Sorry..U are not authorized User..Please Login First!!!");
			req.getRequestDispatcher("/index.html").include(req, resp);
			
		}
	}
}
