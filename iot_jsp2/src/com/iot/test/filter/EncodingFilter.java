package com.iot.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{
	private String ignorePattern;
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		String path = ((HttpServletRequest) req).getRequestURI(); 
				if(!path.matches(ignorePattern)) { 
				req.setCharacterEncoding("utf-8"); 
				res.setCharacterEncoding("utf-8"); 
				res.setContentType("text/html;charset=utf-8"); 
			} 
			fc.doFilter(req, res); 
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ignorePattern = filterConfig.getInitParameter("ignorePattern");
		
	}

	

	
}
