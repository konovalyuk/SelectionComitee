package com.bionicuniversity.DAOFactory;

import com.bionicuniversity.DAO.*;
import com.bionicuniversity.DAOImpl.*;

public class DAOFactory {
	
	public AdminDAO getAdminDAO() {
		return new AdminDAOImpl();
	}
	
	public ApplicantDAO getApplicantDAO() {
		return new ApplicantDAOImpl();
	}
	
	public DisciplinesDAO getDisciplinesDAO() {
		return new DisciplinesDAOImpl();
	}
	
	public FacultyDAO getFacultyDAO() {
		return new FacultyDAOImpl();
	}
	
	public ListDAO getListDAO() {
		return new ListDAOImpl();
	}
	
	public RequiredDisciplinesDAO getRequiredDisciplinesDAO() {
		return new RequiredDisciplinesDAOImpl();
	}
	
	public ResultsDAO getResultsDAO() {
		return new ResultsDAOImpl();
	}
	
	public UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	public UserTypeDAO getUserTypeDAO() {
		return new UserTypeDAOImpl();
	}
	
}
