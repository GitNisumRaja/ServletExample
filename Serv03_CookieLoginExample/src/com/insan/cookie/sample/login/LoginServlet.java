package com.insan.cookie.sample.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String fname = req.getParameter("fname");
		String pwd = req.getParameter("pwd");
		
		
		
		
		if(fname.equals("afroz") && pwd.equals("insan")) {
			out.println("You Successfully login. \n <br/> Welcome::"+fname);
			
			Cookie fncookie = new Cookie("fname",fname);
			resp.addCookie(fncookie);
			req.getRequestDispatcher("/profile.jsp").include(req, resp);
			
				
			
		}else {
			out.print("fname or pwd might be wrong. \n Please login again");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
	}
}
