package com.bionicuniversity.tlds;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class AdminUserPageTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = null;
		String user = null;
		String password = null;
		Integer userType = null;
		Integer id = null;
		String type = null;


		try {
			JspWriter out = getJspContext().getOut();
			try {
				session = pageContext.getSession();
				user = session.getAttribute("user").toString();
				password = session.getAttribute("password").toString();
				userType = Integer.parseInt(session.getAttribute("userType").toString());
				
				UserDAO userDAO = new DAOFactory().getUserDAO();
				UserTypeDAO userTypeDAO = new DAOFactory().getUserTypeDAO();
				id = userDAO.getId(user, password);
				type = userTypeDAO.getType(userType);
				String name = userDAO.getName(id);
        		String surname = userDAO.getSurname(id);
        		
	            out.write("<h1>" + user + "</h1><br/>");
	            out.write("<table border=\"1\" width=\"100%\">");
	            out.write("<tr><th>id</th><th>Name</th><th>User type</th><th>Localization</th></tr>");
		        out.write("<tr><td>" + id + "</td>" +
		          		"<td>" + name + " " + surname + "</td>" +
		           		"<td>" + type + "</td>" + 
		           		"<td>" +
	            		"<form name=\"userForm\" method=\"POST\" action=\"controller\">" +
	            		"<input type=\"hidden\" name=\"command\" value=\"changelocalization\">" +
	            		"<input type=\"submit\" value=\"ChangeLoc\"></input></form></td></tr>");
	           	out.write("</table>");
	           	out.write("<br />");
            	out.write("<hr />");
			} catch (NullPointerException e) {
				out.write("null");
			}
		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
