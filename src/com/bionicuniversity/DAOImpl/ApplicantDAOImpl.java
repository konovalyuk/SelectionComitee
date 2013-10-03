package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bionicuniversity.DAO.ApplicantDAO;
import com.bionicuniversity.beans.Applicant;
import com.bionicuniversity.manager.ConnectionManager;

public class ApplicantDAOImpl implements ApplicantDAO {
	
	static Logger logger = Logger.getLogger(ApplicantDAOImpl.class);
	
	public boolean add(Applicant applicant) {
		logger.debug("Class ApplicantDAOImpl, method add start");
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn
					.prepareStatement("INSERT INTO selection.applicant(user_idUser, faculty_idFaculty) VALUES(?, ?)");
			st.setInt(1, applicant.getUser_idUser());
			st.setInt(2, applicant.getFaculty_idFaculty());
			st.executeUpdate();
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				ConnectionManager.getInstance().closeConnection(conn);
			}

			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return false;
		} finally {
			logger.debug("Class ApplicantDAOImpl, method add end");
		}
		
	}
	
	public ArrayList<Integer> getIds() {
		logger.debug("Class ApplicantDAOImpl, method getIds start");
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT user_idUser FROM selection.applicant");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							ids.add(res.getInt("user_idUser"));
						}
						
						return ids;
					} finally {
						if (res != null) {
							res.close();
						}
					}
				} finally {
					if (st != null) {
						st.close();
					}
				}
			} finally {
				if (conn != null) {
					ConnectionManager.getInstance().closeConnection(conn);
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return ids;
		} finally {
			logger.debug("Class ApplicantDAOImpl, method getIds end");
		}
	}
	
	public Integer getFacultyId(final int id) {
		logger.debug("Class ApplicantDAOImpl, method getFacultyId start");
		Integer facultyId = null;
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT faculty_idFaculty FROM selection.applicant WHERE user_idUser=?");
					st.setInt(1, id);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while (res.next()) {
							facultyId = res.getInt("faculty_idFaculty");
						}
						return facultyId;
					} finally {
						if (res != null) {
							res.close();
						}
					}
				} finally {
					if (st != null) {
						st.close();
					}
				}
			} finally {
				if (conn != null) {
					ConnectionManager.getInstance().closeConnection(conn);
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occured due to ", ex);
			return facultyId;
		} finally {
			logger.debug("Class ApplicantDAOImpl, method getFacultyId end");
		}
	}
}
