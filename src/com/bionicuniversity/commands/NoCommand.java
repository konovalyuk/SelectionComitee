package com.bionicuniversity.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bionicuniversity.manager.ConfigurationManager;

public class NoCommand implements ICommand {
	/*
	 * If nothing is came to Controller servlet as a command parameter, just
	 * redirecting to main page
	 */

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.MAIN_PAGE_PATH);
		return page;
	}

}
