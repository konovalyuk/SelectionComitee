package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bionicuniversity.DAO.ResultsDAO;
import com.bionicuniversity.beans.Result;
import com.bionicuniversity.manager.ConnectionManager;

public class ResultsDAOImpl implements ResultsDAO {

	public boolean add(Result result) {
		try {
			Connection conn = null;
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = null;

			st = conn
					.prepareStatement("INSERT INTO selection.results(applicant_user_idUser, disciplines_idSubject, Grade) VALUES(?,?,?)");
			st.setInt(1, result.getApplicant_user_idUser());
			st.setInt(2, result.getDisciplines_idSubject());
			st.setString(3, result.getGrade());
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
			return false;
		}
	}
	
	public ArrayList<Integer> getGrades(final int id) {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Grade FROM selection.results WHERE applicant_user_idUser=?");
					st.setInt(1, id);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							ids.add(res.getInt("Grade"));
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
			return ids;
		}
	}
	
	public ArrayList<Integer> getDisciplines(final int id) {
		
		ArrayList<Integer> disciplines = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT disciplines_idSubject FROM selection.results WHERE applicant_user_idUser=?");
					st.setInt(1, id);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							disciplines.add(res.getInt("disciplines_idSubject"));
						}
						
						return disciplines;
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
			return disciplines;
		}
	}
}
