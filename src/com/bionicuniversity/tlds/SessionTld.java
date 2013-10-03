package com.bionicuniversity.tlds;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class SessionTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = null;
		String user = null;
		Integer userType = null;

		try {
			JspWriter out = getJspContext().getOut();

			try {
				session = pageContext.getSession();
				user = session.getAttribute("user").toString();
				userType = Integer.parseInt(session.getAttribute("userType").toString());
				if ((user != null) && (userType) != null) {
					out.write("<a href=\"check_user_page.jsp\">" + user + "</a>, <i>");
					if (userType == 1) {
						out.write("admin</i>");
					} else {
						out.write("user</i>");
					}
				}
			} catch (NullPointerException e) {
				out.write("<a href=\"login.jsp\">Login</a>");
			}

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
