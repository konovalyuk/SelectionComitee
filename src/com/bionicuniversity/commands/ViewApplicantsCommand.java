package com.bionicuniversity.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAO.ResultsDAO;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class ViewApplicantsCommand implements ICommand {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;

		ArrayList<String> faculties = null;
		ArrayList<Integer> applicantIds = null;
		ArrayList<Integer> grades = null;
		int summaryGrade;
		
		FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
		ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
		UserDAO userDAO = new DAOFactory().getUserDAO();
		ResultsDAO resultsDAO = new DAOFactory().getResultsDAO();
		ListDAO listDAO = new DAOFactory().getListDAO();
		
		faculties = facultyDAO.getFaculties();
		applicantIds = applicantDAO.getIds();
		
		String faculty = request.getParameter("faculty").toString();
		
		request.setAttribute("facname", faculty);
		request.setAttribute("faculties", faculties);
		request.setAttribute("applicantIds", applicantIds);
		
        int idFac = facultyDAO.getId(faculty);
        ArrayList<String> fullnames = new ArrayList<String>();
    	ArrayList<Integer> fullgrades = new ArrayList<Integer>();
        	
        for(int id : applicantIds) {
        	int applicantIdFac = applicantDAO.getFacultyId(id);
        	if(idFac == applicantIdFac) {
        		String name = userDAO.getName(id);
            	String surname = userDAO.getSurname(id);
            	
            	grades = resultsDAO.getGrades(id);
            	summaryGrade = 0;
            	
            	for(int grade : grades) {
            		summaryGrade += grade;
            	}
            	
            	fullnames.add(name + " " + surname);
            	fullgrades.add(summaryGrade);
        	}
		}
        
        request.setAttribute("fullnames", fullnames);
    	request.setAttribute("fullgrades", fullgrades);

		return "/user_list.jsp";
	}
}
