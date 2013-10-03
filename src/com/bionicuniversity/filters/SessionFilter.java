package com.bionicuniversity.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
	/*
	 * Checking user session on all the website and if session is not exist
	 * anymore - redirecting to the login page
	 */

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// casting HttpServletRequest from ServletRequest so we can redirect
		// page afterwards
		HttpServletRequest req = (HttpServletRequest) request;

		// dont creating a session if it doesnt exist
		HttpSession session = req.getSession(false);

		// is session is exist - just proceed. otherwise redirecting to the
		// login page
		if (session != null && !session.isNew()) {
			chain.doFilter(request, response);
		} else {
			req.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void destroy() {
	}

}
