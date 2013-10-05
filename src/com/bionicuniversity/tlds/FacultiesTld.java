<<<<<<< HEAD
package com.bionicuniversity.tlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.DAO.DisciplinesDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.RequiredDisciplinesDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class FacultiesTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = null;
		ArrayList<String> faculties = null;
		ArrayList<Integer> requiredDisciplines = null;

		try {
			JspWriter out = getJspContext().getOut();

			try {
				session = pageContext.getSession();
				FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
				RequiredDisciplinesDAO requiredDisciplinesDAO = new DAOFactory().getRequiredDisciplinesDAO();
				DisciplinesDAO disciplinesDAO = new DAOFactory().getDisciplinesDAO();
				faculties = facultyDAO.getFaculties();
				
				int idFac;
				int i = 1, k = 1;
				String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				out.write("<form name=\"facultyRegisterForm\" method=\"POST\" action=\"controller\">");
	            out.write("<input type=\"hidden\" name=\"command\" value=\"registerfaculty\">");
	            for(String faculty : faculties) {
	            	idFac = facultyDAO.getId(faculty);
	            	requiredDisciplines = requiredDisciplinesDAO.getRequiredDisciplines(idFac);
	            	out.write("<input type=\"radio\" name=\"faculty\" value=" + idFac + ">" + faculty + "<br/>");
	            	for(Integer idDisciplines : requiredDisciplines) {
						String discipline = disciplinesDAO.getDiscipline(idDisciplines);
						session.setAttribute("discipline" + k, idDisciplines);
						out.write("<i>" + discipline + ": </i>");
						out.write("<input type=\"text\" name=\"grade" + i + "\" value=\"\"></input><br/>");
						out.write("<sup>" + space + "From 1 to 100</sup><br/>");
						i++;
						k++;
					}
	            	k = 1;
	            	out.write("<input type=\"submit\" value=\"Proceed\"></input>");
	            	out.write("<br />");
	            	out.write("<hr />");
				}
	            
	            out.write("</form>");
			} catch (NullPointerException e) {
				out.write("sad");
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

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.bionicuniversity.DAO.DisciplinesDAO;
import com.bionicuniversity.DAO.FacultyDAO;
import com.bionicuniversity.DAO.RequiredDisciplinesDAO;
import com.bionicuniversity.DAOFactory.DAOFactory;

public class FacultiesTld extends SimpleTagSupport {

	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpSession session = null;
		ArrayList<String> faculties = null;
		ArrayList<Integer> requiredDisciplines = null;

		try {
			JspWriter out = getJspContext().getOut();

			try {
				session = pageContext.getSession();
				FacultyDAO facultyDAO = new DAOFactory().getFacultyDAO();
				RequiredDisciplinesDAO requiredDisciplinesDAO = new DAOFactory().getRequiredDisciplinesDAO();
				DisciplinesDAO disciplinesDAO = new DAOFactory().getDisciplinesDAO();
				faculties = facultyDAO.getFaculties();
				
				int idFac;
				int i = 1, k = 1;
				String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				out.write("<form name=\"facultyRegisterForm\" method=\"POST\" action=\"controller\">");
	            out.write("<input type=\"hidden\" name=\"command\" value=\"registerfaculty\">");
	            for(String faculty : faculties) {
	            	idFac = facultyDAO.getId(faculty);
	            	requiredDisciplines = requiredDisciplinesDAO.getRequiredDisciplines(idFac);
	            	out.write("<input type=\"radio\" name=\"faculty\" value=" + idFac + ">" + faculty + "<br/>");
	            	for(Integer idDisciplines : requiredDisciplines) {
						String discipline = disciplinesDAO.getDiscipline(idDisciplines);
						session.setAttribute("discipline" + k, idDisciplines);
						out.write("<i>" + discipline + ": </i>");
						out.write("<input type=\"text\" name=\"grade" + i + "\" value=\"\"></input><br/>");
						out.write("<sup>" + space + "From 1 to 100</sup><br/>");
						i++;
						k++;
					}
	            	k = 1;
	            	out.write("<input type=\"submit\" value=\"Proceed\"></input>");
	            	out.write("<br />");
	            	out.write("<hr />");
				}
	            
	            out.write("</form>");
			} catch (NullPointerException e) {
				out.write("sad");
			}

		} catch (IOException ex) {
			throw new JspException(ex.getMessage());
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
