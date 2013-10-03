package com.bionicuniversity.tlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;


import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.manager.MessageManager;

public class RegisterTld extends SimpleTagSupport {

	public void doTag() throws JspException {

		try {
			JspWriter out = getJspContext().getOut();
			
			String header = MessageManager.getInstance().getProperty(MessageManager.REGISTER_HEADER);
			String login = MessageManager.getInstance().getProperty(MessageManager.REGISTER_LOGIN);
			String password = MessageManager.getInstance().getProperty(MessageManager.REGISTER_PASSWORD);
			String name = MessageManager.getInstance().getProperty(MessageManager.REGISTER_NAME);
			String surname = MessageManager.getInstance().getProperty(MessageManager.REGISTER_SURNAME);
			String userType = MessageManager.getInstance().getProperty(MessageManager.REGISTER_USER_TYPE);
			String proceed = MessageManager.getInstance().getProperty(MessageManager.REGISTER_PROCEED);
			
			UserTypeDAO userTypeDAO = new DAOFactory().getUserTypeDAO();
			ArrayList<String> userTypes = userTypeDAO.getTypes();
			int idUserType;
			
			out.write("<h1>" + header + "</h1>");
			out.write("<form name=\"userRegisterForm\" method=\"POST\" action=\"controller\">");
			out.write("<input type=\"hidden\" name=\"command\" value=\"userregister\">");
			out.write("<p>" + login + ":</p>");
			out.write("<input type=\"text\" name=\"login\" value=\"\"></input><br/>");
			out.write("<p>" + password + ":</p>");
			out.write("<input type=\"password\" name=\"password\" value=\"\"></input><br/>");
			out.write("<p>" + name + ":</p>");
			out.write("<input type=\"text\" name=\"name\" value=\"\"></input><br/>");
			out.write("<p>" + surname + ":</p>");
			out.write("<input type=\"text\" name=\"surname\" value=\"\"></input><br/>");
			out.write("<p>" + userType + ":</p>");
			for(String userT : userTypes) {
            	idUserType = userTypeDAO.getId(userT);
            	out.write("<input type=\"radio\" name=\"usertype\" value=" + idUserType + ">" + userT + "<br/>");
			}
			out.write("<br/>");
			out.write("<input type=\"submit\" value=\"" + proceed + "\"></input>");
		    out.write("</form>");
		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}