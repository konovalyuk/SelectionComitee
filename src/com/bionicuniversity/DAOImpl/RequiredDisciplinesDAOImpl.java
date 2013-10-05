<<<<<<< HEAD
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bionicuniversity.DAO.RequiredDisciplinesDAO;
import com.bionicuniversity.manager.ConnectionManager;

public class RequiredDisciplinesDAOImpl implements RequiredDisciplinesDAO {
	
	public ArrayList<Integer> getRequiredDisciplines(final int faculty) {
		
		ArrayList<Integer> requiredDisciplines = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT disciplines_idSubject FROM selection.required_disciplines WHERE faculty_idFaculty=?");
					st.setInt(1, faculty);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							requiredDisciplines.add(res.getInt("disciplines_idSubject"));
						}
						
						return requiredDisciplines;
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
			return requiredDisciplines;
		}
	}
	
	public ArrayList<String> getSizes() {
		
		ArrayList<String> sizes = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Size FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							sizes.add(res.getString("Size"));
						}
						
						return sizes;
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
			return sizes;
		}
	}
}
=======
package com.bionicuniversity.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bionicuniversity.DAO.RequiredDisciplinesDAO;
import com.bionicuniversity.manager.ConnectionManager;

public class RequiredDisciplinesDAOImpl implements RequiredDisciplinesDAO {
	
	public ArrayList<Integer> getRequiredDisciplines(final int faculty) {
		
		ArrayList<Integer> requiredDisciplines = new ArrayList<Integer>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT disciplines_idSubject FROM selection.required_disciplines WHERE faculty_idFaculty=?");
					st.setInt(1, faculty);
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							requiredDisciplines.add(res.getInt("disciplines_idSubject"));
						}
						
						return requiredDisciplines;
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
			return requiredDisciplines;
		}
	}
	
	public ArrayList<String> getSizes() {
		
		ArrayList<String> sizes = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = conn.prepareStatement("SELECT Size FROM selection.faculty");
					ResultSet res = null;
					try {
						res = st.executeQuery();
						while(res.next()) {
							sizes.add(res.getString("Size"));
						}
						
						return sizes;
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
			return sizes;
		}
	}
}
>>>>>>> 554bd6d1502280087c1b6d4cd4bce7a74f6d35ae
