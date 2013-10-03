package com.bionicuniversity.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.DAO.AdminDAO;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAO.UserTypeDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.beans.Admin;
import com.bionicuniversity.beans.User;

public class UserRegisterCommand implements ICommand {
	/*
	 * Getting parameters from register page, creating new user in a database
	 * and user type is admin - redirecting to the main page, if its user -
	 * redirecting to next registration page to continue registration
	 */

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_NAME = "name";
	private static final String PARAM_NAME_SURNAME = "surname";
	private static final String PARAM_NAME_USERTYPE = "usertype";

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;

		// getting parameters
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		String name = request.getParameter(PARAM_NAME_NAME);
		String surname = request.getParameter(PARAM_NAME_SURNAME);
		int userType = Integer.parseInt(request.getParameter(PARAM_NAME_USERTYPE));

		// creating new user entity
		User user = new User(login, name, password, surname, userType);
		UserDAO userDAO = new DAOFactory().getUserDAO();
		UserTypeDAO userTypeDAO = new DAOFactory().getUserTypeDAO();
		AdminDAO adminDAO = new DAOFactory().getAdminDAO();

		// depending on user type creates new admin or continuing registration
		// process
		if (userDAO.add(user)) {
			int userId = userDAO.getId(login, password);
			if (userTypeDAO.getType(user.getUser_type_User_type()).equals("admin")) {
				Admin admin = new Admin(userId);
				adminDAO.add(admin);
				page = ConfigurationManager.getInstance().getProperty(
						ConfigurationManager.LOGIN_PAGE_PATH);
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("idUser", userId);

				page = ConfigurationManager.getInstance().getProperty(
						ConfigurationManager.REGISTER_FACULTY_PAGE_PATH);
			}
		} else {
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}
}
