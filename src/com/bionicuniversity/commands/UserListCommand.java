<<<<<<< HEAD
package com.bionicuniversity.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;

import com.bionicuniversity.DAOFactory.DAOFactory;


public class UserListCommand implements ICommand {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;

		ArrayList<String> faculties = null;
		ArrayList<Integer> applicantIds = null;
		
		FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
		ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
		
		faculties = facultyDAO.getFaculties();
		applicantIds = applicantDAO.getIds();
		
		request.setAttribute("faculties", faculties);
		request.setAttribute("applicantIds", applicantIds);
		

		return "/user_list.jsp";
	}
}
=======
package com.bionicuniversity.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;

import com.bionicuniversity.DAOFactory.DAOFactory;


public class UserListCommand implements ICommand {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;

		ArrayList<String> faculties = null;
		ArrayList<Integer> applicantIds = null;
		
		FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
		ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
		
		faculties = facultyDAO.getFaculties();
		applicantIds = applicantDAO.getIds();
		
		request.setAttribute("faculties", faculties);
		request.setAttribute("applicantIds", applicantIds);
		

		return "/user_list.jsp";
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
