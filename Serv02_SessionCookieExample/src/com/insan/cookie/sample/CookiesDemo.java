package com.insan.cookie.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/cookiesdemo")
public class CookiesDemo extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie fcookie = new Cookie("fname",req.getParameter("fname"));
		Cookie lcookie = new Cookie("lname",req.getParameter("lname"));
		
		resp.addCookie(fcookie);
		resp.addCookie(lcookie); 
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
		PrintWriter out = resp.getWriter();
		out.println("fname::"+req.getParameter("fname")+" lname::"+req.getParameter("lname"));
		
		rd.forward(req, resp);
		
		
	}

}
