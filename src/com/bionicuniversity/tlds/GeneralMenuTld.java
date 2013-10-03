package com.bionicuniversity.tlds;

import java.io.IOException;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.manager.MessageManager;

public class GeneralMenuTld extends SimpleTagSupport {

	public void doTag() throws JspException {

		try {
			JspWriter out = getJspContext().getOut();
			
			String home = MessageManager.getInstance().getProperty(MessageManager.MENU_HOME);
			String login = MessageManager.getInstance().getProperty(MessageManager.MENU_LOGIN);
			String logout = MessageManager.getInstance().getProperty(MessageManager.MENU_LOGOUT);
			String register = MessageManager.getInstance().getProperty(MessageManager.MENU_REGISTER);
			String list = MessageManager.getInstance().getProperty(MessageManager.MENU_LIST);
			String adminList = MessageManager.getInstance().getProperty(MessageManager.MENU_ADMIN_LIST);
			
			out.write("<li><a href=\"index.jsp\">" + home + "</a></li>");
			out.write("<li><a href=\"login.jsp\">" + login + "</a></li>");
			out.write("<li><a href=\"logout.jsp\">" + logout + "</a></li>");
			out.write("<li><a href=\"register.jsp\">" + register + "</a></li>");
			out.write("<li><a href=\"controller?command=userlist\">" + list + "</a></li>");
			out.write("<li><a href=\"controller?command=adminuserlist\">" + adminList + "</a></li>");
			//out.write("<li><a href=\"controller?command=userlist\"> User List </a></li>");
		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}