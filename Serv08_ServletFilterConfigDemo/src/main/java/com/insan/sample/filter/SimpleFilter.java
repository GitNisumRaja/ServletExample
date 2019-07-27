package com.insan.sample.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns="/serv", initParams= @WebInitParam(name="construction",value="yes"))
public class SimpleFilter implements Filter {

	FilterConfig config = null;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String str = config.getInitParameter("construction");
		
		if(str.equals("no")) {
			out.println("Site is in Construction");
		}else {
			chain.doFilter(request, response);
		}
		
	}
	
	public void destroy() {
	
	}

	

}
