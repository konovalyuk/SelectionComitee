<<<<<<< HEAD
package com.bionicuniversity.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {
	/*
	 * Checking page encoding on all the website and if its not an UTF-8 setting
	 * it to that value
	 */

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// getting page encoding from the request
		String coding = request.getCharacterEncoding();

		// checking for encoding. if its not an UTF-8 - setting to it
		if (!"UTF-8".equalsIgnoreCase(coding))
			response.setCharacterEncoding("UTF-8");
		
		// proceed the filter
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
=======
package com.bionicuniversity.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {
	/*
	 * Checking page encoding on all the website and if its not an UTF-8 setting
	 * it to that value
	 */

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// getting page encoding from the request
		String coding = request.getCharacterEncoding();

		// checking for encoding. if its not an UTF-8 - setting to it
		if (!"UTF-8".equalsIgnoreCase(coding))
			response.setCharacterEncoding("UTF-8");
		
		// proceed the filter
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
