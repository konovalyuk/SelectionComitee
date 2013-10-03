package com.bionicuniversity.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.manager.MessageManager;

public class ChangeLocalizationCommand implements ICommand {
	/* Changing localization of website from User Page */

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;

		// switching resourse bundle of MessageManager
		MessageManager.getInstance().setBundle();

		// back to user page
		page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.CHECK_USER_PAGE_PATH);

		return page;
	}
}
