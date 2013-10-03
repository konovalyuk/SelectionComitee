package com.bionicuniversity.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionicuniversity.manager.ConfigurationManager;
import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class ChangeApplicantStatusCommand implements ICommand {
	/* Changing applicant status in AdminList */

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;

		// getting ID of applicant
		int idUser = Integer.parseInt(request.getParameter("Enter").toString());
		
		// changing his status
		ListDAO listDAO = new DAOFactory().getListDAO();
		listDAO.changeStatus(idUser);

		// back to the same page
		page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.ADMIN_LIST_PAGE_PATH);
		
		ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
		int facId = applicantDAO.getFacultyId(idUser);
		
		FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
		String facName = facultyDAO.getNameById(facId);

		return "/controller?command=adminviewapplicants&faculty=" + facName;
	}
}
