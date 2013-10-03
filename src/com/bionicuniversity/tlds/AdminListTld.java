package com.bionicuniversity.tlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.ListDAO;
import com.bionicuniversity.DAO.ResultsDAO;
import com.bionicuniversity.DAO.UserDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;
import com.bionicuniversity.DAOImpl.AdminDAOImpl;
import com.bionicuniversity.manager.MessageManager;

public class AdminListTld extends SimpleTagSupport {
	/* Forming list_admin.jsp content */
	
	static Logger logger = Logger.getLogger(AdminDAOImpl.class);

	public void doTag() throws JspException {
		logger.debug("tld AdminListTld, method doTag start");
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
				ListDAO listDAO = new DAOFactory().getListDAO();
				ResultsDAO resultsDAO = new DAOFactory().getResultsDAO();
				
				// getting message fields for localization
				String header = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_HEADER);
				String applicant = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_APPLICANT);
				String sumGrade = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_GRADE);
				String stat = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_STATUS);
				String statT = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_STATUS_T);
				String statF = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_STATUS_F);
				String sizeMax = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_SIZE_MAX);
				String sizeR = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_SIZE);
				String changeStat = MessageManager.getInstance().getProperty(
						MessageManager.ADMIN_LIST_CHANGE_STATUS);

				faculties = facultyDAO.getFaculties();
				applicantIds = applicantDAO.getIds();
				sizes = facultyDAO.getSizes();
				int statSize = 0;

				out.write("<h1>" + header + "</h1>");

				// looping through the faculties ArrayList and throught the
				// Applicants IDs and forming table for each faculty with
				// enrolles
				for (String faculty : faculties) {
					int idFac = facultyDAO.getId(faculty);
					int size = sizes.get(idFac - 1);
					out.write("<b>" + faculty + "</b><br/>");

					out.write("<table border=\"1\" width=\"100%\">");
					out.write("<tr><th>" + applicant + "</th><th>" + sumGrade + "</th><th>" + stat
							+ "</th><th> </th></tr>");

					for (int id : applicantIds) {
						int applicantIdFac = applicantDAO.getFacultyId(id);
						if (idFac == applicantIdFac) {
							String name = userDAO.getName(id);
							String surname = userDAO.getSurname(id);
							boolean status = listDAO.getStatus(id);
							String statTable;
							if (status) {
								statTable = statT;
							} else {
								statTable = statF;
							}
							if (listDAO.getStatus(id)) {
								statSize++;
							}
							grades = resultsDAO.getGrades(id);
							summaryGrade = 0;

							for (int grade : grades) {
								summaryGrade += grade;
							}
							out.write("<tr><td>"
									+ name
									+ " "
									+ surname
									+ "</td>"
									+ "<td>"
									+ summaryGrade
									+ "</td>"
									+ "<td>"
									+ statTable
									+ "</td>"
									+ "<td>"
									+ "<form name=\"adminListForm"
									+ id
									+ "\" method=\"POST\" action=\"controller\">"
									+ "<input type=\"hidden\" name=\"command\" value=\"changestatus\">"
									+ "<input type=\"hidden\" name=\"Enter\" value=\"" + id + "\">"
									+ "<input type=\"submit\" value=\"" + changeStat
									+ "\"></input></form></td></tr>");
						}
					}
					out.write("</table>");
					out.write("<b>" + sizeMax + ": " + size + "; " + sizeR + ": " + statSize
							+ ".</b><br/>");
					statSize = 0;
					out.write("<br />");
					out.write("<hr />");
				}

			} catch (NullPointerException e) {
				out.write("null");
				logger.error("Error occured due to ", e);
			}

		} catch (IOException ex) {
			logger.error("Error occured due to ", ex);
			throw new JspException(ex.getMessage());
		}
	logger.debug("tld AdminListTld, method doTag end");
	}
}
