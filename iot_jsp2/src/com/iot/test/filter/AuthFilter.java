package com.iot.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuthFilter implements Filter {
	private String ignorePattern;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getRequestURI();
		if (path.matches(ignorePattern) || path.indexOf("login") != -1) {
			fc.doFilter(req, res);
			return;
		}
		if (request.getSession().getAttribute("user") != null) {
			fc.doFilter(req, res);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/user/login");
		rd.forward(request, res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ignorePattern = filterConfig.getInitParameter("ignorePattern");

	}

}
