package com.insan.cookie.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/secondServlet")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie []preCookie = req.getCookies();
		log(preCookie+"");
		PrintWriter out = resp.getWriter();
		out.print(preCookie.toString());
		for(int i =0; i<preCookie.length;i++) {
			out.println(preCookie[i].getName()+" "+preCookie[i].getValue());
		}
	}
}
