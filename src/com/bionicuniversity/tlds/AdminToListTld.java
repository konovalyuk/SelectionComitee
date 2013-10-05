<<<<<<< HEAD
package com.bionicuniversity.tlds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class AdminToListTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = null;
		Integer userType = null;

		try {
			RequestDispatcher rd = pageContext.getServletContext().getRequestDispatcher("/list.jsp");
			try {
				session = pageContext.getSession();
				userType = Integer.parseInt(session.getAttribute("userType").toString());
				if (userType != null) {
					if (userType != 1) {
						rd.forward(pageContext.getRequest(), pageContext.getResponse());
					}
				}
			} catch (NullPointerException e) {
				try {
					rd.forward(pageContext.getRequest(), pageContext.getResponse());
				} catch (ServletException e1) {
					e1.printStackTrace();
				}
			} catch (ServletException e) {
				e.printStackTrace();
			}

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
=======
package com.bionicuniversity.tlds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class AdminToListTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = null;
		Integer userType = null;

		try {
			RequestDispatcher rd = pageContext.getServletContext().getRequestDispatcher("/list.jsp");
			try {
				session = pageContext.getSession();
				userType = Integer.parseInt(session.getAttribute("userType").toString());
				if (userType != null) {
					if (userType != 1) {
						rd.forward(pageContext.getRequest(), pageContext.getResponse());
					}
				}
			} catch (NullPointerException e) {
				try {
					rd.forward(pageContext.getRequest(), pageContext.getResponse());
				} catch (ServletException e1) {
					e1.printStackTrace();
				}
			} catch (ServletException e) {
				e.printStackTrace();
			}

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
