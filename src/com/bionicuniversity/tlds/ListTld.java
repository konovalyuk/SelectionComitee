<<<<<<< HEAD
package com.bionicuniversity.tlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAO.ResultsDAO;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.manager.MessageManager;

public class ListTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		ArrayList<String> faculties = null;
		ArrayList<Integer> applicantIds = null;
		ArrayList<Integer> grades = null;
		int summaryGrade;
		ArrayList<Integer> sizes;

		try {
			JspWriter out = getJspContext().getOut();

			try {
				FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
				ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
				UserDAO userDAO = new DAOFactory().getUserDAO();
				ResultsDAO resultsDAO = new DAOFactory().getResultsDAO();
				ListDAO listDAO = new DAOFactory().getListDAO();
				
				String header = MessageManager.getInstance().getProperty(MessageManager.LIST_HEADER);
				String applicant = MessageManager.getInstance().getProperty(MessageManager.LIST_APPLICANT);
				String sumGrade = MessageManager.getInstance().getProperty(MessageManager.LIST_GRADE);
				String sizeMax = MessageManager.getInstance().getProperty(MessageManager.LIST_SIZE_MAX);
				String sizeR = MessageManager.getInstance().getProperty(MessageManager.LIST_SIZE);
				
				faculties = facultyDAO.getFaculties();
				applicantIds = applicantDAO.getIds();
				sizes = facultyDAO.getSizes();
				int statSize = 0;
				out.write("<h1>" + header + "</h1>");
	            for(String faculty : faculties) {
	            	int idFac = facultyDAO.getId(faculty);
	            	int size = sizes.get(idFac - 1);
	            	out.write("<b>" + faculty + "</b><br/>");
	            	
	            	out.write("<table border=\"1\" width=\"100%\">");
	            	out.write("<tr><th>" + applicant + "</th><th>" + sumGrade + "</th></tr>");
	            	
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
		            		
		            		if(listDAO.getStatus(id)) {
		            			statSize++;
		            			out.write("<tr><td>" + name + " " + surname + "</td>" +
			            				"<td>" + summaryGrade + "</td></tr>");
		            		}
	            		}
					}
	            	out.write("</table>");
	            	out.write("<b>" + sizeMax + ": " + size + "; " + sizeR + ": " + statSize + ".</b><br/>");
	            	statSize = 0;
	            	out.write("<br />");
	            	out.write("<hr />");
				}
	            
			} catch (NullPointerException e) {
				out.write("null");
			}

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
=======
package com.bionicuniversity.tlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAO.ResultsDAO;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.manager.MessageManager;

public class ListTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		ArrayList<String> faculties = null;
		ArrayList<Integer> applicantIds = null;
		ArrayList<Integer> grades = null;
		int summaryGrade;
		ArrayList<Integer> sizes;

		try {
			JspWriter out = getJspContext().getOut();

			try {
				FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
				ApplicantDAO applicantDAO = new DAOFactory().getApplicantDAO();
				UserDAO userDAO = new DAOFactory().getUserDAO();
				ResultsDAO resultsDAO = new DAOFactory().getResultsDAO();
				ListDAO listDAO = new DAOFactory().getListDAO();
				
				String header = MessageManager.getInstance().getProperty(MessageManager.LIST_HEADER);
				String applicant = MessageManager.getInstance().getProperty(MessageManager.LIST_APPLICANT);
				String sumGrade = MessageManager.getInstance().getProperty(MessageManager.LIST_GRADE);
				String sizeMax = MessageManager.getInstance().getProperty(MessageManager.LIST_SIZE_MAX);
				String sizeR = MessageManager.getInstance().getProperty(MessageManager.LIST_SIZE);
				
				faculties = facultyDAO.getFaculties();
				applicantIds = applicantDAO.getIds();
				sizes = facultyDAO.getSizes();
				int statSize = 0;
				out.write("<h1>" + header + "</h1>");
	            for(String faculty : faculties) {
	            	int idFac = facultyDAO.getId(faculty);
	            	int size = sizes.get(idFac - 1);
	            	out.write("<b>" + faculty + "</b><br/>");
	            	
	            	out.write("<table border=\"1\" width=\"100%\">");
	            	out.write("<tr><th>" + applicant + "</th><th>" + sumGrade + "</th></tr>");
	            	
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
		            		
		            		if(listDAO.getStatus(id)) {
		            			statSize++;
		            			out.write("<tr><td>" + name + " " + surname + "</td>" +
			            				"<td>" + summaryGrade + "</td></tr>");
		            		}
	            		}
					}
	            	out.write("</table>");
	            	out.write("<b>" + sizeMax + ": " + size + "; " + sizeR + ": " + statSize + ".</b><br/>");
	            	statSize = 0;
	            	out.write("<br />");
	            	out.write("<hr />");
				}
	            
			} catch (NullPointerException e) {
				out.write("null");
			}

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
