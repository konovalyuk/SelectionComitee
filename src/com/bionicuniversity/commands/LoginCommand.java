<<<<<<< HEAD
package com.bionicuniversity.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.manager.MessageManager;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class LoginCommand implements ICommand {
	/*
	 * Checking user login, starting new session with user parameters if it
	 * exist
	 */

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;

		// getting parameters from the login page
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		UserDAO userDAO = new DAOFactory().getUserDAO();
		UserTypeDAO userTypeDAO = new DAOFactory().getUserTypeDAO();

		// check login and getting user type
		int type = userDAO.checkLogin(login, password);

		// if all ok, starting session and setting attributes, going to main
		// page. Otherwise redirect to error page with appropriate error massage
		if (userTypeDAO.checkType(type)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", login);
			session.setAttribute("password", password);
			session.setAttribute("userType", type);

			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.MAIN_PAGE_PATH);
		} else {
			request.setAttribute("errorMessage",
					MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}

		return page;
	}

}
=======
package com.bionicuniversity.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.manager.MessageManager;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class LoginCommand implements ICommand {
	/*
	 * Checking user login, starting new session with user parameters if it
	 * exist
	 */

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;

		// getting parameters from the login page
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		UserDAO userDAO = new DAOFactory().getUserDAO();
		UserTypeDAO userTypeDAO = new DAOFactory().getUserTypeDAO();

		// check login and getting user type
		int type = userDAO.checkLogin(login, password);

		// if all ok, starting session and setting attributes, going to main
		// page. Otherwise redirect to error page with appropriate error massage
		if (userTypeDAO.checkType(type)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", login);
			session.setAttribute("password", password);
			session.setAttribute("userType", type);

			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.MAIN_PAGE_PATH);
		} else {
			request.setAttribute("errorMessage",
					MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}

		return page;
	}

}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
