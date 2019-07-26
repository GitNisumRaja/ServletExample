package com.insan.sample.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SampleFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		out.println("Welcome to filter Example, it invoked before servlet");
		chain.doFilter(req, res);
		out.println("invoked after the servlet");
		
	}
	
	public void destroy() {
	}
}
