<<<<<<< HEAD
package com.bionicuniversity.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bionicuniversity.manager.ConfigurationManager;

public class LogoutCommand implements ICommand {
	/*Getting current session and removing user attributes*/

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page;
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("userType");
		page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.LOGIN_PAGE_PATH);

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

public class LogoutCommand implements ICommand {
	/*Getting current session and removing user attributes*/

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page;
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("userType");
		page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.LOGIN_PAGE_PATH);

		return page;
	}

}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
