package com.bionicuniversity.servlet;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.bionicuniversity.commands.ChangeApplicantStatusCommand;
import com.bionicuniversity.commands.ChangeLocalizationCommand;
import com.bionicuniversity.commands.ICommand;
import com.bionicuniversity.commands.LoginCommand;
import com.bionicuniversity.commands.LogoutCommand;
import com.bionicuniversity.commands.NoCommand;
import com.bionicuniversity.commands.RegisterFacultyCommand;
import com.bionicuniversity.commands.UserListCommand;
import com.bionicuniversity.commands.UserRegisterCommand;
import com.bionicuniversity.commands.ViewApplicantsCommand;

class ControllerHelper {
	/*
	 * Getting a command from the Controller and return a page if command were
	 * find in Commands hashmap or redirects to the main page
	 */
	
	private static ControllerHelper instance = null;
	
	// forming map of all existing commands
	HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private ControllerHelper() {
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("userregister", new UserRegisterCommand());
		commands.put("registerfaculty", new RegisterFacultyCommand());
		commands.put("changestatus", new ChangeApplicantStatusCommand());
		commands.put("changelocalization", new ChangeLocalizationCommand());
		commands.put("userlist", new UserListCommand());
		commands.put("viewapplicants", new ViewApplicantsCommand());
	}
	
	// getting request parameter "command" and checks if it exist in "commands"
	// hashmap, if not - return the NoCommand instance, otherwise return
	// appropriate command 
	public ICommand getCommand(HttpServletRequest request) {
		String action = request.getParameter("command");
		ICommand command = commands.get(action);
		if (command == null) {
			command = new NoCommand();
		}
		return command;
	}

	public static ControllerHelper getInstance() {
		if (instance == null) {
			instance = new ControllerHelper();
		}
		return instance;
	}

}
