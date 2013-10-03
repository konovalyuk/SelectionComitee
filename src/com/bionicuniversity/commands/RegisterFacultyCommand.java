package com.bionicuniversity.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.manager.MessageManager;
import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAO.ResultsDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.beans.Applicant;
import com.bionicuniversity.beans.List;
import com.bionicuniversity.beans.Result;

public class RegisterFacultyCommand implements ICommand {
	/*
	 * Its a second phase of registration process for the User. Parsing selected
	 * faculty and grades from appropriate disciplines and inserting that data
	 * to the database
	 */  

	private static final String PARAM_NAME_FACULTY = "faculty";

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;
		
		HttpSession session = request.getSession();
		// getting userID from first registration page
		int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
		// getting parameters that was entered on second part of registration
		int faculty = Integer.parseInt(request.getParameter(PARAM_NAME_FACULTY));
		int disciplineOne = Integer.parseInt(session.getAttribute("discipline1").toString());
		int disciplineTwo = Integer.parseInt(session.getAttribute("discipline2").toString());
		String gradeOne;
		String gradeTwo;

		if (faculty == 1) {
			gradeOne = request.getParameter("grade1");
			gradeTwo = request.getParameter("grade2");
		} else if (faculty == 2) {
			gradeOne = request.getParameter("grade3");
			gradeTwo = request.getParameter("grade4");
		} else {
			gradeOne = request.getParameter("grade5");
			gradeTwo = request.getParameter("grade6");
		}
		
		// creating new applicant, results, list entities
		Applicant applicant = new Applicant(idUser, faculty);
		Result resultOne = new Result(idUser, disciplineOne, gradeOne);
		Result resultTwo = new Result(idUser, disciplineTwo, gradeTwo);
		List listUser = new List(idUser, faculty);
		
		ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
		ResultsDAO resultsDAO = new DAOFactory().getResultsDAO();
		ListDAO listDAO = new DAOFactory().getListDAO();
		
		// if grades were entered incorrect - redirecting to the error page.
		// else saving applicant, results and adding applicant to the List
		if ((Integer.parseInt(gradeOne) > 100) || (Integer.parseInt(gradeOne) < 1)
				|| (Integer.parseInt(gradeTwo) > 100) || (Integer.parseInt(gradeTwo) < 1)) {
			request.setAttribute("errorMessage",
					MessageManager.getInstance().getProperty(MessageManager.REGISTER_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		} else if (applicantDAO.add(applicant)) {
			resultsDAO.add(resultOne);
			resultsDAO.add(resultTwo);
			listDAO.add(listUser);
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.LOGIN_PAGE_PATH);

		} else {
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}
}
