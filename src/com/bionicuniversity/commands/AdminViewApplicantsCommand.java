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

public class AdminViewApplicantsCommand implements ICommand {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> faculties = null;
		ArrayList<Integer> applicantIds = null;
		ArrayList<Integer> grades = null;
		ArrayList<Integer> sizes;
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
        sizes = facultyDAO.getSizes();
        int statSize = 0;
        int size = sizes.get(idFac - 1);
        
        ArrayList<String> fullnames = new ArrayList<String>();
    	ArrayList<Integer> fullgrades = new ArrayList<Integer>();
    	ArrayList<Integer> facultyIds = new ArrayList<Integer>();
    	ArrayList<String> statuses = new ArrayList<String>();
    	String statT = "Enrolled";
    	String statF = "Not enrolled";
        	
        for(int id : applicantIds) {
        	int applicantIdFac = applicantDAO.getFacultyId(id);
        	if(idFac == applicantIdFac) {
        		String name = userDAO.getName(id);
            	String surname = userDAO.getSurname(id);
            	boolean status = listDAO.getStatus(id);
            	String statTable;
				if (status) {
					statTable = statT;
				} else {
					statTable = statF;
				}
            	
            	grades = resultsDAO.getGrades(id);
            	summaryGrade = 0;
            	
            	for(int grade : grades) {
            		summaryGrade += grade;
            	}
            	
            	if(listDAO.getStatus(id)) {
        			statSize++;
        			
        		}
            	fullnames.add(name + " " + surname);
            	fullgrades.add(summaryGrade);
            	statuses.add(statTable);
            	facultyIds.add(id);
        	}
		}
        
        request.setAttribute("size", size);
        request.setAttribute("statsize", statSize);
        request.setAttribute("fullnames", fullnames);
    	request.setAttribute("fullgrades", fullgrades);
    	request.setAttribute("statuses", statuses);
    	request.setAttribute("facultyIds", facultyIds);
    	
    	statSize = 0;
    	
		return "/admin_user_list.jsp";
	}
}
