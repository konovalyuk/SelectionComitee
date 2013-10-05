<<<<<<< HEAD
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
=======
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
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
