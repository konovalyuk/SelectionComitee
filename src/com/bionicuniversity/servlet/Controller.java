<<<<<<< HEAD
package com.bionicuniversity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.bionicuniversity.commands.ICommand;
import com.bionicuniversity.servlet.ControllerHelper;
import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.manager.MessageManager;

public class Controller extends HttpServlet {
	/*
	 * Processing every command that it would gets and depending on Request
	 * Helper result - redirecting to the appropriate page
	 */

	static Logger logger = Logger.getLogger(Controller.class);

	private static final long serialVersionUID = 1L;
	ControllerHelper requestHelper = ControllerHelper.getInstance();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("Class Controller, method processRequest start");

		String page = null;
		try {
			// sending command to the ControllerHelper and executing the command
			// instance that he returned
			ICommand command = requestHelper.getCommand(request);
			page = command.execute(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			request.setAttribute(
					"errorMessage",
					MessageManager.getInstance().getProperty(
							MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
			logger.error("Error occured due to ", e);
		} catch (IOException e) {
			e.printStackTrace();
			request.setAttribute(
					"errorMessage",
					MessageManager.getInstance().getProperty(
							MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
			logger.error("Error occured due to ", e);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
		logger.debug("Class Controller, method processRequest start");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
=======
package com.bionicuniversity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.bionicuniversity.commands.ICommand;
import com.bionicuniversity.servlet.ControllerHelper;
import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.manager.MessageManager;

public class Controller extends HttpServlet {
	/*
	 * Processing every command that it would gets and depending on Request
	 * Helper result - redirecting to the appropriate page
	 */

	static Logger logger = Logger.getLogger(Controller.class);

	private static final long serialVersionUID = 1L;
	ControllerHelper requestHelper = ControllerHelper.getInstance();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("Class Controller, method processRequest start");

		String page = null;
		try {
			// sending command to the ControllerHelper and executing the command
			// instance that he returned
			ICommand command = requestHelper.getCommand(request);
			page = command.execute(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			request.setAttribute(
					"errorMessage",
					MessageManager.getInstance().getProperty(
							MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
			logger.error("Error occured due to ", e);
		} catch (IOException e) {
			e.printStackTrace();
			request.setAttribute(
					"errorMessage",
					MessageManager.getInstance().getProperty(
							MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
			logger.error("Error occured due to ", e);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
		logger.debug("Class Controller, method processRequest start");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
